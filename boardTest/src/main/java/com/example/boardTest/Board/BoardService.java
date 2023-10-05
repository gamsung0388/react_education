package com.example.boardTest.Board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.boardTest.db.BoardMapper;
import com.example.boardTest.dto.BoardDto;
import com.example.boardTest.util.Pagination;
import com.example.boardTest.util.Search;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardService {
	
    private final BoardMapper boardMapper;

    Map<String, Object> getBoardList(int page, int size, Search search) {
        HashMap<String, Object> paramMap = new HashMap<>();

        if (page <= 1) {    //페이지가 1 이하로 입력되면 0으로 고정,
            paramMap.put("page", 0);
        } else {            //페이지가 2 이상
            paramMap.put("page", (page - 1) * size);
        }
        paramMap.put("size", size);
        paramMap.put("sk", search.getSk());
        paramMap.put("sv", search.getSv());

        List<BoardDto> boardList = boardMapper.getBoardList(paramMap);
        Pagination pagination = new Pagination(
                boardMapper.getBoardTotalCount(paramMap),
                page,
                size,
                10
        );
        
        Map<String, Object> boardMap = new HashMap<>();
        
        boardMap.put("list", boardList);
        boardMap.put("page", pagination);
        
        return boardMap;
    }

    BoardDto getBoardOne(Long idx) {
        return boardMapper.getBoardOne(idx);
    }

    String insertBoard(BoardDto boardDto) {
    	boardMapper.insertBoard(boardDto);
    	    	    	
    	return "Y";
    }

    int updateBoard(BoardDto boardDto) {
    	return boardMapper.updateBoard(boardDto);
    }

    int deleteBoard(Long idx) {
    	return boardMapper.deleteBoard(idx);
    }
}
