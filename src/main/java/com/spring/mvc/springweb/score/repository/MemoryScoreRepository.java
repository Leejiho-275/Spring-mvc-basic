package com.spring.mvc.springweb.score.repository;

import com.spring.mvc.springweb.score.domain.Score;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Repository("memoryScoreRepo")
public class MemoryScoreRepository implements ScoreRepository {

    // 학생들의 점수정보 객체(Score)를 저장할 Map 생성(메모리DB 역할)
    // key : 학번, value : 점수정보 객체
    private static Map<Integer, Score> scoreMap = new HashMap<>();

    static {
        scoreMap.put(1, new Score("김철수",99,78,67));
        scoreMap.put(2, new Score("박영희",85,66,87));
        scoreMap.put(3, new Score("고길동",75,100,93));
    }

    @Override
    public void insertScore(Score score) {
        scoreMap.put(score.getStuNum(), score);
        System.out.println(scoreMap);
    } //

    @Override
    public List<Score> sellectAllScores() {
        // map을 반복문으로 돌려서 value만 빼서 리스트에 담아 리턴
        List<Score> scoreList = new ArrayList<>();
        for (int key : scoreMap.keySet()) {
            Score score = scoreMap.get(key);
            scoreList.add(score);
        }
        return scoreList;
    }

    @Override
    public Score selectOne(int stuNum) {
        return scoreMap.get(stuNum);
    }

    @Override
    public void deleteScore(int stuNum) {
        scoreMap.remove(stuNum);
    }
}
