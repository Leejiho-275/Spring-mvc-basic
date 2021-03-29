package com.spring.mvc.springweb.controller;

import com.spring.mvc.springweb.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Controller
public class ResponseController {

    @GetMapping("/response/res-ex")
    public String resEx() {
        return "response/res-ex";
    }

    // Model 객체를 활용해 화면(view)에 데이터 전송하기
    @GetMapping("/response/test")
    public String test(int age, Model model) {
        // 화면으로 보낼 데이터를 모델객체에 세팅
        model.addAttribute("userAge", age);
        model.addAttribute("nick", "fds");
        return "response/test";
    }

    /*
    @GetMapping("/response/test2")
    public String test2(User user, Model model) {
        model.addAttribute("user", user);
        return "response/test2";
    }
    */

    // ModelAndView 객체를 활용한 처리
    // RestController : REST API 작업할 때 String을 리턴하게 되면
    // 브라우저로 문자열이 바로 전송되므로 화면을 포워딩할 때 쓰게 됨
    @GetMapping("/response/test2")
    public ModelAndView test2(User user) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("user", user);
        mv.setViewName("response/test2");
        return mv;
    }

    // ======================= 퀴즈 =============================
    @GetMapping("/response/res-login")
    public String login() {
        return "response/res-quiz";
    }

    @PostMapping("/response/res-login")
    public String login(User user, Model model) {

        model.addAttribute("user", user);
        if (user.getUserId().equals("kim123") && user.getUserPw().equals("kkk1234")) {
            return "response/res-quiz-success";
        } else return "response/res-quiz-fail";
    }
}
