package com.example.boardTest.Board;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.boardTest.db.BoardEntity;
import com.example.boardTest.dto.BoardSaveDto;
import com.example.boardTest.util.Header;
import com.example.boardTest.util.Search;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins="http://localhost:3030")
public class BoardController {
	private final BoardService boardService;

    //Http Get 방식으로 주소 가장 뒤 /board로 접근
    @GetMapping("/board")
    Header<List<BoardEntity>> getBoardList(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, Search search) {
        return boardService.getBoardList(page, size, search);
    }

    //idx의 데이터 1개를 조회한다.
    @GetMapping("/board/{idx}")
    Header<BoardEntity> getBoardOne(@PathVariable Long idx) {
    	System.out.println("1:                 " + boardService.getBoardOne(idx));
        return boardService.getBoardOne(idx);
    }

    @PostMapping("/board")
    Header<BoardEntity> createBoard(@RequestBody BoardSaveDto boardSaveDto) {
        return boardService.insertBoard(boardSaveDto);
    }

    @PatchMapping("/board")
    Header<BoardEntity> updateBoard(@RequestBody BoardSaveDto boardSaveDto) {
        return boardService.updateBoard(boardSaveDto);
    }

    @DeleteMapping("/board/{idx}")
    Header<String> deleteBoard(@PathVariable Long idx) {
        return boardService.deleteBoard(idx);
    }
}
