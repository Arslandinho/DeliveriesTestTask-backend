package com.example.delivery_register.repository;

import com.example.delivery_register.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeliveryRepository extends JpaRepository<Delivery, String> {

    Optional<Delivery> findByNumber(String number);
}
