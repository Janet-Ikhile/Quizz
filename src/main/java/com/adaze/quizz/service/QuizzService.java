package com.adaze.quizz.service;

import com.adaze.quizz.enums.Category;
import com.adaze.quizz.pojo.Question;
import com.adaze.quizz.repository.QuizzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuizzService {

    @Autowired
    QuizzRepository repository;
    public Question randomQuestion() {
        Random rand = new Random();
        int randomPicker = rand.nextInt(returnAllQuestions().size());
        return returnAllQuestions().get(randomPicker);
    }

    public List<Question> getCategorizedQuestions(String categoryString) {
        Category category = Category.valueOf(categoryString);
        return repository.findByCategory(category);
    }

   public Optional<Question> getSelectedQuestion(Integer id) {
       return repository.findById(id);
   }

    public void addQuestions (Question question){
    repository.save(question);
    }

    public List<Question> returnAllQuestions(){
        return (List<Question>) repository.findAll();
    }
}
