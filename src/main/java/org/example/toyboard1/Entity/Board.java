package org.example.toyboard1.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.toyboard1.dto.BoardDto;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

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
    @Column
    private String content;
    private String writer;


    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @CreationTimestamp
    private LocalDateTime updatedAt;


    @OneToMany(mappedBy = "board",cascade = CascadeType.ALL)//cascade : 부모 보드가 삭제될때 그 댓글들도 모두 삭제 되어야 함
    private List<Comment> comments;

    public static BoardDto toBoardDto(Board board){
      BoardDto boardDto = new BoardDto();
      boardDto.setId(board.getId());
      boardDto.setTitle(board.getTitle());
      boardDto.setContent(board.getContent());
      boardDto.setWriter(board.getWriter());
      boardDto.setCreatedAt(board.getCreatedAt());
      boardDto.setUpdatedAt(board.getUpdatedAt());
      return boardDto;


    }



}
