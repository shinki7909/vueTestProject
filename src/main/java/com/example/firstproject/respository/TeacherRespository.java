package com.example.firstproject.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.firstproject.entity.TeacherEntity;

public interface TeacherRespository extends JpaRepository<TeacherEntity,Integer>{
    
}
