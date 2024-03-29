package com.example.maventest.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.maventest.DAO.MemberDAO;
import com.example.maventest.DTO.memberDTO;

@Service
public class MemberService implements aa{
	private final MemberDAO memberdao ;
	
	@Autowired
	public MemberService(MemberDAO memberdao) {
		this.memberdao=memberdao;
	}
	
	
	//회원가입 저장 메서드
	public void insert(memberDTO memberdto) {
		memberDTO memberdto =new memberDTO();
		memberdao.insert(memberdto);
	}
	
	
	// 로그인 처리 메서드
	public String login(Map<String,String> param) {
		
		return memberdao.findMemberByemailpw(param.get("email"), param.get("pin"));
	}
	
	
	public void update(Map<String,String> p) {
		memberdao.update(p.get("email"),p.get("pin"),p.get("name"),
				p.get("tel"),p.get("repin"));
	}
	
}





