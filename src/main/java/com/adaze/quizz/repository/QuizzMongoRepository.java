package com.adaze.quizz.repository;

import com.adaze.quizz.enums.Category;
import com.adaze.quizz.pojo.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface QuizzMongoRepository extends MongoRepository<Question, String> {

    List<Question> getQuestionByCategory(Category category);

}
