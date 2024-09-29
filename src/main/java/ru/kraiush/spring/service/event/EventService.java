package ru.kraiush.spring.service.event;

import org.springframework.stereotype.Component;
import ru.kraiush.spring.model.Event;

import java.util.List;

@Component
public interface EventService {

    Event findById(long id);

    List<Event> findAll();

    Event create(Event event);

    void update(Event event);

    void deleteById(long id);

    void deleteAll();
}
