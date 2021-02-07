package com.example.serverlicenta.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double totalPrice;
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    public Order(Double totalPrice, User user, List<Food> foods) {
        this.totalPrice = totalPrice;
        this.user = user;
        this.foods = foods;
    }
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name="orders_foods",
            joinColumns = {
                    @JoinColumn(name="order_id",referencedColumnName = "id")
            },
            inverseJoinColumns={
                    @JoinColumn(name="food_id", referencedColumnName = "id")}
    )

    List<Food> foods= (new ArrayList<Food>());

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }
}
