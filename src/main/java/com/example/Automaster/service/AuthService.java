package com.example.Automaster.service;
import com.example.Automaster.Auth.Auth;


import com.example.Automaster.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthService {

    private final AuthRepository authRepository;

    @Autowired
    public AuthService(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public Auth saveAuth(Auth auth) {
        return authRepository.save(auth);
    }

    public List<Auth> getAllAuth() {
        return authRepository.findAll();
    }

    public Optional<Auth> getAuthById(Integer id) {
        return authRepository.findById(id);
    }

    public void deleteAuth(Integer id) {
        authRepository.deleteById(id);
    }
}
