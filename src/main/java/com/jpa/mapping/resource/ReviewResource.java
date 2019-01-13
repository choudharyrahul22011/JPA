package com.jpa.mapping.resource;

import com.jpa.mapping.repo.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewResource {

    @Autowired
    private ReviewRepo reviewRepo;

    @Transactional
    @DeleteMapping("/review/remove/{id}")
    public String remove(@PathVariable long id){
        return reviewRepo.remove(id);
    }
}
