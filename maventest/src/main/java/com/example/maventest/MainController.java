package com.example.maventest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@GetMapping("/")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView("index");
		
		return mv;
	}
	
	@GetMapping("/signup")
	public String signup() {
		return "signup.html";
	}
}
