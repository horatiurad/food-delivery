package com.example.serverlicenta.service;

import com.example.serverlicenta.entity.Ingredient;
import com.example.serverlicenta.entity.Restaurant;
import com.example.serverlicenta.entity.User;
import com.example.serverlicenta.repository.IIngredientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {
    private IIngredientsRepository ingredientsRepository;
    @Autowired
    public IngredientService(IIngredientsRepository ingredientsRepository) {
        this.ingredientsRepository = ingredientsRepository;
    }
    public Ingredient saveIngredient(Ingredient i){
        return ingredientsRepository.save(i);
    }
    public void remove(Long id) {
        try{
            Ingredient i=ingredientsRepository.getOne(id);
            ingredientsRepository.delete(i);
        }catch (Exception e){

        }
    }
    public Ingredient getOneById(Long id) {
        return ingredientsRepository.getOne(id);
    }
    public List<Ingredient> getAll(){
        return ingredientsRepository.findAll();
    }
}
