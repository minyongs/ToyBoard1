package org.example.toyboard1.controller.board;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.toyboard1.Entity.Board;
import org.example.toyboard1.dto.BoardDto;
import org.example.toyboard1.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping
    public String welcomePage(){
        return "board";
    }

    //글 목록
    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("board", boardService.showAll());
        return "list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, Model model){
        model.addAttribute("board",boardService.showDetail(id));
        return "detail";
    }

    @GetMapping("/register")
    public String registerGet(){
        return "register";

    }
    //데이터베이스에 저장만 한다
    @PostMapping("/registerPost")
    public String registerPost(@Valid @ModelAttribute BoardDto boardDto , BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "register"; // 에러가 있으면 폼 페이지로 반환
        }
        boardService.register(boardDto);
        return "redirect:/board/list";
    }
    @GetMapping("/update/{id}")
    public String updateGet(@PathVariable Long id,Model model){
        model.addAttribute("board",boardService.showDetail(id));

        return "update";

    }

    @PostMapping("/update")
    public String updatePost(BoardDto boardDto){
        boardService.update(boardDto);
        return "redirect:/board/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        boardService.deleteBoard(id);
        return "redirect:/board/list";

    }
}
