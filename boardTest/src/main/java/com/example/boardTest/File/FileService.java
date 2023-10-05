package com.example.boardTest.File;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.boardTest.db.FileMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FileService {
	
	private final FileMapper fileMapper;
	
	//파일저장 db
	public int insertFile(Map<String, Object> params) {
		return fileMapper.insertFile(params);		
	}
	
	
}
