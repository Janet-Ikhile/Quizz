package com.adaze.quizz.service;

import com.adaze.quizz.pojo.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class QuizzService {

    private List<Question> questions = new ArrayList<>(Arrays.asList(
            new Question(1, "Who was the first man God created?", "Adam", Arrays.asList("Gabriel", "John", "Adam", "Phillips")),
            new Question(2, "Who was the vilian in Avengers Endgame", "Thanos", Arrays.asList("Black Widow", "Spider Man", "Thor", "Thanos")),
            new Question(3, "Who sang running to you ", "Simi&Chike", Arrays.asList("Mark Angel", "Timaya", "Simi&Chike", "Davido")),
            new Question(4, "How many sides does a dice have", "6", Arrays.asList("90", "87", "1", "6")),
            new Question(5, "The only fish that can be found on a crayon is called", "Crayfish", Arrays.asList("Tilapia", "Titus", "Fish", "Crayfish")),
            new Question(6, "Who is the Brain Box of Seamfix", "Chimezie", Arrays.asList("Chibuzor", "Tochukwu", "Chimezie", "Olamide"))

    ));

    public Question randomQuestion() {
        Random rand = new Random();
        int randomPicker = rand.nextInt(4);

        Question randomQuestion = questions.get(randomPicker);
        return randomQuestion;
    }

    public List<Question> getAllQuestions() {
        return questions;
    }

    public Question getSelectedQuestion(int id) {
        Question question = questions.get(id - 1);
        return question;
    }

}
