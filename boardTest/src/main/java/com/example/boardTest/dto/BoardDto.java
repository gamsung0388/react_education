package com.example.boardTest.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardDto {
    private int idx;
    private String contents;
	private String createdman;
	private String createdate;
	private String title;
    
}
