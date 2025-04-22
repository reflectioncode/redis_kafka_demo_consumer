package com.example.demo.events.product;


import com.example.demo.events.product.productEventImpl.ProductCreatedEvent;
import com.example.demo.events.product.productEventImpl.ProductRemovedEvent;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ProductCreatedEvent.class, name = "productCreated"),
        @JsonSubTypes.Type(value = ProductRemovedEvent.class, name = "productRemoved")
})
public interface ProductEvent {
}
