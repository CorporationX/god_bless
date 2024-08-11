package faang.school.godbless.task.hashmap.event.catching;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
public class EventManager {
    private final Map<Integer, StreamEvent> idStreamEventCache;
    private final Map<String, List<StreamEvent>> typeStreamEventCache;

    public void addNewStreamEvent(StreamEvent streamEvent) {
        validEventOrThrowNullPointerException(streamEvent);
        idStreamEventCache.put(streamEvent.id(), streamEvent);
        typeStreamEventCache.computeIfAbsent(streamEvent.eventType(),
                key -> new ArrayList<>()).add(streamEvent);
    }

    public StreamEvent findStreamEventById(int id) {
        if (!idStreamEventCache.containsKey(id)) {
            eventNotFoundExceptionThrow(id);
        }
        return idStreamEventCache.get(id);
    }

    public List<StreamEvent> findStreamEventByEventType(String eventType) {
        if (!typeStreamEventCache.containsKey(eventType)) {
            eventsListNotFoundExceptionThrow(eventType);
        }
        return typeStreamEventCache.get(eventType);
    }

    public void deleteStreamEventById(int id) {
        if (!idStreamEventCache.containsKey(id)) {
            eventNotFoundExceptionThrow(id);
        }
        StreamEvent streamEvent = idStreamEventCache.remove(id);
        List<StreamEvent> streamEventsList = typeStreamEventCache.get(streamEvent.eventType());
        streamEventsList.remove(streamEvent);
    }

    public void printAllStreamEvents() {
        idStreamEventCache.values().forEach(streamEvent -> System.out.println(streamEvent));
    }

    private void validEventOrThrowNullPointerException(StreamEvent streamEvent) {
        if (streamEvent == null) {
            throw new NullPointerException("Событие потока не может быть null");
        }
    }

    private void eventNotFoundExceptionThrow(int id) {
        throw new NoSuchElementException("Событие потока с %d не найдено".formatted(id));
    }

    private void eventsListNotFoundExceptionThrow(String eventType) {
        throw new NoSuchElementException("Список событий с %s не найден".formatted(eventType));
    }
}
