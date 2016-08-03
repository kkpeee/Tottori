package jp.co.tottori.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.tottori.dto.BlackListDto;
import jp.co.tottori.dto.BookDto;
import jp.co.tottori.dto.DocumentDto;
import jp.co.tottori.dto.LibraryDto;
import jp.co.tottori.dto.MypageRentalDto;
import jp.co.tottori.dto.RentalDto;
import jp.co.tottori.dto.SearchDto;
import jp.co.tottori.dto.StatusDto;
import jp.co.tottori.dto.UserDto;
import jp.co.tottori.form.BookForm;
import jp.co.tottori.form.BookRegisterForm;
import jp.co.tottori.form.BookStatusForm;
import jp.co.tottori.form.RentalForm;
import jp.co.tottori.form.UserForm;
import jp.co.tottori.service.BlackListService;
import jp.co.tottori.service.BookService;
import jp.co.tottori.service.ConfirmService;
import jp.co.tottori.service.ReserveService;
import jp.co.tottori.service.UserService;

@Controller
public class BookController {

    @Autowired
    private UserService userService;

    @Autowired
    public BlackListService blackListService;

    @Autowired
    public BookService bookService;

    @Autowired
    private ConfirmService confirmService;

	@Autowired
	private ReserveService reserveService;

    //図書登録 重複確認 既に登録されています
    @RequestMapping(value = "/bookRegister", method = RequestMethod.GET)
    public String bookInsert(Model model) {
        BookRegisterForm form = new BookRegisterForm();
        form.setIsbn(0);
        form.setShelfId(0);
		List<DocumentDto> documentName = reserveService.documentName();
		model.addAttribute("Document", documentName);
        //各図書館の名前を持ってくる
        List<LibraryDto> library = bookService.library();
        model.addAttribute("insertBook", form);
        model.addAttribute("Library", library);
        return "bookRegister";
    }

    @RequestMapping(value = "/bookRegister", method = RequestMethod.POST)
    public String bookInsert(@Valid @ModelAttribute BookRegisterForm form, BindingResult result, Model model) {
    	if (result.hasErrors()) {
            List<LibraryDto> library = bookService.library();
            model.addAttribute("Library", library);
			List<DocumentDto> documentName = reserveService.documentName();
			model.addAttribute("Document", documentName);
            form.setIsbn(0);
            form.setShelfId(0);
            model.addAttribute("insertBook", form);
            return "bookRegister";
    	} else {
    		BookDto dto = new BookDto();
    		BeanUtils.copyProperties(form, dto);
    		//入力した本の情報をセッションに保持
    		BookDto.setBookDto(dto);

    		List<String> messages = bookService.bookCheck(dto);
        	if (messages.size() != 0) {
    			List<LibraryDto> library = bookService.library();
    			model.addAttribute("Library", library);
    			model.addAttribute("insertBook", dto);
    	        model.addAttribute("messages", messages);
        		return "bookRegister";
        	}
            List<LibraryDto> library = bookService.library();
    		model.addAttribute("Library", library);
    		model.addAttribute("insertBook", dto);
    		return "bookRegisterConfirm";
    	}
    }

    @RequestMapping(value = "/bookRegisterConfirm", method = RequestMethod.GET)
    public String bookConfirmInsert(Model model) {
    	//入力情報をセッションからとりだし、Dtoにいれる
		BookDto dto = BookDto.getBookDto();
        BookForm bookForm = new BookForm();
		List<String> messages = bookService.bookCheck(dto);
    	//重複チェック
		if (messages.size() == 0) {
			bookService.insert(dto);
		}
		model.addAttribute("bookForm", bookForm);
        model.addAttribute("messages", messages);
    	messages.add("本の登録が完了しました");
    	return "home";
    }

    //返却画面ｓ
    @RequestMapping(value = "/returnBook", method = RequestMethod.GET)
    public String returnBook(Model model) {
    	RentalForm form = new RentalForm();//rentalテーブル以外
        List<LibraryDto> library = bookService.library();
        model.addAttribute("rentalForm", form);
        model.addAttribute("Library", library);
        return "returnBook";
    }

    @RequestMapping(value = "/returnBook", method = RequestMethod.POST)
    public String returnBook(@Valid @ModelAttribute RentalForm form, BindingResult result,Model model) {
    	//確認画面用のリスト
    	if (result.hasErrors()) {
            List<LibraryDto> library = bookService.library();
            model.addAttribute("Library", library);
            return "returnBook";
    	} else {
		List<SearchDto> returnList = new ArrayList<SearchDto>();
	    	for (int i=0; i < form.getIsbn().length; i++) {
				returnList.add(confirmService.getLendList(form.getIsbn()[i]));
			}
				model.addAttribute("ReturnList", returnList);
				//図書館のリスト
		    	List<LibraryDto> library = bookService.library();
		    	model.addAttribute("Library", library);

		    	RentalDto dto = new RentalDto();
		    	BeanUtils.copyProperties(form, dto);
		    	//返却の入力情報をセッションに保持
		    	RentalDto.setRentalDto(dto);

	    	//入力した本があるか
	    	for (int i = 0; i < dto.getIsbn().length; i++) {
		    	BookDto lend = bookService.lendConfirm(dto, dto.getIsbn()[i]);
		    	if (lend == null) {
		    		model.addAttribute("message", "図書が見つかりません");
		    		return "returnBook";
		    	}
		    	if (lend.getStatusId() != 2) {
		    		model.addAttribute("message", "返却済みです");
		    		return "returnBook";
		    	}
	    	}
	    	return "returnConfirm";
        }
    }

    @RequestMapping(value = "/returnConfirm", method = RequestMethod.GET)
    public String returnConfirm(Model model) {
    	RentalDto dto = RentalDto.getRentalDto();

    //返却実行(複数)
   	 bookService.returnBook(dto, dto.getIsbn().length);
   	 //bookテーブルのステータスを3に
   	 bookService.updateStatus(3, dto, dto.getIsbn().length);
   	 model.addAttribute("messages", "返却が完了しました");
   	return "home";
    }

	//貸出
    @RequestMapping(value = "/lendBook", method = RequestMethod.GET)
    public String lendBook(Model model) {
    	RentalForm form = new RentalForm();
    	//各図書館の名前を持ってくる
        List<LibraryDto> library = bookService.library();
        model.addAttribute("rentalForm", form);
        model.addAttribute("Library", library);
        return "lendBook";
    }

    @RequestMapping(value = "/lendBook", method = RequestMethod.POST)
    public String lendBook(@Valid @ModelAttribute RentalForm form, BindingResult result,Model model) throws ParseException {
    	if (result.hasErrors()) {
            List<LibraryDto> library = bookService.library();
            model.addAttribute("Library", library);
            return "lendBook";
    	} else {
	    	List<SearchDto> lendList = new ArrayList<SearchDto>();
	    	if(form.getIsbn() != null) {
		    	for (int i=0; i < form.getIsbn().length; i++) {
					lendList.add(confirmService.getLendList(form.getIsbn()[i]));
				}
	    	}
			model.addAttribute("LendList", lendList);
	    	RentalDto dto = new RentalDto();
	    	BeanUtils.copyProperties(form, dto);
	    	RentalDto.setRentalDto(dto);
	    	List<String> messages = new ArrayList<String>();
	    	//更新していない
			if (userService.updateConfirm(dto)) {
		    	UserDto userDto = new UserDto();
		    	userDto.setUserId(dto.getUserId());
		    	UserDto updateUser = userService.search(userDto);
		    	model.addAttribute("userForm", updateUser);
		        List<LibraryDto> library = bookService.library();
		        model.addAttribute("Library", library);
				return "userSearch";
			}

			//延滞しているか ユーザーIDを使う必要あり
			List<MypageRentalDto> delinquentBook = bookService.delinquentBook(dto);

			if (delinquentBook.size() != 0) {
				model.addAttribute("RentalBook", delinquentBook);
				return "delinquentUser";
			}

			//８冊以上借りている
			List<MypageRentalDto> rentalBook = bookService.rentalConfirm(dto);
			if (rentalBook.size() >= 8) {
		        List<LibraryDto> library = bookService.library();
		        messages.add("既に8冊借りています");
		        model.addAttribute("rentalForm", form);
		        model.addAttribute("Library", library);
		        model.addAttribute("messages", messages);
		        return "lendBook";
			}

        return "lendConfirm";
    	}
	}

	//貸出確認
    @RequestMapping(value = "/lendConfirm", method = RequestMethod.GET)
    public String lendConfirm(Model model) {
     	List<String> messages = new ArrayList<String>();

    	RentalDto dto = RentalDto.getRentalDto();
    	bookService.rental(dto, dto.getIsbn().length);
		//bookテーブルのステータスを2に
		bookService.updateStatus(2, dto, dto.getIsbn().length);
    	model.addAttribute("messages", messages);
    	messages.add("貸出が完了しました");
    	return "home";
    }


    //ブラックリスト
	@RequestMapping(value = "/blackList", method = RequestMethod.GET)
	public String blackList(Model model) {
		List<BlackListDto> blackList  = blackListService.getBlackList();
		model.addAttribute("blackList", blackList);
		return "blackList";
    }

    //ステータス変更
    @RequestMapping(value = "/changeStatus", method = RequestMethod.GET)
    public String changeStatus(Model model) {
    	BookForm form = new BookForm();
    	List<StatusDto> status = bookService.status();
    	List<LibraryDto> library = bookService.library();
    	model.addAttribute("Status", status);
    	model.addAttribute("Library", library);
    	model.addAttribute("bookForm", form);
        return "changeStatus";
    }

    @RequestMapping(value = "/changeStatus", method = RequestMethod.POST)
    public String changeStatus(@Valid @ModelAttribute BookStatusForm form,BindingResult result, Model model) {
    	if (result.hasErrors()) {
            List<LibraryDto> library = bookService.library();
            model.addAttribute("Library", library);
        	List<StatusDto> status = bookService.status();
        	model.addAttribute("Status", status);
            model.addAttribute("insertUser", form);
            return "changeStatus";
    	} else {
    	BookDto dto = new BookDto();
    	BeanUtils.copyProperties(form, dto);
    	List<String> messages = new ArrayList<String>();

    	bookService.changeStatus(dto);
    	messages.add("ステータスを変更しました");
    	BookForm nextForm = new BookForm();
    	List<StatusDto> status = bookService.status();
    	List<LibraryDto> library = bookService.library();
    	model.addAttribute("Status", status);
    	model.addAttribute("Library", library);
    	model.addAttribute("bookForm", nextForm);
    	model.addAttribute("messages", messages);
    	return "changeStatus";
    	}
    }

    //時間変更
    @RequestMapping(value = "/changeTime", method = RequestMethod.GET)
    public String changeTime(Model model) {
    	UserForm form = new UserForm();
    	model.addAttribute("userForm", form);
        return "changeTime";
    }

    //本管理
    @RequestMapping(value = "/bookManagement", method = RequestMethod.GET)
    public String bookManagement(Model model) {
        List<BookDto> book = bookService.bookManagement();
        List<MypageRentalDto> rental = bookService.rentalManagement();
    	RentalForm rentalForm = new RentalForm();
        model.addAttribute("rentalForm", rentalForm);
        model.addAttribute("Books", book);
        model.addAttribute("Rental", rental);
        return "bookManagement";
    }

    @RequestMapping(value = "/bookManagement", method = RequestMethod.POST)
    public String bookManagement(@ModelAttribute RentalForm form, Model model) {
    	RentalDto dto = new RentalDto();
    	BeanUtils.copyProperties(form, dto);
    	bookService.changeDate(dto);

    	return "redirect:/bookManagement";
    }
}