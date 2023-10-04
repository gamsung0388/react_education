package com.example.boardTest.db;

import org.apache.ibatis.annotations.Mapper;

import com.example.boardTest.dto.BoardDto;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface BoardMapper {
	List<BoardDto> getBoardList(HashMap<String, Object> paramMap);
	
	int getBoardTotalCount(HashMap<String, Object> paramMap);
	
	BoardDto getBoardOne(Long idx);
	
	int insertBoard(BoardDto boardDto);
	
	int updateBoard(BoardDto boardDto);
	
	int deleteBoard(Long idx);
}