package com.adaze.quizz.pojo;


import java.util.Arrays;
import java.util.List;

public class Question {
    private int id;
    private String question;
    private String answer;
    private List<String> options;


    public Question(int id, String question, String answer, List<String> options) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.options = options;
    }


    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", options=" + options +
                '}';
    }
}
