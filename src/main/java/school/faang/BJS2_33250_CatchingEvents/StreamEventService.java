package school.faang.BJS2_33250_CatchingEvents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StreamEventService {
    private Map<Integer, StreamEvent> idToEvent;
    private Map<String, List<StreamEvent>> typeToEvents;

    public StreamEventService() {
        idToEvent = new HashMap<>();
        typeToEvents = new HashMap<>();
    }

    public void addEvent(StreamEvent event) {
        if (event == null) {
            throw new IllegalArgumentException("Event can't be null");
        }
        idToEvent.put(event.getId(), event);
        typeToEvents.computeIfAbsent(event.getEventType(), eventType -> new ArrayList<>()).add(event);
    }

    public StreamEvent getEvent(int id) {
        return idToEvent.get(id);
    }

    public List<StreamEvent> getEvents(String eventType) {
        if (eventType == null || eventType.isBlank()) {
            throw new IllegalArgumentException("Invalid eventType.");
        }
        return typeToEvents.getOrDefault(eventType, new ArrayList<>());
    }

    public void removeEvent(int id) {
        StreamEvent event = idToEvent.remove(id);
        List<StreamEvent> eventsOfType = typeToEvents.get(event.getEventType());
        eventsOfType.remove(event);
        if (eventsOfType.isEmpty()) {
            typeToEvents.remove(event.getEventType());
        }
    }

    public void printAllEvents() {
        for (var entry: idToEvent.values()) {
            System.out.println(entry);
        }
    }

    public int getEventsCount() {
        return idToEvent.size();
    }

    public int getEventGroupsCount() {
        return typeToEvents.size();
    }
}
