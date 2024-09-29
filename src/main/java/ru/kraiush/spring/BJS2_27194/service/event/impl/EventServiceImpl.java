package ru.kraiush.spring.BJS2_27194.service.event.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kraiush.spring.BJS2_27194.service.event.EventService;
import ru.kraiush.spring.BJS2_27194.exception.EventException;
import ru.kraiush.spring.BJS2_27194.model.Event;
import ru.kraiush.spring.BJS2_27194.repository.EventRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static ru.kraiush.spring.BJS2_27194.common.ConstantsEvent.ErrorMessage.EVENT_ALREADY_EXISTS;
import static ru.kraiush.spring.BJS2_27194.common.ConstantsEvent.eventItemsExceptionMessage.*;

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
        try {
            Optional<Event> eventOptional = eventRepository.findById(entity.getId());
            if (eventOptional == null) {
                return eventRepository.save(entity);
            } else {
                throw new EventException(EVENT_ALREADY_EXISTS + entity.getId());
            }
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
