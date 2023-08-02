package com.example.demo.dao;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Question;


public interface questionDao extends JpaRepository<Question,Integer>{

   Optional<Question> findByQuestion(String question);

   
    
}
