package ru.kraiush.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kraiush.spring.model.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
}
