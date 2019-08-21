package com.masifunde.masifunde.controllers;

import com.masifunde.masifunde.models.User;
import com.masifunde.masifunde.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/rest")
public class LoginResource {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/login")
    public List<User> userLogin(@RequestParam String email, Integer password){
//        public List<User> userLogin(@PathVariable String email, Integer password){

        User user = new User();
        Integer id=0;

        if(!userRepository.findByEmail(email).isEmpty()) {
            List<User> u =userRepository.findAll();
            for(int i=0 ;i<u.size() ; i++)
            {
                String userEmail = u.get(i).getEmail();
                if(email.trim().equals(userEmail))
                {
                    id=u.get(i).getUser_id();
                    if(password.equals(id)){
                        System.out.println("**********" + userEmail +" is logged in successfully ***************");
                    }
                    else{
                        System.out.println("**************" + userEmail +" is found by login failed *************");
                    }
                    System.out.println(userEmail +" transaction is completed");
                }

            }
        }
        else{
            System.out.println(" ****** " + email +" not found ****** " );
        }
        return userRepository.findByEmail(email);
    }
}
