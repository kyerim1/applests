package com.example.gradleTest1.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.gradleTest1.DAO.SimpleBbsDaoImple;
import com.example.gradleTest1.DTO.SimpleBbsDto;

@Controller
public class BbsController {
	
	@Autowired
	SimpleBbsDaoImple simpleBbsDaoImple;
	
	
	@RequestMapping(value="/board" ,method=RequestMethod.GET)
	public String root() {
		
		return "list";
	}
	
	@RequestMapping("/writeForm")
	public String writeForm(Model model) {
		model.addAttribute("simpleBbsDto",new SimpleBbsDto());
		return "writeForm";
	}
	
	@RequestMapping("/write")
	public String write( SimpleBbsDto simpleBbsDto ) {
		//작성한 내용을 유효성 검사하고 데이터베이스에 저장 하기
		
		simpleBbsDaoImple.writeDao(simpleBbsDto);
		
		return "redirect:/board";
	}
}










