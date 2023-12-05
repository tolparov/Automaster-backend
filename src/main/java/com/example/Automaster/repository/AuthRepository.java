package com.example.Automaster.repository;
import com.example.Automaster.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthRepository extends JpaRepository<UserEntity, Long> {
	UserEntity findByLogin(String login);
}
