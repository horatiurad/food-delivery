package com.example.serverlicenta.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String address;
    private String email;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
    private List<Order> orders=new ArrayList<Order>();

    public User(String username, String password, String address, String email) {
        this.username = username;
        this.password = password;
        this.address = address;
        this.email = email;

    }
    public void addOrder(Order o){
        orders.add(o);
    }
}
