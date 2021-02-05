package com.example.serverlicenta.controller;

import com.example.serverlicenta.entity.Delivery;
import com.example.serverlicenta.entity.Restaurant;
import com.example.serverlicenta.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
    private final DeliveryService deliveryService;
    @Autowired
    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }
    @PostMapping("/savedelivery")
    public Delivery saveDelivery(@RequestBody Delivery d){
      return  deliveryService.saveDelivery(d);
    }
    @DeleteMapping("/delete/{id}")
    public  void removeDelivery(@PathVariable("id") Long id){
        try{
            deliveryService.remove(id);
        }catch (Exception e){

        }
    }
    @GetMapping("/get/{id}")
    public Delivery getDelivery(@PathVariable("id") Long id) {
        return deliveryService.getOneById(id);
    }
    @GetMapping("/all")
    public List<Delivery> getAllDeliverys(){
        return deliveryService.getAll();
    }
}
