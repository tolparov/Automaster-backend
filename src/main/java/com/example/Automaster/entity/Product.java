package com.example.Automaster.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
    private String description;


    public Product() {
        // Пустой конструктор, необходим для JPA
    }

    public Product toProduct() {
        Product product = new Product();
        product.setDescription(this.description);
        product.setName(this.name);
        product.setPrice(this.price);

        return product;
    }

    // Геттеры и сеттеры для всех полей

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

