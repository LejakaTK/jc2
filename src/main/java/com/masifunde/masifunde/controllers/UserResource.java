package com.masifunde.masifunde.controllers;

import com.masifunde.masifunde.models.User;
import com.masifunde.masifunde.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/rest/users")
public class UserResource {
    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/all")
    //http://localhost:8080/rest/users/all
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @PostMapping(value = "/user")
    //http://localhost:8080/rest/users/user?email=tklejaka@absa.com
    public List<User> getUserbyEmail(@RequestParam String email){
        return userRepository.findByEmail(email);
    }

    @PostMapping(value = "/add")
    //http://localhost:8080/rest/users/add
    public List<User> persist(@RequestBody final User user){
        userRepository.save(user);
        return userRepository.findAll();
    }

    @PutMapping (value = "/add")
    //http://localhost:8080/rest/users/add?email=siwelas@absa.com
    public List<User> update(@RequestBody final User user, @RequestParam String email){
        if(!userRepository.findByEmail(email).isEmpty()){
            userRepository.save(user);
        }
        else{
            userRepository.save(user);
        }
        return userRepository.findAll();
    }

    @DeleteMapping("/delete/{email}")
    //http://localhost:8080/rest/users/delete/siwelas@absa.com
    public List<User> deleteUser(@PathVariable String email) {
        User user = new User();
        Integer id=0;

        if(!userRepository.findByEmail(email).isEmpty()){
            List<User> u =userRepository.findAll();

            for(int i=0 ;i<u.size() ; i++)
            {
                String userEmail = u.get(i).getEmail();
                System.out.println(userEmail +" >>> " + email);
                if(email.trim().equals(userEmail))
                {
                    id=u.get(i).getUser_id();
                    System.out.println(id);
                    System.out.println(userEmail +" is the one");
                }
            }

            userRepository.deleteById(id);
        }
        return userRepository.findAll();
    }
}
