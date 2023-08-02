package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.Service.QuestionService;
import com.example.demo.model.Question;


@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;
    
    @GetMapping("getAllQuestions")
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @PostMapping("addQuestion")
    public String addQuestion(@RequestParam String question, @RequestParam String option1, @RequestParam String option2, @RequestParam String option3, @RequestParam String option4,
     @RequestParam String rightAnswer){
        return questionService.addQuestion(question, option1,option2, option3, option4, rightAnswer);
    }

    @GetMapping("getQuestion")
        public Question getQuestion(@RequestParam String question){
            return questionService.getQuestion(question);
        }
    }


