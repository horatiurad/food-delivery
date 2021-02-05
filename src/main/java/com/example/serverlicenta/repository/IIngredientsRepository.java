package com.example.serverlicenta.repository;

import com.example.serverlicenta.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IIngredientsRepository extends JpaRepository<Ingredient,Long> {
}
