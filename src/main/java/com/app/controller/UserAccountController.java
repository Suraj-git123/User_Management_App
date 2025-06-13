package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.entity.UserAccount;
import com.app.service.UserAccountService;

@Controller
public class UserAccountController {
	
	@Autowired
	private UserAccountService service;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("user", new UserAccount());
		return "index";
	}
	
	@PostMapping("/save-user")
	public String handleSubmitBtn(@ModelAttribute("user") UserAccount user ,Model model) {
		System.out.println(user);
		String msg = service.saveOrUpdateUserAcc(user);
		model.addAttribute("msg", msg);
		model.addAttribute("user", new UserAccount());
		return "index";
		
	}
	
	@GetMapping("/users")
	public  String getUsers(Model model) {
		List<UserAccount> usersList = service.getAllUserAccounts();
		model.addAttribute("users", usersList);
		return "view-users";
	}
	@GetMapping("/edit")
	public String editUserAcc(@RequestParam("id") Integer id ,Model model) {
		UserAccount userAcc = service.getUserAcc(id);
		model.addAttribute("user", userAcc);
		return "index";
	}
	@GetMapping("/delete")
	public String deleteUserAcc(@RequestParam("id") Integer id , Model model) {
		service.deleteUserAcc(id);
		model.addAttribute("msg", "User Record Deleted");
		return "forward:/users";
	}
	@RequestMapping("/update")
	public String statusUpdate(@RequestParam("id") Integer id,
			                   @RequestParam("status") String status , Model model) {
		
		service.updateUserAccountStatus(id, status);
		if("Y".equals(status)) {
			model.addAttribute("msg", "User Record Activated");
		}else {
			model.addAttribute("msg", "User Record De-Activated");
		}
		return "forward:/users";
	}

}
