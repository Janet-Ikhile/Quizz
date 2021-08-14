package com.adaze.Quizz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuizzController {

    @RequestMapping("/")
    public String tellThem(){
        System.out.println("Hello");
        return "Hello World";
    }
}
