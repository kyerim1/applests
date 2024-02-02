package com.example.maventest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.maventest.DTO.memberDTO;
import com.example.maventest.service.MemberService;

@Controller
public class MainController {
	private final MemberService memberService;
	
	public MainController(MemberService memberService) {
		this.memberService=memberService;
	}
	
	@GetMapping("/")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	
	@GetMapping("/signup")
	public ModelAndView signup() {
		ModelAndView mv = new ModelAndView("signup");
		return mv;
	}
	
	@GetMapping("/signin")
	public ModelAndView signin() {
		ModelAndView mv = new ModelAndView("signin");
		return mv;
	}
	
	@PostMapping("/signup/Enroll")
	public ModelAndView signEnroll( @ModelAttribute memberDTO memberdto   ) {
		
		ModelAndView mv = new ModelAndView("index");
		System.out.println( memberdto.getEmail() );
		memberService.insert(memberdto);
		return mv;
	}
	
	
//	public ModelAndView signEnroll(
//			@RequestParam("email") String email, 
//			@RequestParam("pin") String pw, 
//			@RequestParam("name") String name,
//			@RequestParam("tel") String tel  ) {
//		
//		ModelAndView mv = new ModelAndView("index");
//		System.out.println( email );
//		
//		return mv;
//	}
}




