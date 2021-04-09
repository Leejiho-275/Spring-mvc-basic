package com.spring.mvc.springweb.board.service;

import com.spring.mvc.springweb.board.domain.Board;
import com.spring.mvc.springweb.board.mapper.BoardMapper;
import com.spring.mvc.springweb.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    private final BoardRepository boardRepository;
    private final BoardMapper boardMapper;

    @Autowired
    public BoardService(@Qualifier("templateBoardRepo") BoardRepository boardRepository, BoardMapper boardMapper) {
        this.boardRepository = boardRepository;
        this.boardMapper = boardMapper;
    }

    public void insertBoard(Board board){
//        boardRepository.insertArticle(board);
        boardMapper.insertArticle(board);
    }
}
