package com.example.Automaster.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Automaster.Auth.Auth;


@Repository
public interface AuthRepository extends JpaRepository<Auth, Integer> {
    // Здесь вы можете определить дополнительные методы, если необходимо
}
