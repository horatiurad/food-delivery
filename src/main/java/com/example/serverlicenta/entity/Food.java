package com.example.serverlicenta.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name="foods")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private FoodType foodType;
    private Double price;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name="foods_ingredients",
            joinColumns = {
                    @JoinColumn(name="food_id",referencedColumnName = "id")
            },
            inverseJoinColumns={
                    @JoinColumn(name="ingredient_id", referencedColumnName = "id")}
    )
    private List<Ingredient> ingredients= (new ArrayList<Ingredient>());

    @ManyToOne(cascade = CascadeType.ALL)
    private Restaurant restaurant;



    @ManyToMany( cascade = CascadeType.ALL,mappedBy = "foods", fetch = FetchType.LAZY)
    private List<Order> orders= (new ArrayList<Order>());

    public Food(FoodType foodType, Double price, List<Ingredient> ingredients, Restaurant restaurant) {
        this.foodType = foodType;
        this.price = price;
        this.ingredients = ingredients;
            this.restaurant = restaurant;
    }
    public void addOrder(Order o){
        orders.add(o);
    }
}
