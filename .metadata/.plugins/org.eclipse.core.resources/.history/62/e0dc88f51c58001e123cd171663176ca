package com.example.boardTest.dto;

import com.example.boardTest.db.BoardEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardSaveDto {
    private int idx;
    private String contents;
	private String created_at;
	private String created_by;
	private String title;

    
    
    
    public BoardEntity toEntity() {
        return BoardEntity.builder()
                .idx(idx)
                .title(title)
                .contents(contents)
                .created_at(created_at)
                .created_by(created_by)
                .build();
    }
}
