package com.example.flight.repository;

import com.example.flight.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

//Bu kod, kullanıcı adı ve şifreye göre veritabanında kullanıcı aramamızı sağlar
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsernameAndPassword(String username, String password);
}

