package com.jpa.mapping.repo;

import com.jpa.mapping.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class ReviewRepo {

    @Autowired
    private EntityManager entityManager;

    public String remove(long id) {
        Review review = entityManager.find(Review.class, id);
        entityManager.remove(review);
        return "Successfully Deleted Review for ID :" + id;
    }
}
