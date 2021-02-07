package com.example.serverlicenta.controller;

import com.example.serverlicenta.entity.*;
import com.example.serverlicenta.service.FoodService;
import com.example.serverlicenta.service.IngredientService;
import com.example.serverlicenta.service.OrderService;
import com.example.serverlicenta.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {
    private final FoodService foodService;
    private final RestaurantService restaurantService;
    private final IngredientService ingredientService;
    private  final OrderService orderService;
    @Autowired
    public FoodController(FoodService foodService, RestaurantService restaurantService, IngredientService ingredientService, OrderService orderService) {
        this.foodService = foodService;
        this.restaurantService = restaurantService;
        this.ingredientService = ingredientService;
        this.orderService = orderService;
    }

 /*   @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }*/
    @PostMapping("/savefood")
    public Food saveFood(@RequestBody Food f){
        return foodService.saveFood(f);
    }
    @PostMapping("/savedummy")
    public Food saveDummy( ) {
        List<Ingredient> lista=new ArrayList<Ingredient>();
        Ingredient i= ingredientService.getOneById(1l);
        lista.add(i);
        Restaurant restaurant=restaurantService.getOneById(1l);
        Food f=new Food(FoodType.BURGER,3.0,lista,restaurant);
        return foodService.saveFood(f);
    }
    @PostMapping("/savedummy1")
    public Food saveDummy1( ) {
        List<Ingredient> lista=new ArrayList<Ingredient>();
        Ingredient i= ingredientService.getOneById(1l);
        lista.add(i);
        Restaurant restaurant=restaurantService.getOneById(2l);
        Food f=new Food(FoodType.BURGER,3.0,lista,restaurant);
        return foodService.saveFood(f);
    }
    @DeleteMapping("/delete/{id}")
    public  void removeFood(@PathVariable("id") Long id){
        try{
            Food f=foodService.getOneById(id);
            List<Ingredient> l=f.getIngredients();
            List<Order> o=f.getOrders();
            Restaurant r=f.getRestaurant();
            r.getFoods().remove(f);
            restaurantService.saveRestaurant(r);
            for (Order or: o){
                List<Food> f2=or.getFoods();
                f2.remove(f);
                or.setFoods(f2);
                orderService.saveOrder(or);
            }
            for(Ingredient i:l){
                List<Food> f2=i.getFoods();
                f2.remove(f);
                i.setFoods(f2);
                ingredientService.saveIngredient(i);
            }
            f.setRestaurant(new Restaurant());
            f.setIngredients(new ArrayList<Ingredient>());
            f.setOrders(new ArrayList<Order>());
            foodService.saveFood(f);
            foodService.remove(id);
        }catch (Exception e){

        }
    }
    @GetMapping("/get/{id}")
    public Food getFood(@PathVariable("id") Long id) {
        Food f=foodService.getOneById(id);
        System.out.println(f.getIngredients().size());
        for(Ingredient i: f.getIngredients()){
            System.out.println(i.getName());
        }
        return foodService.getOneById(id);
    }
    @GetMapping("/all")
    public List<Food> getAllFoods(){
        return foodService.getAll();
    }

}
