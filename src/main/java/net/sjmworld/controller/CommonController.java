package net.sjmworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j;

@Controller @Log4j
public class CommonController {
	
	@GetMapping("customLogin")
	public String login(String error, String logout, Model model) {
		log.info("error: " + error);
//		log.info("logout: " + logout);
		
		if (error != null) {
			model.addAttribute("error", "Login error check your account");
		}
//		if (logout != null) {
//			model.addAttribute("logout", "Logout!!");
//		}
	
		return "/common/login";
	}

}
