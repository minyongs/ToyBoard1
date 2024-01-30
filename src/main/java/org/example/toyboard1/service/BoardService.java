package org.example.toyboard1.service;

import lombok.RequiredArgsConstructor;
import org.example.toyboard1.Entity.Board;
import org.example.toyboard1.dto.BoardDto;
import org.example.toyboard1.repository.BoardRepository;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void register(BoardDto boardDto){
        Board board = BoardDto.toBoardEntity(boardDto);
        boardRepository.save(board);
    }

    //전체목록
    // 리스트를 가져와서 BoardDTO 로 변환
    public List<BoardDto> showAll (){
        return boardRepository.findAll(Sort.by(Sort.Direction.DESC, "id"))
                .stream()
                .map(Board::toBoardDto)
                .collect(Collectors.toList());
    }



    //디테일
    public BoardDto showDetail(Long id){
        return boardRepository.findById(id)
                .map(Board::toBoardDto)
                .orElse(null);
    }


    //업데이트

    public void update(BoardDto boardDto){

        Board board = BoardDto.toBoardEntity(boardDto);
        boardRepository.save(board);
    }


    //삭제
    public void deleteBoard(Long id){
        boardRepository.deleteById(id);
    }



}
