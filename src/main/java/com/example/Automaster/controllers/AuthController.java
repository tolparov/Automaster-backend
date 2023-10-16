package com.example.Automaster.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String loginForm() {
        return "login"; // Отображение страницы входа (формы входа)
    }

    @PostMapping("/login")
    public String loginSubmit(@RequestParam String username, @RequestParam String password, Model model) {
        // Обработка аутентификации пользователя
        // Проверка имени пользователя и пароля, например, с использованием сервиса аутентификации
        // Если успешно, выполните вход пользователя

        return "redirect:/dashboard"; // Перенаправление на страницу после успешной аутентификации
    }

    @GetMapping("/registration")
    public String registrationForm() {
        return "registration"; // Отображение страницы регистрации (формы регистрации)
    }

    @PostMapping("/registration")
    public String registrationSubmit(@RequestParam String username, @RequestParam String password, RedirectAttributes attributes) {
        // Обработка регистрации нового пользователя
        // Проверка данных, добавление пользователя в базу данных и другая логика

        attributes.addFlashAttribute("message", "Регистрация успешно завершена. Вы можете войти сейчас.");

        return "redirect:/login"; // Перенаправление на страницу входа после успешной регистрации
    }
}

