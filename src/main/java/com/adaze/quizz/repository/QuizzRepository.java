package com.adaze.quizz.repository;

import com.adaze.quizz.pojo.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuizzRepository extends CrudRepository<Question, Integer> {
}
