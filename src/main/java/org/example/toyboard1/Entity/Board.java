package org.example.toyboard1.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.toyboard1.dto.BoardDto;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private String writer;


    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @CreationTimestamp
    private LocalDateTime updatedAt;

    public static BoardDto toBoardDto(Board board){
      BoardDto boardDto = new BoardDto();
      boardDto.setId(board.getId());
      boardDto.setTitle(board.getTitle());
      boardDto.setContent(board.getContent());
      boardDto.setCreatedAt(board.getCreatedAt());
      boardDto.setUpdatedAt(board.getUpdatedAt());
      return boardDto;


    }

}
