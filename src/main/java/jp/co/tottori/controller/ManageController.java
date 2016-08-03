package jp.co.tottori.controller;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import jp.co.tottori.dto.LibraryDto;
import jp.co.tottori.dto.ManageDto;
import jp.co.tottori.form.ManageForm;
import jp.co.tottori.service.ManageService;

@Controller
@SessionAttributes("loginManager")
public class ManageController {
	@Autowired
    private ManageService manageService;


	@RequestMapping(value = "manageLogin", method = RequestMethod.GET)
	public String manageLogin(Model model){
		ManageForm form = new ManageForm();
		model.addAttribute("ManageForm", form);
		return "manageLogin";
	}

	@RequestMapping(value = "/manageLogin", method = RequestMethod.POST)
	public String manageLogin(@Valid @ModelAttribute ManageForm form, BindingResult result, Model model){
		if (result.hasErrors()) {
			return "manageLogin";
		}else{
			ManageDto dto = new ManageDto();
			BeanUtils.copyProperties(form, dto);
			ManageDto loginUser = manageService.getManager(dto);
			ManageDto.setManageDto(dto);
			if (loginUser == null) {
				model.addAttribute("message", "ログインできませんでした");
				model.addAttribute("ManageForm", form);
				return "manageLogin";
			} else {
				return "home";
			}
		}
	}
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String home(Model model){
		LibraryDto dto = new LibraryDto();
		model.addAttribute("LibraryName", dto);
		return "home";
	}
}