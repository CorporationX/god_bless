package dima.evseenko.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StreamController {
    private final Map<Long, StreamEvent> events = new HashMap<>();
    private final Map<EventType, List<StreamEvent>> eventTypes = new HashMap<>();

    public void addEvent(StreamEvent event) {
        validateStreamEvent(event);

        events.put(event.getId(), event);
        eventTypes.computeIfAbsent(event.getEventType(), k -> new ArrayList<>()).add(event);
    }

    public void deleteEvent(StreamEvent event) {
        validateStreamEvent(event);

        events.remove(event.getId());
        if(eventTypes.containsKey(event.getEventType()))
            eventTypes.get(event.getEventType()).remove(event);
    }

    public StreamEvent getEvent(Long id) {
        validateStreamEventId(id);

        return events.get(id);
    }

    public List<StreamEvent> getEvents(EventType type) {
        validateEventType(type);

        return eventTypes.get(type);
    }

    private void validateStreamEvent(StreamEvent event) {
        if(event == null)
            throw new IllegalArgumentException("Event is null");
        if(event.getData() == null)
            throw new IllegalArgumentException("Event data is null");

        validateStreamEventId(event.getId());
        validateEventType(event.getEventType());
    }

    private void validateStreamEventId(Long id) {
        if(id == null)
            throw new IllegalArgumentException("Event id is null");
    }

    private void validateEventType(EventType type) {
        if(type == null)
            throw new IllegalArgumentException("Event type is null");
    }

    public void printEvents() {
        for(Map.Entry<Long, StreamEvent> entry : events.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
