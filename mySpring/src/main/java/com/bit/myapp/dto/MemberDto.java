package com.bit.myapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

//@AllArgsConstructor
@Data
public class MemberDto {
	
	private String id;
	private String pwd;
	private String name;
	private String email;

	
}
