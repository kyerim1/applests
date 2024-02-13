package com.example.gradleTest2.contorl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.gradleTest2.DAO.SimpleBbsDaoImple;
import com.example.gradleTest2.DTO.SimpleBbsDto;

@Controller
public class BbsController {
	
	@Autowired
	SimpleBbsDaoImple simpleBbsDaoImple;
	
	//글 목록
	 @GetMapping("/list") 
	 public String listPage(Model model) {
		 
		 model.addAttribute("list" , simpleBbsDaoImple.list() );
		 return "list";
	 }
	 
	 //글쓰기
     @GetMapping("/writeForm")
     public String write(Model model) {
    	 model.addAttribute("simpleBbsDto", new SimpleBbsDto() );
    	 return "write";
     }
     
     //글쓰기
     @PostMapping("/write")
     public String write(@Valid SimpleBbsDto simpleBbsDto,
                             	BindingResult bind, Model model) {
    	 if(bind.hasErrors()) { // 작성된 값의 유효성검사를 통과하지못하면 작성페이지로
    		 return "write";
    	 }
    	 simpleBbsDaoImple.write(simpleBbsDto);
    	 
    	 return "redirect:/list";
     }
     
     //글보기
     @GetMapping("/view") 
     public String view(@RequestParam String id, Model model) {
    	 model.addAttribute("simpleBbsDto",simpleBbsDaoImple.view(id));
    	 return "view";
     }
     
   //글삭제
     @GetMapping("/delete") 
     public String delete(@RequestParam String id) {
    	 simpleBbsDaoImple.delete(id);
    	 return "redirect:/list";
     }
     
     //글수정
     @GetMapping("/updateForm") 
     public String updateForm(@RequestParam String id, 
                                         Model model) {
    	 model.addAttribute("simpleBbsDto", simpleBbsDaoImple.view(id) );
    	 return "update";
     }
     
     //글수정
     @PostMapping("/update") 
     public String update(@Valid SimpleBbsDto simpleBbsDto,
                                  BindingResult bind, Model model) {
    	 
    	 if(bind.hasErrors()) {
    		 return "update";
    	 }
    	 simpleBbsDaoImple.update(simpleBbsDto);
    	 
    	 return "redirect:/view?id="+simpleBbsDto.getId();
     }
     
     
}


/*
 	게시판 제작 
 	 글쓰기P, 수정P, 삭제, 글보기P, 목록P
 	 4페이지 제작
 	 글쓰기 양식 과 권한 - 제목,작성자, 내용 , 비밀번호
 	                   모든 접속 유저 
 	 수정 양식과 권한 - 제목, 내용
 	                 작성자 비밀번호
     삭제 권한 - 작성자
     글보기 양식과 권한 - 작성자, 제목, 내용
                      모든 유저
     
     
     뷰 페이지
       목록 - list.jsp
       글쓰기 - writeForm.jsp
       글수정 - updateForm.jsp
       글보기 - view.jsp
       
       
    프로그램 설계 - 스프링( controller -> DAO(DTO)
      패키지 - control, DAO, DTO
      데이터베이스 - mybatis
         control : BbsController
         DAO : SimpleBbsDaoImple 인터페이스
         DTO : SimpleBbsDto 클래스
         mybatis매퍼 : SimpleBbsDao xml
         
         BbsController
            목록 : /list(GET) - public String listPage(Model model) 메서드
            글쓰기 : /writeForm(GET) - public String write(Model model) 메서드
             저장 : /write(POST) - public String write(@Vaild SimpleBbsDto simpleBbsDto,
                                    	BindingResult bind, Model model) 메서드
            글보기 : /view(GET) - public String view(@RequestParam String id, Model model)메서드
            글수정 : /updateForm(POST) - public String updateForm(@RequestParam String id, 
                                                Model model)메서드
              저장 : /update(POST) - public String update(@Valid SimpleBbsDto simpleBbsDto,
                                         BindingResult bind, Model model) 메서드
            글삭제 : /delete(POST) - public String delete(@RequestParam String id)메서드
            
        SimpleBbsDaoImple
        	목록 : public List<SimpleBbsDto> list();
        	글작성 : public int write(SimpleBbsDto simpleBbsDto);
        	글보기 : public SimpleBbsDto view(String id);
        	글수정 : public int update(SimpleBbsDto simpleBbsDto);
        	글삭제 : public int delete(String id);
        	
        SimpleBbsDto 
            변수 - id(int), writer(String) , title(String), content(String)
            
        SimpleBbsDao.xml
          SimpleBbsDaoImple 인터페이스의 추상 메서드 구현
        
        
        
        
        
        
        
 
	
	고객 요청 - 추가질문 - 견적서 작성만큼만
	미팅 - 개발자 ( 팀장 -> 개발부서에서 선임 )
	당근 같은 사이트 개발
	로그인, 회원가입 - 회원가입 양식, 본인인증-통신사, 
	
	게시판 - 작성자 (로그인) , 제목x, 내용 O -> 이미지, 표, 링크 
	       ......
	   
   요구사항 분석 ->  설계 -> ui/ux , 관리
              ->  클래스, DB
	
	
*/







