package com.spring.mvc.springweb.controller;

import com.spring.mvc.springweb.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

// 스프링의 디스페처 서블릿에 컨트롤러가 등록
@Controller
public class requestController {

    // 요청 처리 메서드 ( 요청 처리 서블릿 역할 )
    @GetMapping("/req/test") // 해당에 URL에 따른 GET요청을 처리하게 함
    public String testCall() {
        System.out.println("============================");
        System.out.println("\n## GET: /req/test!\n");
        System.out.println("============================");
        return "test";
    }

    // request 폴더에 있는 req-ex01.jsp를 열기 위한 요청
    @GetMapping("/request")
    public String req() {
        return "request/req-ex01";
    }

    // GET : "/request/basic01" 처리 메서드
    @GetMapping("/request/basic01")
    public String basicGet() {
        System.out.println("\n## /request/basic01 : GET");
        return "request/req-ex01";
    }

    // POST : "/request/basic01" 처리 메서드
    @PostMapping("/request/basic01")
    public String basicPost() {
        System.out.println("\n## /request/basic01 : POST");
        return "request/req-ex01";
    }

    // 요청 파라미터 받아보기
    @GetMapping("/request/param")
    public String param(HttpServletRequest request) {
        String money = request.getParameter("money");
        System.out.println("money = " + money);
        return "test";
    }

    @GetMapping("/request/param2")
    public String param2(int money, String name) {
        System.out.println("money = " + (money * 2));
        System.out.println("name = " + name);
        return "test";
    }

    // 커맨드 객체를 통한 요청 파라미터 처리
    @PostMapping("/request/param3")
    public String param3(User user) {
        System.out.println(user);
        return "test";
    }

    // GET요청으로 /request/join-form이 들어왔을 때 join.jsp를 여는 메스드를 제작
    @GetMapping("/request/join-form")
    public String join(User user) {
        System.out.println(user);
        return "request/join";
    }

    @GetMapping("/request/quiz")
    public String quiz() {
        return "request/req-quiz";
    }

    @PostMapping("/request/quiz")
    public String quiz(User user) {
        System.out.println(user);
        // if (user.getUserId().equals("abc1234")
        if (Objects.equals(user.getUserId(), "abc1234") && Objects.equals(user.getUserPw(), "xxx4321")) {
            return "request/success";
        } else return "request/fail";
    }

}
