package ru.kraiush.spring.BJS2_27254.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kraiush.spring.BJS2_27254.domain.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);


}