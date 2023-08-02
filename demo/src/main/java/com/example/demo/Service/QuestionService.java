package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.questionDao;
import com.example.demo.model.Question;

@Service
public class QuestionService {

    @Autowired
    questionDao dao;

    public List<Question> getAllQuestions() {
            return dao.findAll();

            
    }

    public String addQuestion(String question, String option1, String option2, String option3, String option4,
            String rightAnswer) {

                Optional<Question> optionalQuestion = dao.findByQuestion(question);
                if(optionalQuestion.isPresent()){
                    return "Question already Present";
                }

                Question ques = new Question();
                ques.setQuestion(question);
                ques.setOption1(option1);
                ques.setOption2(option2);
                ques.setOption3(option2);
                ques.setOption4(option4);
                ques.setRightAnswer(rightAnswer);
                 dao.save(ques);


        return "Saved Question succesfully";
    }

    public Question getQuestion(String question) {

        Optional<Question> optionalQuestion = dao.findByQuestion(question);
        if(optionalQuestion.isPresent()){
            return optionalQuestion.get();
            
        }
        
            return null;
    


        
    }

    
}
