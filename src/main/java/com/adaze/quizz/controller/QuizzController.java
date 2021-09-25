package com.adaze.quizz.controller;

import com.adaze.quizz.pojo.Question;
import com.adaze.quizz.service.QuizzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return quizzService.getAllQuestionsR();
    }

    @RequestMapping("/questions/{id}")
    public Question getSelectedQuestion(@PathVariable int id){
        return quizzService.getSelectedQuestion(id);
    }

    @RequestMapping("/questions/category/{category}")
    public List<Question> getCategorizedQuestions(@PathVariable String category){
        return quizzService.getCategorizedQuestions(category);
    }

    @PostMapping("/questions/add-question")
    public String addQuestion(@RequestBody Question question){
        quizzService.addQuestionR(question);
        String response= "Question successfully added";
        return response;
    }
}
