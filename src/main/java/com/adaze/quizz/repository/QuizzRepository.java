package com.adaze.quizz.repository;

import com.adaze.quizz.enums.Category;
import com.adaze.quizz.pojo.Question;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Deprecated
public interface QuizzRepository extends CrudRepository<Question, Integer> {

    List<Question> findByCategory(Category category);

}
