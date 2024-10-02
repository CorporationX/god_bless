package dima.evseenko.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StreamController {
    private final Map<Long, StreamEvent> events = new HashMap<>();
    private final Map<EventType, List<StreamEvent>> eventTypes = new HashMap<>();

    public void addEvent(StreamEvent event) {
        events.put(event.getId(), event);

        eventTypes.computeIfAbsent(event.getEventType(), k -> new ArrayList<>()).add(event);
    }

    public void deleteEvent(StreamEvent event) {
        events.remove(event.getId());

        if(eventTypes.containsKey(event.getEventType()))
            eventTypes.get(event.getEventType()).remove(event);
    }

    public StreamEvent getEvent(long id) {
        return events.get(id);
    }

    public List<StreamEvent> getEvents(EventType type) {
        return eventTypes.get(type);
    }

    public void printEvents() {
        for(Map.Entry<Long, StreamEvent> entry : events.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
