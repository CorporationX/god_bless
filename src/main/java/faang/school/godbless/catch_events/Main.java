package faang.school.godbless.catch_events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Main {
    private static final Map<Integer, StreamEvent> EVENTS = new HashMap<>();
    private static final Map<String, List<StreamEvent>> EVENTS_LIST_BY_TYPE = new HashMap<>();

    public void addEvent(StreamEvent event) {
        Objects.requireNonNull(event);
        EVENTS.put(event.getId(), event);
        addEventToList(event);
    }

    private void addEventToList(StreamEvent event) {
        if (EVENTS_LIST_BY_TYPE.get(event.getEventType()) == null) {
            EVENTS_LIST_BY_TYPE.put(event.getEventType(), new ArrayList<>());
        }
        EVENTS_LIST_BY_TYPE.get(event.getEventType()).add(event);
    }

    public StreamEvent findEventById(int id) {
        StreamEvent streamEvent = EVENTS.get(id);

        if (streamEvent == null) {
            throw new RuntimeException("No such event with id " + id);
        }

        return streamEvent;
    }

    public List<StreamEvent> findEventsByType(String type) {
        Objects.requireNonNull(type);
        List<StreamEvent> events = EVENTS_LIST_BY_TYPE.get(type);

        if (events == null) {
            throw new RuntimeException("No such event type " + type);
        }

        return events;
    }

    public void deleteEventById(int id) {
        StreamEvent event = findEventById(id);
        EVENTS.remove(id);
        EVENTS_LIST_BY_TYPE.get(event.getEventType()).remove(event);
    }

    public void updateEventById(int id, StreamEvent event) {
        Objects.requireNonNull(event);
        StreamEvent streamEvent = EVENTS.put(id, event);

        if (streamEvent == null) {
            throw new RuntimeException("No such event with id " + id);
        }

        EVENTS_LIST_BY_TYPE.get(event.getEventType()).remove(findEventById(id));
        EVENTS_LIST_BY_TYPE.get(event.getEventType()).add(event);
    }

    public void printAllEvents() {
        EVENTS.values().forEach(System.out::println);
    }
}
