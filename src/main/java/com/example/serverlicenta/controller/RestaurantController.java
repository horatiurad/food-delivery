package com.example.serverlicenta.controller;

import com.example.serverlicenta.entity.Food;
import com.example.serverlicenta.entity.Restaurant;
import com.example.serverlicenta.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    private final RestaurantService restaurantService;
    @Autowired
    public RestaurantController( RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }
    @PostMapping("/saverestaurant")
    public Restaurant saveRestaurant(@RequestBody Restaurant r) {
        return restaurantService.saveRestaurant(r);
    }
    @DeleteMapping("/delete/{id}")
    public  void removeRestaurant(@PathVariable("id") Long id){
        try{
            restaurantService.remove(id);
        }catch (Exception e){

        }
    }
    @GetMapping("/get/{id}")
    public Restaurant getRestaurant(@PathVariable("id") Long id) {
        return restaurantService.getOneById(id);
    }
    @GetMapping("/all")
    public List<Restaurant> getAllRestaurants(){
        return restaurantService.getAll();
    }

    @PostMapping("/savedummy")
    public Restaurant saveDummy(){
        Restaurant r=new Restaurant("aaa","bbb","addresss","ana@pladfw");
        return restaurantService.saveRestaurant(r);
    }
}
