package com.example.gradleTest2.DTO;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class SimpleBbsDto {
	private int id;
	
	@NotEmpty(message="작성자를 입력하세요")
	private String writer;
	
	@NotEmpty(message="제목을 입력하세요")
	private String title;
	
	@NotEmpty(message="내용을 입력하세요")
	private String content;
}





