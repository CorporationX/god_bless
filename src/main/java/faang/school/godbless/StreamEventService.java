package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StreamEventService {
    final private HashMap<String, StreamEvent> eventsById = new HashMap<>();
    final private HashMap<String, List<StreamEvent>> eventsByType = new HashMap<>();

    public void addEvent(StreamEvent event) {
        if (event == null) {
            throw new IllegalArgumentException("Event cannot be null");
        }
        eventsById.put(event.getId(), event);
        eventsByType.computeIfAbsent(event.getEventType(), k -> new ArrayList<>()).add(event);
    }

    public StreamEvent getEventById(String id) {
        if (eventsById.containsKey(id)) {
            return eventsById.get(id);
        } else {
            System.out.println("Event with ID " + id + " not found.");
            return null;
        }
    }

    public List<StreamEvent> getEventsByType(String eventType) {
        if (eventType == null || !eventsByType.containsKey(eventType)) {
            System.out.println("Events of type " + eventType + " not found.");
            return new ArrayList<>();
        }
        return eventsByType.get(eventType);
    }

    public void removeEventById(String id) {
        StreamEvent event = eventsById.remove(id);
        if (event == null) {
            System.out.println("Event with ID " + id + " not found.");
            return;
        }
        List<StreamEvent> events = eventsByType.get(event.getEventType());
        if (events != null) {
            events.remove(event);
            if (events.isEmpty()) {
                eventsByType.remove(event.getEventType());
            }
        }
    }

    public void printAllEvents() {
        if (eventsById.isEmpty()) {
            System.out.println("No events");
        } else {
            System.out.println("All stream events:");
            eventsById.forEach((type, events) -> System.out.println("   " + events));
        }
    }
}
