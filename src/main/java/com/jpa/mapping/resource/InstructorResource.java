package com.jpa.mapping.resource;

import com.jpa.mapping.entity.Instructor;
import com.jpa.mapping.repo.InstructorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InstructorResource {

    @Autowired
    private InstructorRepo instructorRepo;

    @Transactional
    @PostMapping("/instructor/persist")
    public Instructor persist(){
        return instructorRepo.persist();
    }

    @GetMapping("/instructor/find/{id}")
    public Instructor find(@PathVariable long id){
        Instructor instructor = instructorRepo.find(id);
        System.out.println(instructor);
        return instructor;
    }

    @GetMapping("/instructor/findAll")
    public List<Instructor> findAll(){
        return instructorRepo.findAll();
    }

    @Transactional
    @PutMapping("/instructor/update")
    public Instructor update(@RequestBody Instructor instructor){
        return instructorRepo.update(instructor);
    }

    @Transactional
    @DeleteMapping("/instructor/delete/{id}")
    public String remove(@PathVariable long id){
        return instructorRepo.remove(id);
    }
}
