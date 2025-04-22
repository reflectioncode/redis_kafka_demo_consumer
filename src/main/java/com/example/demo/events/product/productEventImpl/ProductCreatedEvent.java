package com.example.demo.events.product.productEventImpl;

import com.example.demo.events.product.ProductEvent;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ProductCreatedEvent implements ProductEvent, Serializable {
    private final String type = "productCreated";
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer quantity;
    private LocalDateTime createdAt;
}