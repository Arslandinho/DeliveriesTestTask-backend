package com.example.delivery_register.controller;

import com.example.delivery_register.model.Delivery;
import com.example.delivery_register.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class DeliveryController {

    @Autowired
    private DeliveryRepository deliveryRepo;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @GetMapping("/deliveries")
    Collection<Delivery> deliveries() {
        return deliveryRepo.findAll();
    }

    @PostMapping("/delivery")
    ResponseEntity<Delivery> createDelivery(@Valid Delivery delivery) throws URISyntaxException {
        Delivery result = deliveryRepo.save(delivery);
        return ResponseEntity.created(new URI("/api/delivery/" + result.getId()))
                .body(result);
    }

    //    @GetMapping("/delivery/{number}")
//    ResponseEntity<?> getDelivery(@PathVariable String number) {
//        Optional<Delivery> group = deliveryRepo.findByNumber(number);
//        return group.map(response -> ResponseEntity.ok().body(response))
//                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
}
