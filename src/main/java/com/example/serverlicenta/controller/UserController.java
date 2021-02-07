package com.example.serverlicenta.controller;

import com.example.serverlicenta.entity.Food;
import com.example.serverlicenta.entity.Order;
import com.example.serverlicenta.entity.User;
import com.example.serverlicenta.service.OrderService;
import com.example.serverlicenta.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final OrderService orderService;
    @Autowired
    public UserController(UserService userService, OrderService orderService) {
        this.userService = userService;
        this.orderService = orderService;
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
            List<Order> l=userService.getOneById(id).getOrders();
            for(Order o:l){
                o.setFoods(new ArrayList<Food>());
                o.setUser(new User());
                orderService.saveOrder(o);
                orderService.remove(o.getId());
            }
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
