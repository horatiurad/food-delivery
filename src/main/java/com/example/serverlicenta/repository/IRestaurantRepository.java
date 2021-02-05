package com.example.serverlicenta.repository;


import com.example.serverlicenta.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRestaurantRepository extends JpaRepository<Restaurant,Long> {
}
