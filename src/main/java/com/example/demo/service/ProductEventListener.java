package com.example.demo.service;

import com.example.demo.events.product.ProductEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@EnableKafka
@Component
public class ProductEventListener {

    private static final Logger logger = LoggerFactory.getLogger(ProductEventListener.class);
    private final ObjectMapper objectMapper;

    public ProductEventListener(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "${kafka.consumer.topic}", groupId = "${kafka.consumer.group-id}")
    public void listen(String message) {
        try {
            //Десериализация сообщения в объект ProductEvent
            ProductEvent event = objectMapper.readValue(message, ProductEvent.class);
            logger.info("Received Product Event: {}", event);
        } catch (Exception e) {
            logger.error("Error deserializing message: {}", message, e);
        }
    }
}