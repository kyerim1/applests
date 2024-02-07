package com.example.gradleTest1.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.gradleTest1.DTO.SimpleBbsDto;

@Repository
public class SimpleBbsDao implements SimpleBbsDaoImple{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	@Override
	public List<SimpleBbsDto> listDao() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SimpleBbsDto viewDao(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int writeDao(SimpleBbsDto simpleBbsDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteDao(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
