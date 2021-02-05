package com.example.serverlicenta.repository;

import com.example.serverlicenta.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDeliveryRepository extends JpaRepository<Delivery,Long> {
}
