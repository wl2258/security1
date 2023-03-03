package com.cos.security1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // view를 리턴하겠다
public class IndexController {

    @GetMapping({"", "/"})
    public String index() {
        // 머스테치 기본폴더 src/main/resources
        // 뷰리졸버 설정 : templates(prefix), .mustache(suffix) -> yml 파일에 (그러나 생략가능 기본 설정됨)
        return "index"; // src/main/resources/templates/index.mustache
    }

    @GetMapping("/user")
    public @ResponseBody String user() {
        return "user";
    }

    @GetMapping("/admin")
    public @ResponseBody String admin() {
        return "admin";
    }

    @GetMapping("/manager")
    public @ResponseBody String manager() {
        return "manager";
    }

    // 스프링 시큐리티가 낚아챔 - securityConfig 파일 생성 후 작동 안 함
    @GetMapping("/login")
    public @ResponseBody String login() {
        return "login";
    }

    @GetMapping("/join")
    public @ResponseBody  String join() {
        return "join";
    }

    @GetMapping("/loginProc")
    public @ResponseBody String loginProc() {
        return "회원가입 완료됨!!";
    }
}
