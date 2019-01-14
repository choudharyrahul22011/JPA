package com.jpa.mapping.resource;

import com.jpa.mapping.entity.Student;
import com.jpa.mapping.exception.StudentNotFoundException;
import com.jpa.mapping.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.jpa.mapping.exception.ErrorResponse;

@RestController
public class StudentResource {

    @Autowired
    private StudentRepo studentRepo;

    @GetMapping("/student/{id}")
    public Student find(@PathVariable long id){
        Student student = studentRepo.find(id);
        return student;
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(StudentNotFoundException ex){
        ErrorResponse response = new ErrorResponse();
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setMessage(ex.getMessage());
        response.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
}
