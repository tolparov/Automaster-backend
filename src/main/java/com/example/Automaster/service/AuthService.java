package com.example.Automaster.service;
import com.example.Automaster.entity.UserEntity;


import com.example.Automaster.exception.UserAlreadyExist;
import com.example.Automaster.exception.UserNotFoundExist;
import com.example.Automaster.model.UserToModel;
import com.example.Automaster.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthRepository authRepository;

    public UserEntity register(UserEntity user) throws UserAlreadyExist {
        if (authRepository.findByLogin(user.getLogin()) != null) {
            throw new UserAlreadyExist("Пользователь с таким логином уже существует");
        }
        return authRepository.save(user);
    }

    public UserToModel getOne(Long id) throws UserNotFoundExist {
        UserEntity user = authRepository.findById(id).get();

        if (user == null) {
            throw new UserNotFoundExist("Пользователь не был найден");
        }
        return UserToModel.toModel(user);
    }

    public Long delete(Long id) {
        authRepository.deleteById(id);
        return id;
    }
}
