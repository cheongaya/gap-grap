package com.roovalant.gapgrap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    // [1] View 테스트 (./resources/templates 폴더 내)
    @GetMapping("hello")
    public String hello(Model model) {
        // 키값 : data, 값 : hello!!!
        model.addAttribute("data", "hello!!!");
        return "hello"; // 리턴 값은 = /resources/templates 폴더 내 파일 이름
    }

    @GetMapping("error")
    public String error(Model model) {
        model.addAttribute("error", 500);
        return "error"; // 리턴 값은 = /resources/templates 폴더 내 파일 이름
    }

    // [2] MVC 테스트 (URL : http://localhost:8090/hello-mvc?name=kiki)
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template"; // 리턴 값은 = /resources/templates 폴더 내 파일 이름
    }

    // [3] API 테스트 (@ResponseBody 에 응답 데이터("hello spring" 문자열 그대로)를 넣어주겠다 라는 의미)
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; // 문자열 리턴
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);

        return hello; // 객체를 JSON 형태로 리턴 {"name": "gaga"}
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
