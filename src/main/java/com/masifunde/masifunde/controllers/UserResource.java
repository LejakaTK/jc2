package com.masifunde.masifunde.controllers;

import com.masifunde.masifunde.models.User;
import com.masifunde.masifunde.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/rest/users")
public class UserResource {
    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/all")
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @PostMapping(value = "/user")
    public List<User> getUserbyEmail(@RequestParam String email){
        return userRepository.findByEmail(email);
    }

    @PostMapping(value = "/add")
    public List<User> persist(@RequestBody final User user){
        userRepository.save(user);
        return userRepository.findAll();
    }

    @PutMapping (value = "/add")
    public List<User> biggie(@RequestBody final User user, @RequestParam String email){
        if(!userRepository.findByEmail(email).isEmpty()){
            userRepository.save(user);
        }
        else{
            userRepository.save(user);
        }
        return userRepository.findAll();
    }


}
