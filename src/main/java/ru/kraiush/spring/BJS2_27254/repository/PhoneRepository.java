package ru.kraiush.spring.BJS2_27254.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kraiush.spring.BJS2_27254.model.Phone;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {
}
