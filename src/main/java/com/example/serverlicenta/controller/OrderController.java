package com.example.serverlicenta.controller;

import com.example.serverlicenta.entity.Food;
import com.example.serverlicenta.entity.Order;
import com.example.serverlicenta.entity.User;
import com.example.serverlicenta.service.FoodService;
import com.example.serverlicenta.service.OrderService;
import com.example.serverlicenta.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;
    private final FoodService foodService;
    private final UserService userService;
    @Autowired
    public OrderController(OrderService orderService, FoodService foodService, UserService userService) {
        this.orderService = orderService;
        this.foodService = foodService;
        this.userService = userService;
    }


    @PostMapping("/saveorder")
    public Order saveOrder(@RequestBody Order o) {
        return orderService.saveOrder(o);
    }

    @PostMapping("/savedummy")
    public Order savedummy(){

        List<Food> f=new ArrayList<Food>();
        Food food=foodService.getOneById(1l);
        Food food2=foodService.getOneById(2l);
        f.add(food);
        f.add(food2);

        User u=userService.getOneById(1l);
        Order o=new Order(30.0,u,f);
        food.addOrder(o);

    return orderService.saveOrder(o);
    }
    @DeleteMapping("/delete/{id}")
    public void removeOrder(@PathVariable("id") Long id) {
        try {

            orderService.remove(id);
        } catch (Exception e) {

        }
    }

    @GetMapping("/get/{id}")
    public Order getOrder(@PathVariable("id") Long id) {
        return orderService.getOneById(id);
    }
    @GetMapping("/all")
    public List<Order> getAllOrders(){
        return orderService.getAll();
    }

}
