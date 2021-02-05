package com.example.serverlicenta.controller;

import com.example.serverlicenta.entity.Order;
import com.example.serverlicenta.entity.User;
import com.example.serverlicenta.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController( UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/saveuser")
    public User saveUser(@RequestBody User u) {
        return userService.saveUser(u);
    }
    @PostMapping("/savedummy")
    public User savedummy(){
        User u=new User("horica","horica","albalaporocala","horatiu@gmail.com");
        return userService.saveUser(u);
    }

    @DeleteMapping("/delete/{id}")
    public  void removeUser(@PathVariable("id") Long id){
        try{
            userService.remove(id);
        }catch (Exception e){
            
        }
    }
    @GetMapping("/get/{id}")
    public User getUser(@PathVariable("id") Long id) {
        return userService.getOneById(id);
    }
    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userService.getAll();
    }

}
