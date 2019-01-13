package com.jpa.mapping.repo;

import com.jpa.mapping.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CourseRepo {

    @Autowired
    private EntityManager entityManager;

    public Course find(long id){
        Course course = entityManager.find(Course.class, id);
        return course;
    }

    public List<Course> findAll(){
        TypedQuery<Course> query = entityManager.createQuery("SELECT c FROM Course c",Course.class);
        return query.getResultList();
    }

    public String remove(long id) {
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
        return "Successfully Deleted";
    }

    public Course findReviews(long id) {
        Course course = entityManager.find(Course.class, id);
        System.out.println(course);
        System.out.println(course.getReviews());
        return course;
    }
}
