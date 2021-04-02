package com.spring.mvc.springweb.board.service;

import com.spring.mvc.springweb.board.domain.Board;
import com.spring.mvc.springweb.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Autowired
    public BoardService(@Qualifier("templateBoardRepo") BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public void insertBoard(Board board){
        boardRepository.insertArticle(board);
    }
}
