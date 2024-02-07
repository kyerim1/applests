package com.example.gradleTest1.DTO;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class MemberDto {
	@Email
	private String email;
	
	@NotBlank(message="name is not input")
	private String name;
	
	@NotBlank(message="비밀번호를 입력하세요")
	@Size(min=6, message="비밀번호는 6자리 이상입니다.")
	private String password;
	
	@NotBlank(message="도시를 입력하세요")
	private String city;
	
	@NotBlank(message="주소를 입력하세요")
	private String state;
	
	@NotBlank(message="우편번호를 입력하세요")
	@Digits(integer=5, fraction=0, message="우편번호는5자리 숫자입니다.")
	private String zipCode;
}

/*
		@NotNull  - null 불가
		@Null - null만 입력 가능
		@NotEmpty -  null, 빈문자열 불가
		@NotBlack - null, 빈문자열, 스페이스공간 불가
		@Size(min , max) - 문자열, 배열의 크기가 만족한가?
		@Pattern(regex=) - 정규식 만족?
		@Max(숫자) - 지정값 이하?
		@Min(숫자) - 지정값 이상?
		@Email - 이메일 형식인가?
		@Digits(integer, fraction) - 지정된 정수와 소수자리 만족?
		@Future - 지금 보다 앞일인가?  미래
		@Past - 지금보다 과거인가?
 */












