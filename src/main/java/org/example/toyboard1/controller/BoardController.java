package org.example.toyboard1.controller;

import lombok.RequiredArgsConstructor;
import org.example.toyboard1.Entity.Board;
import org.example.toyboard1.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping("detail/{id}")
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
    public String registerPost(Board board){
        boardService.register(board);
        return "redirect:/board/list";
    }
    @GetMapping("/update/{id}")
    public String updateGet(@PathVariable Long id,Model model){
        model.addAttribute("board",boardService.showDetail(id));

        return "update";

    }

    @PostMapping("/update")
    public String updatePost(Board board){
        boardService.update(board);
        return "redirect:/board/list";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable Long id){
        boardService.deleteBoard(id);
        return "list";

    }
}
