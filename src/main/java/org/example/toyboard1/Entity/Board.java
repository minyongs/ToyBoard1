package org.example.toyboard1.Entity;

import jakarta.persistence.*;
import lombok.*;
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

}
