package com.sds.movieapp.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

//mongoDB  DTO
@Data
@Document(collation = "member")
public class MemberDoc {
	
	@Id
	private String id;
	
	private int member_idx;
}
