package com.example.delivery_register.repository;

import com.example.delivery_register.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, String> {

    Optional<Delivery> findByNumber(String number);
}
