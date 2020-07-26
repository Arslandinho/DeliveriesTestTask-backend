package com.example.delivery_register.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "deliveries", uniqueConstraints = @UniqueConstraint(columnNames = {"number", "date"}))
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Поле не может быть пустым")
    private String number;

    @NotNull(message = "Поле не может быть пустым")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date date;

    @NotNull(message = "Поле не может быть пустым")
    private String type;
}
