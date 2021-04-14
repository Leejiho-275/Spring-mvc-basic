package com.spring.mvc.springweb.board.api;

import com.spring.mvc.springweb.board.domain.Board;
import com.spring.mvc.springweb.board.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/api/board/*")
@RequiredArgsConstructor
public class BoardApiController {

    private final BoardMapper boardMapper;

    // 게시물 목록 페이지 열기
    @GetMapping("/list")
    public ModelAndView listPage() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("board-api/list");
        return mv;
    }

    // 게시물 상세보기 페이지 열기
    @GetMapping("/detail")
    public ModelAndView contentPage(int boardNo) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(("board-api/content"));
        mv.addObject("bno", boardNo);
        return mv;
    }

    // 게시물 전체 조회
    @GetMapping("/")
    public List<Board> list() {
        List<Board> boardList = boardMapper.getArticles();
        System.out.println("/api/board/ 조회 요청");
        return boardList;
    }

    // 게시물 개별 조회
    @GetMapping("/{boardNo}")
    public Board getBoard(@PathVariable int boardNo) {
        System.out.println("/api/board/" + boardNo + " GET 요청");
        return boardMapper.getContent(boardNo);
    }

    // 게시물 등록
    @PostMapping("/")
    public String register(@RequestBody Board article) {
        System.out.println("/api/board/ POST요청 발생 : " + article);
        boardMapper.insertArticle(article);
        return "regSuccess";
    }

    // 게시물 수정
    @PutMapping("/{boardNo}")
    public String modify(@PathVariable int boardNo, @RequestBody Board board) {
        board.setBoardNo(boardNo);
        System.out.println("/api/board/" + board + " PUT 요청");
        boardMapper.modifyArticle(board);
        return "modSuccess";
    }

    // 게시물 삭제
    @DeleteMapping("/{boardNo}")
    public String update(@PathVariable int boardNo) {
        System.out.println("/api/score/" + boardNo + " DELETE 요청");
        boardMapper.deleteArticle(boardNo);
        return "delSuccess";
    }
}
