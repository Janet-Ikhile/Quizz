package com.adaze.quizz.controller;

import com.adaze.quizz.pojo.Question;
import com.adaze.quizz.service.QuizzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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


    @RequestMapping("/questions/category/{category}")
    public List<Question> getCategorizedQuestions(@PathVariable String category){
        return quizzService.getCategorizedQuestions(category);
    }

    @RequestMapping("/questions/{id}")
    public Optional<Question> getSelectedQuestion(@PathVariable Integer id) {
        return quizzService.getSelectedQuestion(id);
    }

    @PostMapping("/questions/add-question")
    public String addQuestions(@RequestBody Question question){
      quizzService.addQuestions(question);
        return "Successfully added questions";
    }
    @RequestMapping("/questions")
    public List<Question> getAllQuestions(){
        return quizzService.returnAllQuestions();
    }
}
