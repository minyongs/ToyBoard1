package org.example.toyboard1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.toyboard1.Entity.Board;

import java.time.LocalDateTime;

@Getter
@Setter
public class BoardDto {

    private Long id;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public static Board toBoardEntity(BoardDto boardDto) {
        Board board = new Board();
        board.setId(boardDto.getId());
        board.setTitle(boardDto.getTitle());
        board.setContent(boardDto.getContent());
        board.setCreatedAt(boardDto.getCreatedAt());
        board.setUpdatedAt(boardDto.getUpdatedAt());
        return board;


    }
}
