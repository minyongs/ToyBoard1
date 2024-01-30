package org.example.toyboard1.dto;


import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.example.toyboard1.Entity.Board;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;

@Getter
@Setter
public class BoardDto {

    private Long id;

    @NotEmpty(message = "제목을 입력하세요")
    private String title;
    @NotEmpty(message = "내용을 입력하세요")
    private String content;
    @NotEmpty(message = "작성자를 입력하세요")
    private String writer;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public static Board toBoardEntity(BoardDto boardDto) {
        Board board = new Board();
        board.setId(boardDto.getId());
        board.setTitle(boardDto.getTitle());
        board.setContent(boardDto.getContent());
        board.setWriter(boardDto.getWriter());
        board.setCreatedAt(boardDto.getCreatedAt());
        board.setUpdatedAt(boardDto.getUpdatedAt());
        return board;


    }
}
