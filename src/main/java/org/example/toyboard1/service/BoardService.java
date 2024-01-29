package org.example.toyboard1.service;

import lombok.RequiredArgsConstructor;
import org.example.toyboard1.Entity.Board;
import org.example.toyboard1.repository.BoardRepository;
import org.springframework.data.domain.Sort;

import java.util.List;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void register(Board board){
        boardRepository.save(board);
    }

    //전체목록

    public List<Board> showAll (){
        return boardRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }



    //디테일
    public Board showDetail(Long id){
        return boardRepository.findById(id).orElse(null);
    }


    //업데이트

    public void update(Board board){
        boardRepository.save(board);
    }


    //삭제
    public void deleteBoard(Long id){
        boardRepository.deleteById(id);
    }



}
