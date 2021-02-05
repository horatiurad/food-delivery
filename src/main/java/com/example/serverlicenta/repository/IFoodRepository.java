package com.example.serverlicenta.repository;

import com.example.serverlicenta.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFoodRepository extends JpaRepository<Food,Long> {
}
