package com.example.Automaster.service;
import com.example.Automaster.entity.UserEntity;


import com.example.Automaster.exception.UserAlreadyExist;
import com.example.Automaster.exception.UserNotFoundExist;
import com.example.Automaster.model.UserResetRequest;
import com.example.Automaster.model.UserToModel;
import com.example.Automaster.repository.AuthRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthService {

    @Autowired
    private AuthRepository authRepository;

    public UserEntity register(UserEntity user) throws UserAlreadyExist {
        if (authRepository.findByEmail(user.getEmail()) != null) {
            throw new UserAlreadyExist("Пользователь с такой почтой уже существует");
        }

        if (authRepository.findByLogin(user.getLogin()) != null) {
            throw new UserAlreadyExist("Пользователь с таким логином уже существует");
        }
        return authRepository.save(user);
    }

    public UserEntity login(UserEntity user) throws UserNotFoundExist {
        UserEntity existingUser = authRepository.findByLoginAndPassword(user.getLogin(), user.getPassword());

        if (existingUser == null || !existingUser.getPassword().equals(user.getPassword())) {
            throw new UserNotFoundExist("Неверный логин или пароль");
        }
        return existingUser;
    }

    public UserEntity resetPassword(UserResetRequest userResetRequest) throws UserNotFoundExist, UserAlreadyExist {
        UserEntity existingUser = authRepository.findByLogin(userResetRequest.getLogin());

        if (existingUser == null) {
            throw new UserNotFoundExist("Пользователя с таким логином не существует");
        } else if (Objects.equals(userResetRequest.getPassword(), userResetRequest.getNewPassword())) {
            throw new UserAlreadyExist("Такой пароль уже использовался");
        }

        existingUser.setPassword(userResetRequest.getNewPassword());
        return authRepository.save(existingUser);
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
