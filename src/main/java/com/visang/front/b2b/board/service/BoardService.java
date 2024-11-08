package com.visang.front.b2b.board.service;

import com.visang.front.b2b.board.domain.Board;
import com.visang.front.b2b.board.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

   private final BoardMapper boardMapper;

   // 게시글 목록 조회
   public List<Board> findAll() {
       return boardMapper.findAll();
   }

   // 게시글 상세 조회 (조회수 증가 포함)
   public Board findById(Long id) {
       // 조회수 증가
       boardMapper.updateViewCount(id);
       // 게시글 조회
       return boardMapper.findById(id);
   }

   // 게시글 저장
   public void save(Board board) {
       // 제목이나 내용이 비어있는지 체크
       if (board.getTitle() == null || board.getTitle().trim().isEmpty()) {
           throw new IllegalArgumentException("제목은 필수 입력 항목입니다.");
       }
       if (board.getContent() == null || board.getContent().trim().isEmpty()) {
           throw new IllegalArgumentException("내용은 필수 입력 항목입니다.");
       }

       boardMapper.save(board);
   }

   // 게시글 수정
   public void update(Board board) {
       // 게시글 존재 여부 체크
       Board existingBoard = boardMapper.findById(board.getId());
       if (existingBoard == null) {
           throw new IllegalArgumentException("존재하지 않는 게시글입니다.");
       }

       // 제목이나 내용이 비어있는지 체크
       if (board.getTitle() == null || board.getTitle().trim().isEmpty()) {
           throw new IllegalArgumentException("제목은 필수 입력 항목입니다.");
       }
       if (board.getContent() == null || board.getContent().trim().isEmpty()) {
           throw new IllegalArgumentException("내용은 필수 입력 항목입니다.");
       }

       boardMapper.update(board);
   }

   // 게시글 삭제
   public void delete(Long id) {
       // 게시글 존재 여부 체크
       Board board = boardMapper.findById(id);
       if (board == null) {
           throw new IllegalArgumentException("존재하지 않는 게시글입니다.");
       }

       boardMapper.delete(id);
   }

   // 페이징 처리를 위한 메서드 추가 (나중에 구현)
   public List<Board> findAllWithPaging(int page, int size) {
       // TODO: 페이징 처리 구현
       return boardMapper.findAll();
   }

   // 검색 기능을 위한 메서드 추가 (나중에 구현)
   public List<Board> search(String keyword) {
       // TODO: 검색 기능 구현
       return boardMapper.findAll();
   }
}