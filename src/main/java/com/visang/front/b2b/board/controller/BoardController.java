package com.visang.front.b2b.board.controller;

import com.visang.front.b2b.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

   private final BoardService boardService;

   // 게시판 목록 페이지
   @GetMapping
   public String list(Model model) {
       model.addAttribute("boards", boardService.findAll());
       return "board/list";  // templates/board/list.mustache를 찾음
   }

   // 게시글 상세 페이지
   @GetMapping("/{id}")
   public String detail(@PathVariable Long id, Model model) {
       model.addAttribute("board", boardService.findById(id));
       return "board/detail";
   }

   // 게시글 작성 페이지
   @GetMapping("/write")
   public String writeForm() {
       return "board/write";
   }

   // 게시글 수정 페이지
   @GetMapping("/{id}/edit")
   public String editForm(@PathVariable Long id, Model model) {
       model.addAttribute("board", boardService.findById(id));
       return "board/edit";
   }
}