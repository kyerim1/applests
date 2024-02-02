package com.example.maventest.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.maventest.DTO.memberDTO;

@Repository
public class MemberDAO {
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public MemberDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate;
	}
	
	//회원가입 데이터베이스에 저장
	public void insert(memberDTO memberdto) {
		String sql="insert into member(email, pw, name, tel) "
				+" values(?,?,?,?)";
		jdbcTemplate.update(sql, memberdto.getEmail(), 
				memberdto.getPin(), memberdto.getName() ,
				memberdto.getTel()  );
	}
}








