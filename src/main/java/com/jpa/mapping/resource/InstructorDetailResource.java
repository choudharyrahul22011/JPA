package com.jpa.mapping.resource;

import com.jpa.mapping.entity.InstructorDetail;
import com.jpa.mapping.repo.InstructorDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InstructorDetailResource {

    @Autowired
    private InstructorDetailRepo instructorDetailRepo;

    @GetMapping("/instructor-detail/find/{id}")
    public InstructorDetail find(@PathVariable long id) {
        return instructorDetailRepo.find(id);
    }

    @Transactional
    @DeleteMapping("/instructor-detail/delete/{id}")
    public String remove(@PathVariable long id){
        return instructorDetailRepo.remove(id);
    }
}
