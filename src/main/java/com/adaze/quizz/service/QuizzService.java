package com.adaze.quizz.service;

import com.adaze.quizz.enums.Category;
import com.adaze.quizz.pojo.Question;
import com.adaze.quizz.repository.QuizzMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class QuizzService {

    @Autowired
    QuizzMongoRepository repository;

    public Question randomQuestion() {
        Random rand = new Random();
        int randomPicker = rand.nextInt(returnAllQuestions().size());
        return returnAllQuestions().get(randomPicker);
    }

    public List<Question> getCategorizedQuestions(String categoryString) {
        Category category = Category.valueOf(categoryString);
        return repository.getQuestionByCategory(category);
    }

   public Optional<Question> getSelectedQuestion(Integer id) {
       return repository.findById(Integer.toString(id));
   }

    public void addQuestions (Question question){
    repository.save(question);
    }

    public List<Question> returnAllQuestions(){
        return repository.findAll();
    }
}
