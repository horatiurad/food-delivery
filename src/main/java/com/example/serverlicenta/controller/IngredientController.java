package com.example.serverlicenta.controller;

import com.example.serverlicenta.entity.Ingredient;
import com.example.serverlicenta.entity.Order;
import com.example.serverlicenta.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {
    private final IngredientService ingredientService;
    @Autowired
    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }
    @PostMapping("/saveingredient")
    public Ingredient saveIngredient(@RequestBody Ingredient i){
       return ingredientService.saveIngredient(i);
    }

    @PostMapping("/savedummy")
    public Ingredient saveDummy(){
        Ingredient i= new Ingredient("aluat2");

        return ingredientService.saveIngredient(i);
    }
    @DeleteMapping("/delete/{id}")
    public  void removeIngredient(@PathVariable("id") Long id){
        try{
            Ingredient i=ingredientService.getOneById(id);
            ingredientService.remove(id);
        }catch (Exception e){

        }
    }
    @GetMapping("/get/{id}")
    public Ingredient getIngredient(@PathVariable("id") Long id) {
        return ingredientService.getOneById(id);
    }
    @GetMapping("/all")
    public List<Ingredient> getAllIngredients(){
        return ingredientService.getAll();
    }
}
