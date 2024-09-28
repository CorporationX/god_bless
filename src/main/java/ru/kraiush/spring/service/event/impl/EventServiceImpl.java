package ru.kraiush.spring.service.event.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kraiush.spring.exception.EventException;
import ru.kraiush.spring.model.Event;
import ru.kraiush.spring.repository.EventRepository;
import ru.kraiush.spring.service.event.EventService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static ru.kraiush.spring.common.ConstantsEvent.ErrorMessage.EVENT_ALREADY_EXISTS;
import static ru.kraiush.spring.common.ConstantsEvent.eventItemsExceptionMessage.*;

@Service
@Transactional
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    @Override
    public List<Event> findAll() {
        try {
            List<Event> listEvents = eventRepository.findAll();
            return listEvents.stream()
                    .sorted((o1, o2) -> o1.getId().compareTo(o2.getId()))
                    .collect(Collectors.toList());
        } catch (final Exception e) {
            throw new EventException(EVENT_LIST_EXCEPTION, e);
        }
    }

    @Override
    public Event findById(long id) {
        try {
            return eventRepository.findById(id).stream()
                    .findAny()
                    .orElseThrow(RuntimeException::new);
        } catch (final RuntimeException e) {
            throw new EventException(EVENT_ITEM_EXCEPTION + id, e);
        }
    }

    @Override
    public Event create(Event entity) {

        Optional<Event> eventOptional = Optional.empty();
        try {
            eventOptional = eventRepository.findById(entity.getId());
        } catch (Exception ex) {
            throw new EventException(EVENT_ALREADY_EXISTS + entity.getId());
        }
        try {
            return eventRepository.save(entity);
        } catch (final RuntimeException e) {
            throw new EventException(EVENT_CREATE_EXCEPTION, e);
        }
    }

    @Override
    @Transactional
    public void update(Event event) {
        try {
            eventRepository.save(event);
        } catch (final Exception e) {
            throw new EventException(EVENT_UPDATE_EXCEPTION, e);
        }
    }

    @Override
    public void deleteById(final long id) {
        try {
            eventRepository.deleteById(id);
        } catch (final Exception e) {
            throw new EventException(EVENT_DELETE_EXCEPTION, e);
        }
    }

    @Override
    public void deleteAll() {
        try {
            eventRepository.deleteAll();
        } catch (final Exception e) {
            throw new EventException(EVENT_DELETE_ALL_EXCEPTION, e);
        }
    }
}
