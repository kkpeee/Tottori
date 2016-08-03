package jp.co.tottori.controller;

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

import jp.co.tottori.dto.LibraryDto;
import jp.co.tottori.dto.MypageRentalDto;
import jp.co.tottori.dto.MypageReserveDto;
import jp.co.tottori.dto.MypageUserDto;
import jp.co.tottori.dto.UserDto;
import jp.co.tottori.form.LoginForm;
import jp.co.tottori.form.ReserveForm;
import jp.co.tottori.form.UserForm;
import jp.co.tottori.service.BookService;
import jp.co.tottori.service.LoginService;
import jp.co.tottori.service.ReserveService;
import jp.co.tottori.service.UserService;

@Controller
public class UserController {

    @Autowired
     UserService userService;

    @Autowired
     BookService bookService;

	@Autowired
	private LoginService loginService;

	@Autowired
	private ReserveService reserveService;

    //マイページログイン
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		LoginForm form = new LoginForm();
		model.addAttribute("loginForm", form);
		return "login";
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String getMypage(@Valid @ModelAttribute LoginForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "login";
		} else {
			MypageUserDto login  = loginService.getMypageUser(form.getId());
			if (login != null) {
			model.addAttribute("loginUser", login);
			MypageUserDto.setMypageUserDto(login);
			List<MypageReserveDto> reserves  = loginService.getMypageReserve(form.getId());
			MypageReserveDto.setMypageReserveDto(reserves);
			List<MypageRentalDto> rentals  = loginService.getMypageRental(form.getId());
			MypageRentalDto.setMypageRentalDto(rentals);
			model.addAttribute("mypageReserves", reserves);

			model.addAttribute("mypageRentals", rentals);
			return "myPage";
			} else {
				model.addAttribute("message", "エラー：ログインIDが間違っています");
				return "login";
			}
		}
	}

	@RequestMapping(value = "/reserveCancel", method = RequestMethod.POST)
	public String reserveCancel(@ModelAttribute ReserveForm form, Model model) {
		if(form.getReserve_id() != null) {
		    for (int i=0; i < form.getReserve_id().length; i++) {
		    	reserveService.reserveCancel(form.getReserve_id()[i]);
			}
	    }

		MypageUserDto login  = MypageUserDto.getMypageUserDto();
		List<MypageReserveDto> reserves  = loginService.getMypageReserve(login.getUser_id());
		MypageReserveDto.setMypageReserveDto(reserves);
		List<MypageRentalDto> rentals  = MypageRentalDto.getMypageRentalDto();

		model.addAttribute("loginUser", login);
		model.addAttribute("mypageReserves", reserves);
		model.addAttribute("mypageRentals", rentals);
				model.addAttribute("messages", "予約をキャンセルしました");
				return "myPage";
	}

    //マイページ表示
	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String mypage(Model model) {
		model.addAttribute("message", "マイページ画面");
		return "myPage";
	}

    //ユーザー登録
    @RequestMapping(value = "/userRegister", method = RequestMethod.GET)
    public String userInsert(Model model) {
		UserForm form = new UserForm();
		//各図書館の名前を持ってくる
		List<LibraryDto> library = bookService.library();
		model.addAttribute("userForm", form);
		model.addAttribute("Library", library);
        return "userRegister";
    }

    @RequestMapping(value = "/userRegister", method = RequestMethod.POST)
    public String userConfirm(@Valid @ModelAttribute UserForm form, BindingResult result, Model model) {
    	if (result.hasErrors()) {
    		UserDto.getUserDto().getUserId();
    		List<LibraryDto> library = bookService.library();
    		model.addAttribute("Library", library);
    		model.addAttribute("insertUser", form);
    		 return "userRegister";
    	} else {
    	UserDto dto = new UserDto();
    	BeanUtils.copyProperties(form, dto);
    	UserDto.setUserDto(dto);

    	List<String> messages = userService.userCheck(dto);
    	if (messages.size() != 0) {
			List<LibraryDto> library = bookService.library();
			model.addAttribute("Library", library);
			model.addAttribute("insertUser", dto);
	        model.addAttribute("messages", messages);
    		return "userRegister";
    	}
		List<LibraryDto> library = bookService.library();
		model.addAttribute("Library", library);
		model.addAttribute("insertUser", dto);
        return "userRegisterConfirm";
    	}
    }

    @RequestMapping(value = "/userRegisterConfirm", method = RequestMethod.GET)
    public String userConfirmInsert(Model model) {
    	UserDto dto = UserDto.getUserDto();
    	List<String> messages = userService.userCheck(dto);
    	//重複チェック
    	if (messages.size() == 0) {
    		userService.insert(dto);
    	}
    	messages.add("ユーザーの登録が完了しました");
        model.addAttribute("messages",messages);
    	return "home";
    }

    //ユーザー更新(検索)
    @RequestMapping(value = "/userSearch", method = RequestMethod.GET)
    public String userSearch(Model model) {

        UserForm form = new UserForm();
        model.addAttribute("userForm", form);
        return "userSearch";
    }

	@RequestMapping(value = "/userUpdate", method = RequestMethod.GET)
    public String userSearch(@ModelAttribute UserForm form, Model model) {
    	UserDto dto = new UserDto();
    	UserForm userForm = new UserForm();
    	BeanUtils.copyProperties(form, dto);
    	UserDto updateUser = userService.search(dto);
        List<LibraryDto> library = bookService.library();
        List<String> messages = new ArrayList<String>();
        model.addAttribute("Library", library);
    	if (dto.getUserId() == null) {
    		return "userUpdate";
    	}
    	model.addAttribute("userForm", userForm);
    	//ユーザーが見つからなかったとき
    	if(updateUser == null) {
    		messages.add("エラー：ユーザーが見つかりませんでした");
    		model.addAttribute("messages", messages);
    		return "userSearch";
    	}

    	model.addAttribute("updateUser", updateUser);

        return "userUpdate";
    }

    @RequestMapping(value = "/userUpdate", method = RequestMethod.POST)
    public String userUpdate(@Valid @ModelAttribute UserForm form, BindingResult result, Model model) {
    	if (result.hasErrors()) {
            List<LibraryDto> library = bookService.library();
            model.addAttribute("Library", library);
            model.addAttribute("updateUser", form);
            return "userUpdate";
    	} else {
    		UserDto dto = new UserDto();
    		BeanUtils.copyProperties(form, dto);
        	UserDto.setUserDto(dto);

        	List<String> messages = userService.userUpdateCheck(dto);
        	//重複チェック
        	if (messages.size() != 0) {
                model.addAttribute("messages", messages);
        		return "userSearch";
        	}
            List<LibraryDto> library = bookService.library();
            model.addAttribute("Library", library);
    		model.addAttribute("updateConfirmUser", dto);
    		return "userUpdateConfirm";
    	}
    }

    @RequestMapping(value = "/userUpdateConfirm", method = RequestMethod.GET)
    public String userConfirmUpdate(Model model) {
    	UserDto dto = UserDto.getUserDto();
    	UserForm userForm = new UserForm();
    	List<String> messages = userService.userUpdateCheck(dto);
    	//重複チェック
    	if (messages.size() == 0) {
    		userService.update(dto);
    	} else {
    		List<LibraryDto> library = bookService.library();
    		model.addAttribute("Library", library);
            model.addAttribute("messages", messages);

    		return "userSearch";
    	}
    	model.addAttribute("userForm", userForm);
        model.addAttribute("messages", messages);
    	messages.add("ユーザーの更新が完了しました");
    	return "home";
    }

    //ユーザー管理
    @RequestMapping(value = "/userManagement", method = RequestMethod.GET)
    public String userManagement(Model model) {
    	UserForm userForm = new UserForm();
        List<UserDto> users = userService.userManagement();
        model.addAttribute("userForm", userForm);
        model.addAttribute("Users", users);
        return "userManagement";
    }

    @RequestMapping(value = "/userManagement", method = RequestMethod.POST)
    public String userManagement(@ModelAttribute UserForm form, Model model) {
    	UserDto dto = new UserDto();
    	BeanUtils.copyProperties(form, dto);
    	userService.changeDate(dto);

    	return "redirect:/userManagement";
    }
}