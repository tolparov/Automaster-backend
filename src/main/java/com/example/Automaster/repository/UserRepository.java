package com.example.Automaster.repository;

/**
 * @author alan
 * @created 14.10.2023 21:30
 * @project Automaster
 */
import com.example.Automaster.Auth.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Auth, Integer>  {
}
