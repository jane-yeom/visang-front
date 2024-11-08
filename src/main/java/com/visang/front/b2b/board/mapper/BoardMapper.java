package com.visang.front.b2b.board.mapper;

import com.visang.front.b2b.board.domain.Board;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface BoardMapper {
    List<Board> findAll();
    Board findById(Long id);
    void save(Board board);
    void update(Board board);
    void delete(Long id);
    void updateViewCount(Long id);
}