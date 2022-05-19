package com.masifunde.masifunde.controllers;

import com.masifunde.masifunde.models.College;
import com.masifunde.masifunde.repository.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest")
public class CollegeResource {
    @Autowired
    CollegeRepository collegeRepository;

    @GetMapping(value = "/colleges/all")
    public List<College> getAll(){
        return collegeRepository.findAll();
    }

    @PostMapping(value = "/colleges/add")
    public List<College> addCollege(@RequestBody final   College college){
        collegeRepository.save(college);
        return collegeRepository.findAll();
    }
}
