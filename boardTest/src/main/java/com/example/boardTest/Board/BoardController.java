package com.example.boardTest.Board;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.boardTest.dto.BoardDto;
import com.example.boardTest.util.Search;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins="http://localhost:3030")
public class BoardController {
	
	private final BoardService boardService;

    @GetMapping("/board")
    Map<String, Object> getBoardList(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, Search search) {
    	System.out.println("page: " + page);
    	System.out.println("page: " + size);
    	System.out.println("page: " +  search);
        return boardService.getBoardList(page, size, search);
    }

    //idx의 데이터 1개를 조회한다.
    @GetMapping("/board/{idx}")
    BoardDto getBoardOne(@PathVariable Long idx) {
    	System.out.println("1:                 " + boardService.getBoardOne(idx));
        return boardService.getBoardOne(idx);
    }

    @PostMapping("/board")    
    String insertBoard(@RequestPart(value="board") BoardDto BoardDto) {
    	System.out.println("BoardDto: " + BoardDto);
    	boardService.insertBoard(BoardDto);
        return "Y";
    }
    
    @PatchMapping("/board")
    int updateBoard(@RequestBody BoardDto BoardDto) {
        return boardService.updateBoard(BoardDto);
    }

    @DeleteMapping("/board/{idx}")
    int deleteBoard(@PathVariable Long idx) {
        return boardService.deleteBoard(idx);
    }
}
