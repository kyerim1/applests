package com.example.maventest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.maventest.DAO.MemberDAO;
import com.example.maventest.DTO.memberDTO;

@Service
public class MemberService {
	private final MemberDAO memberdao ;
	
	@Autowired
	public MemberService(MemberDAO memberdao) {
		this.memberdao=memberdao;
	}
	
	
	//회원가입 저장 메서드
	public void insert(memberDTO memberdto) {
		memberdao.insert(memberdto);
	}
	
	
}
