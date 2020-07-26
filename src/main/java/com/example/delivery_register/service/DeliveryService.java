package com.example.delivery_register.service;

import com.example.delivery_register.model.Delivery;
import com.example.delivery_register.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepo;

    public Collection<Delivery> getAllDeliveries() {
        return deliveryRepo.findAll();
    }

    public Delivery create(Delivery delivery) {
        return deliveryRepo.save(delivery);
    }
}
