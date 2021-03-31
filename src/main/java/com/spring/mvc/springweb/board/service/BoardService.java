package com.spring.mvc.springweb.board.service;

import com.spring.mvc.springweb.board.domain.Board;
import com.spring.mvc.springweb.board.repository.BoardRepository;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public void insertBoard(Board board){
        boardRepository.insertArticle(board);
    }
}
