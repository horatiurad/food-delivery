package com.example.serverlicenta.service;

import com.example.serverlicenta.entity.Delivery;
import com.example.serverlicenta.entity.Food;
import com.example.serverlicenta.repository.IDeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryService {
    private IDeliveryRepository deliveryRepository;
    @Autowired
    public DeliveryService(IDeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }
    public Delivery saveDelivery(Delivery d){
        return deliveryRepository.save(d);
    }
    public void remove(Long id) {
        try{
            Delivery d=deliveryRepository.getOne(id);
            deliveryRepository.delete(d);
        }catch (Exception e){

        }
    }
    public Delivery getOneById(Long id) {
        return deliveryRepository.getOne(id);
    }
    public List<Delivery> getAll(){
        return deliveryRepository.findAll();
    }
}
