package com.jpa.mapping.repo;

import com.jpa.mapping.entity.InstructorDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class InstructorDetailRepo {

    @Autowired
    private EntityManager entityManager;

    public InstructorDetail find(long id) {
        InstructorDetail detail = entityManager.find(InstructorDetail.class, id);
        System.out.println(detail);
        System.out.println(detail.getInstructor());
        return detail;
    }

    public String remove(long id) {
        InstructorDetail detail = entityManager.find(InstructorDetail.class, id);
        System.out.println(detail);
        // remove the associated object reference or break the bidirectional link
        detail.getInstructor().setInstructorDetail(null);
        entityManager.remove(detail);
        return "Successfully Deleted";
    }
}
