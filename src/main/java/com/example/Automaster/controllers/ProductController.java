package com.example.Automaster.controllers;

import com.example.Automaster.entity.Product;
import com.example.Automaster.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController<ProductRequest> {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product")
    public ResponseEntity getProductById(@RequestParam Long id) {
        try {
            // Используй метод сервиса для получения информации о товаре по его идентификатору
            Product product = productService.getProductById(id);

            // Проверка на null, если товар не найден
            if (product == null) {
                return ResponseEntity.badRequest().body("Товар с id " + id + " не найден");
            }

            // Возвращаем информацию о товаре в ответе
            return ResponseEntity.ok(product);
        } catch (Exception e) {
            // Обработка возможных ошибок
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody ProductRequest productRequest) {
        try {
            // Валидация или другая бизнес-логика, если необходимо

            // Создание объекта Product из запроса
            Product product = new Product();
            product.setName(product.getName());
            product.setDescription(product.getDescription());
            product.setPrice(product.getPrice());

            // Сохранение товара
            productService.saveProduct(product);

            // Возвращение успешного статуса
            return new ResponseEntity<>("Товар успешно создан", HttpStatus.CREATED);
        } catch (Exception e) {
            // Обработка ошибок, например, дубликата товара, неверного формата данных и т.д.
            return new ResponseEntity<>("Не удалось создать товар: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
