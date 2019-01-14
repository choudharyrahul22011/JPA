package com.jpa.mapping.repo;

import com.jpa.mapping.entity.Student;
import com.jpa.mapping.exception.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class StudentRepo {

    @Autowired
    private EntityManager entityManager;


    public Student find(long id) {
        Student student = entityManager.find(Student.class, id);
        System.out.println("Student : " + student);
        if(student == null){
            throw new StudentNotFoundException("Student not found with ID : " + id);
        }
        System.out.println(student.getCourses());
        return student;
    }
}
