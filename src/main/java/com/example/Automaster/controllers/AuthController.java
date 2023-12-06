package com.example.Automaster.controllers;

import com.example.Automaster.entity.UserEntity;
import com.example.Automaster.exception.UserAlreadyExist;
import com.example.Automaster.exception.UserNotFoundExist;
import com.example.Automaster.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("register")
    public ResponseEntity register(@RequestBody UserEntity user) {
        try {
            authService.register(user);
            return ResponseEntity.ok("Пользователь успешно сохранен");
        } catch (UserAlreadyExist e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Не удалось сохранить пользователя");
        }
    }
    @PostMapping("login")
    public ResponseEntity login(@RequestBody UserEntity user) {
        try {
            authService.login(user);
            return ResponseEntity.ok("Пользователь успешно вошел");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Не удалось выполнить вход");
        }
    }


    @GetMapping
    public ResponseEntity getOneUsers(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(authService.getOne(id));
        } catch (UserNotFoundExist e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser (@PathVariable Long id) {
        try {
            return ResponseEntity.ok(authService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка при попытке удалить");
        }
    }

}

