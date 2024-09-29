package ru.kraiush.spring.BJS2_27194.service.event;

import ru.kraiush.spring.BJS2_27194.model.Event;

import java.util.List;

public interface EventService {

    Event findById(long id);

    List<Event> findAll();

    Event create(Event event);

    void update(Event event);

    void deleteById(long id);

    void deleteAll();
}
