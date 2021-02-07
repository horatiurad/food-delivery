package com.example.serverlicenta.controller;

import com.example.serverlicenta.entity.Food;
import com.example.serverlicenta.entity.Ingredient;
import com.example.serverlicenta.entity.Order;
import com.example.serverlicenta.entity.Restaurant;
import com.example.serverlicenta.service.FoodService;
import com.example.serverlicenta.service.IngredientService;
import com.example.serverlicenta.service.OrderService;
import com.example.serverlicenta.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    private final FoodService foodService;
    private final RestaurantService restaurantService;
    private final IngredientService ingredientService;
    private  final OrderService orderService;
    @Autowired
    public RestaurantController(FoodService foodService, RestaurantService restaurantService, IngredientService ingredientService, OrderService orderService) {
        this.foodService = foodService;
        this.restaurantService = restaurantService;
        this.ingredientService = ingredientService;
        this.orderService = orderService;
    }
    @PostMapping("/saverestaurant")
    public Restaurant saveRestaurant(@RequestBody Restaurant r) {
        return restaurantService.saveRestaurant(r);
    }
    @DeleteMapping("/delete/{id}")
    public  void removeRestaurant(@PathVariable("id") Long id){
        try{
            Restaurant rr= restaurantService.getOneById(id);
            List<Food> foodsList= rr.getFoods();
            for(int j=0;j<foodsList.size();j++){
                Food f=foodsList.get(j);
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
                foodService.remove(f.getId());
            }
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
