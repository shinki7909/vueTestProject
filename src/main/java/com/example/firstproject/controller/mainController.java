package com.example.firstproject.controller;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.firstproject.entity.TeacherEntity;
import com.example.firstproject.respository.TeacherRespository;

@Controller
public class mainController {

    @Autowired
    private TeacherRespository teacherRespository;

    @GetMapping("/main/{num}")
    public ModelAndView mainMapping(@PathVariable String num) {
        System.out.println(num);
        ModelAndView mav = new ModelAndView("main");
        mav.addObject("num", num);

        return mav;
    }

    @GetMapping("/add")
    public void addTeacher(@RequestParam(required=false) String tname,@RequestParam(required=false)String tsubject){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("schooljpa");

        //EntityManager 객체 생성
        EntityManager  em = entityManagerFactory.createEntityManager();

        EntityTransaction et = em.getTransaction();

        try {
            et.begin();

            TeacherEntity te = new TeacherEntity(null,tname,tsubject,LocalDateTime.now(),LocalDateTime.now());

            TeacherEntity saveTe = teacherRespository.save(te);

            System.out.println(saveTe.toString());


            em.persist(te);

            et.commit();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
 