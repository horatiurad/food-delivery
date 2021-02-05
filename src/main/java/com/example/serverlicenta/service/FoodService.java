package com.example.serverlicenta.service;

import com.example.serverlicenta.entity.Food;
import com.example.serverlicenta.entity.Order;
import com.example.serverlicenta.repository.IFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    private IFoodRepository foodRepository;
    @Autowired
    public FoodService(IFoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }
    public Food saveFood(Food f){
        return foodRepository.save(f);
    }
    public void remove(Long id) {
        try{
            Food f=foodRepository.getOne(id);
            foodRepository.delete(f);
        }catch (Exception e){

        }
    }
    public Food getOneById(Long id) {
        return foodRepository.getOne(id);
    }
    public List<Food> getAll(){
        return foodRepository.findAll();
    }
}
