package com.example.Automaster.repository;

import com.example.Automaster.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Ты можешь добавить дополнительные методы для работы с товарами, если необходимо
    // Например, поиск товаров по имени или другим критериям
}

