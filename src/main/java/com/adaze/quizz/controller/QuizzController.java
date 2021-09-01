package com.adaze.quizz.controller;

import com.adaze.quizz.pojo.Question;
import com.adaze.quizz.service.QuizzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuizzController {
    @Autowired
    QuizzService quizzService;

    @RequestMapping("/")
    public String tellThem(){
        return "Hello World";
    }

    @RequestMapping("/random-question")
    public Question getRandomQuestion(){
        return quizzService.randomQuestion();
    }

    @RequestMapping("/questions")
    public List<Question> getAllQuestions(){
        return quizzService.getAllQuestions();
    }

    @RequestMapping("/questions/{id}")
    public Question getSelectedQuestion(@PathVariable int id){
        return quizzService.getSelectedQuestion(id);
    }
}
