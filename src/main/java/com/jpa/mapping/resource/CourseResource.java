package com.jpa.mapping.resource;

import com.jpa.mapping.entity.Course;
import com.jpa.mapping.repo.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseResource {

    @Autowired
    private CourseRepo courseRepo;

    @GetMapping("/course/find/{id}")
    public Course find(@PathVariable long id){
        return courseRepo.find(id);
    }

    @GetMapping("/course/findAll")
    public List<Course> findAll(){
        return courseRepo.findAll();
    }

    @Transactional
    @DeleteMapping("/course/delete/{id}")
    public String remove(@PathVariable long id){
        return courseRepo.remove(id);
    }

    @GetMapping("/course/{id}/reviews")
    public Course findReviews(@PathVariable long id){
        return courseRepo.findReviews(id);
    }

}
