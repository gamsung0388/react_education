package com.example.boardTest.db;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileMapper {
	public int insertFile(Map<String, Object> map);
}
