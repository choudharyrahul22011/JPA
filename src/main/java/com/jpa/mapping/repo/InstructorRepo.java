package com.jpa.mapping.repo;

import com.jpa.mapping.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class InstructorRepo {

    @Autowired
    private EntityManager entityManager;

    public Instructor persist() {

        InstructorDetail detail = new InstructorDetail();
        detail.setYoutubeChannel("Java");
        detail.setHobby("Coding");

        Review review1 = new Review();
        review1.setComment("Awesome Tutorials");

        Review review2 = new Review();
        review2.setComment("Love to watch");

        Student student1 = new Student();
        student1.setFirstName("student1 firstname");
        student1.setLastName("student1 lastname");
        student1.setEmail("student1 email");

        Student student2 = new Student();
        student2.setFirstName("student2 firstname");
        student2.setLastName("student2 lastname");
        student2.setEmail("student2 email");

        Course course1 = new Course();
        course1.setTitle("Frontend");
        course1.addReview(review1);
        course1.addReview(review2);
        course1.addStudent(student1);
        course1.addStudent(student2);

        Course course2 = new Course();
        course2.setTitle("Backend");
        course2.addReview(review2);
        course2.addStudent(student2);

        Instructor instructor = new Instructor();
        instructor.setFirstName("Rahul");
        instructor.setLastName("Choudhary");
        instructor.setEmail("thecrazzyrahul@gmail.com");
        instructor.setInstructorDetail(detail);
        instructor.addCourse(course1);
        instructor.addCourse(course2);

        entityManager.persist(instructor);

        return instructor;
    }

    public Instructor find(long id) {
        Instructor instructor = entityManager.find(Instructor.class, id);
        System.out.println(instructor);
        return instructor;
    }

    public List<Instructor> findAll() {
        TypedQuery<Instructor> query = entityManager.createQuery("SELECT i FROM Instructor i", Instructor.class);
        return query.getResultList();
    }


    public Instructor update(Instructor instructor) {
        Instructor instructor1 = entityManager.find(Instructor.class, instructor.getId());
        instructor1.setEmail(instructor.getEmail());
        return instructor;
    }


    public String remove(long id) {
        Instructor instructor = entityManager.find(Instructor.class, id);
        entityManager.remove(instructor);
        return "Successfully Deleted";
    }
}
