package school.faang.catchEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private final Map<Integer, StreamEvent> events = new HashMap<>();
    private final Map<String, List<StreamEvent>> eventTypes = new HashMap<>();

    public void addNewStreamEvent(int eventId, String eventType, String eventData) {
        var event = new StreamEvent(eventId, eventType, eventData);

        events.put(eventId, event);
        eventTypes.putIfAbsent(eventType, new ArrayList<>());
        eventTypes.get(eventType).add(event);
    }

    public StreamEvent getStreamEvent(int eventId) {
        return events.get(eventId);
    }

    public List<StreamEvent> getStreamEventList(String eventType) {
        return eventTypes.get(eventType) == null ? new ArrayList<>() : eventTypes.get(eventType);
    }

    public StreamEvent removeStreamEvent(int eventId) {
        StreamEvent removedEvent = null;

        if (events.containsKey(eventId)) {
            removedEvent = events.remove(eventId);
            eventTypes.get(removedEvent.eventType()).remove(removedEvent);

            if (eventTypes.get(removedEvent.eventType()).isEmpty()) {
                eventTypes.remove(removedEvent.eventType());
            }
        }

        return removedEvent;
    }

    public void printAllStreamEvents() {
        for (var event : events.entrySet()) {
            System.out.println(event);
        }
    }
}
