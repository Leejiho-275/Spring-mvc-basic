package com.spring.mvc.springweb.board.repository;

import com.spring.mvc.springweb.board.domain.Board;
import com.spring.mvc.springweb.domain.Grade;
import com.spring.mvc.springweb.score.domain.Score;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository("jdbcBoardRepo")
public class JdbcBoardRepository implements BoardRepository {

    private String userId = "java_web1";
    private String userPw = "202104";
    private String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe"; // DB접속 위치
    private String driverName = "oracle.jdbc.driver.OracleDriver"; // 드라이버 클래스 이름

    @Override
    public List<Board> getArticles() {

        List<Board> boardList = new ArrayList<>();
        Connection connection = null;
        try {
            Class.forName(driverName);

            connection = DriverManager.getConnection(dbUrl, userId, userPw);

            String sql = "SELECT * FROM tbl_board";
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                Board findBoard = new Board(
                        resultSet.getInt("board_no"),
                        resultSet.getString("writer"),
                        resultSet.getString("title"),
                        resultSet.getString("content")
                );

                boardList.add(findBoard);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return boardList;

    }

    @Override
    public void insertArticle(Board article) {
        Connection connection = null;
        try {
            // 드라이버 클래스 로딩
            Class.forName(driverName);

            // DB 연결정보 생성
            connection = DriverManager.getConnection(dbUrl, userId, userPw);

            // SQL 작성
            String sql = "INSERT INTO tbl_board "+"(board_no, writer, title, content) " + " VALUES(seq_score.nextval,?,?,?) ";

            // SQL을 실행할 객체 PreparedStatement 사용
            PreparedStatement statement = connection.prepareStatement(sql);
            // ? 값 채우기

            statement.setString(1, article.getWriter());
            statement.setString(2, article.getTitle());
            statement.setString(3, article.getContent());

            // sql 실행명령 (insert, update, delete) : executeUpdate()
            statement.executeUpdate();
            System.out.println("input success");

        } catch (Exception e) {
            System.out.println("input fail");
        } finally {
            try {
                // DB접속 해제
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public void deleteArticle(int boardNo) {

        Connection connection = null;
        try {
            // 드라이버 클래스 로딩
            Class.forName(driverName);

            // DB 연결정보 생성
            connection = DriverManager.getConnection(dbUrl, userId, userPw);

            // SQL 작성
            String sql = "DELETE FROM tbl_board WHERE board_no=?";

            // SQL을 실행할 객체 PreparedStatement 사용
            PreparedStatement statement = connection.prepareStatement(sql);
            // ? 값 채우기
            statement.setInt(1, boardNo);

            // sql 실행명령 (insert, update, delete) : executeUpdate()
            statement.executeUpdate();
            System.out.println("delete success");

        } catch (Exception e) {
            System.out.println("delete fail");
        } finally {
            try {
                // DB접속 해제
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    @Override
    public Board getContent(int BoardNo) {

        Connection connection = null;
        try {
            // 드라이버 클래스 로딩
            Class.forName(driverName);

            // DB 연결정보 생성
            connection = DriverManager.getConnection(dbUrl, userId, userPw);

            // SQL 작성
            String sql = "SELECT * FROM tbl_board WHERE board_no=?";

            // SQL을 실행할 객체 PreparedStatement 사용
            PreparedStatement statement = connection.prepareStatement(sql);
            // ? 값 채우기
            statement.setInt(1, BoardNo);

            ResultSet resultSet = statement.executeQuery();
            // sql 실행명령 (insert, update, delete) : executeUpdate()

            if (resultSet.next()) {

                return new Board(
                        resultSet.getInt("board_no"),
                        resultSet.getString("writer"),
                        resultSet.getString("title"),
                        resultSet.getString("content")
                );
            }
            System.out.println("data print success");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("data print fail");
        } finally {
            try {
                // DB접속 해제
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void modifyArticle(Board article) {

        Connection connection = null;
        try {
            // 드라이버 클래스 로딩
            Class.forName(driverName);

            // DB 연결정보 생성
            connection = DriverManager.getConnection(dbUrl, userId, userPw);

            // SQL 작성
            String sql = "UPDATE tbl_board SET writer=?, title=?, content=? WHERE board_no=?";

            // SQL을 실행할 객체 PreparedStatement 사용
            PreparedStatement statement = connection.prepareStatement(sql);
            // ? 값 채우기
            statement.setString(1, article.getWriter());
            statement.setString(2, article.getTitle());
            statement.setString(3, article.getContent());
            statement.setInt(4, article.getBoardNo());

            // sql 실행명령 (insert, update, delete) : executeUpdate()
            statement.executeUpdate();
            System.out.println("modify success");

        } catch (Exception e) {
            System.out.println("modify fail");
            e.printStackTrace();
        } finally {
            try {
                // DB접속 해제
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
}
