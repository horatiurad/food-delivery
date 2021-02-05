package com.example.serverlicenta.service;

import com.example.serverlicenta.entity.Order;
import com.example.serverlicenta.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private IOrderRepository orderRepository;
    @Autowired
    public OrderService(IOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    public Order saveOrder(Order o){
        return orderRepository.save(o);
    }
    public void remove(Long id) {
        try{
            Order o=orderRepository.getOne(id);
            orderRepository.delete(o);
        }catch (Exception e){

        }
    }
    public Order getOneById(Long id) {
        return orderRepository.getOne(id);
    }
    public List<Order> getAll(){
        return orderRepository.findAll();
    }
}
