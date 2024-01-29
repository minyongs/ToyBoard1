package org.example.toyboard1.repository;

import org.example.toyboard1.Entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Long> {
}
