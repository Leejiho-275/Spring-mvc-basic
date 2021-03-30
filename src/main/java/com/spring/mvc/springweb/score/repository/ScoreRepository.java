package com.spring.mvc.springweb.score.repository;

import com.spring.mvc.springweb.score.domain.Score;

import java.util.List;

public interface ScoreRepository {

    // 점수 저장 기능
    void insertScore(Score score);

    // 전체 점수 조회 기능
    List<Score> sellectAllScores();

    // 개별 점수 조회 기능
    Score selectOne(int stuNum);

    // 점수 삭제 기능
    void deleteScore(int stuNum);
}
