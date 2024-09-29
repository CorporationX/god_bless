package ru.kraiush.spring.BJS2_27194.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import ru.kraiush.spring.BJS2_27194.model.Event;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest(properties = {
        "spring.test.database.replace=NONE",
        "spring.datasource.url= jdbc:postgresql://localhost:5432/werewolf"
})
class EventRepositoryTest {

    @Autowired
    EventRepository eventRepository;

    @Test
    @Sql("/scripts/INIT_EVENT_SKILLS.sql")
    void shouldReturnEvents() {
        List<Event> events = eventRepository.findAll();
        assertEquals(2, events.size());
    }

    @Test
    @Sql("/scripts/INIT_EVENT_SKILLS.sql")
    void shouldReturnOneEvent() {
        Optional<Event> event = eventRepository.findById(1199l);
        assertNotNull(event.get());
    }
}