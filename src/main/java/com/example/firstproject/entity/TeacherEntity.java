package com.example.firstproject.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="teacher")
public class TeacherEntity {
     
    @Id
    @GeneratedValue
    private Long teacher_id;
 
    private String teacher_name;

    private String teacher_subject;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="updated_at")
    private LocalDateTime updateAt;

    public Long getTeacher_id(){return teacher_id;}

    public String getTeacher_name(){return teacher_name;}

    public String getTeacher_subject(){return teacher_subject;}

    public LocalDateTime getCreatedAt(){return createdAt;}

    public LocalDateTime getUpdatedAt(){return updateAt;}

    public TeacherEntity(Long teacher_id,String teacher_name, String teacher_subject,LocalDateTime createdAt,LocalDateTime updateAt){
        this.teacher_id = teacher_id;
        this.teacher_name = teacher_name;
        this.teacher_subject = teacher_subject;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public TeacherEntity(){

    }

    @Override
    public String toString() {
        
        return getTeacher_id()+":"+getTeacher_name();
    }
}