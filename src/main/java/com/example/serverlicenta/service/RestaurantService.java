package com.example.serverlicenta.service;

import com.example.serverlicenta.entity.Restaurant;
import com.example.serverlicenta.entity.User;
import com.example.serverlicenta.repository.IRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    private IRestaurantRepository restaurantRepository;
    @Autowired
    public RestaurantService(IRestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }
    public Restaurant saveRestaurant(Restaurant r){
        return restaurantRepository.save(r);
    }
    public void remove(Long id) {
        try{
            Restaurant r=restaurantRepository.getOne(id);
            restaurantRepository.delete(r);
        }catch (Exception e){

        }
    }
    public Restaurant getOneById(Long id) {
        return restaurantRepository.getOne(id);
    }
    public List<Restaurant> getAll(){
        return restaurantRepository.findAll();
    }
}
