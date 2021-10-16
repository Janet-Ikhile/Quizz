package com.adaze.quizz.pojo;


import com.adaze.quizz.enums.Category;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.List;

@Entity
public class Question {
    @Id
    @GeneratedValue
    private Integer id;

    private String question;
    private String answer;

    @ElementCollection(targetClass = String.class)
    private List<String> options;

    private Category category;


    public Question(Integer id, String question, String answer, List<String> options) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.options = options;
    }

    public Question() {
    }

    public Question(Integer id, String question, String answer, List<String> options, Category category) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.options = options;
        this.category = category;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", options=" + options +
                ", category=" + category +
                '}';
    }
}
