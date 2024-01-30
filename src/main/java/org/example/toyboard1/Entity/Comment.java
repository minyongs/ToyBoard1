package org.example.toyboard1.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String writer;
    private String content;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;
}
