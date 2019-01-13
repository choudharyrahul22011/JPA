package com.jpa.mapping.resource;

import com.jpa.mapping.entity.Student;
import com.jpa.mapping.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentResource {

    @Autowired
    private StudentRepo studentRepo;

    @GetMapping("/student/{id}")
    public Student find(@PathVariable long id){
        return studentRepo.find(id);
    }
}
