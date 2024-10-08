package school.faang.catching.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StreamEvent {
    private final Map<Integer, Event> idToStreamEvent = new HashMap<>();
    private final Map<String, List<Event>> typeToStreamEvent = new HashMap<>();

    public void add(Event event) {
        if (event == null) {
            throw new IllegalArgumentException("event не может быть null");
        }
        idToStreamEvent.put(event.getId(), event);
        List<Event> events = typeToStreamEvent.getOrDefault(event.getEventType(), new ArrayList<>());
        events.add(event);
        typeToStreamEvent.put(event.getEventType(), events);
    }

    public Event get(int id) {
        return idToStreamEvent.get(id);
    }

    public List<Event> get(String eventType) {
        return typeToStreamEvent.get(eventType);
    }

    public void remove(int id) {
        Event event = idToStreamEvent.remove(id);
        List<Event> events = typeToStreamEvent.get(event.getEventType());
        if (events != null) {
            events.remove(event);
            if (events.isEmpty()) {
                typeToStreamEvent.remove(event.getEventType());
            }
        }
    }

    public void printEvents() {
        idToStreamEvent.forEach((key, value) -> System.out.printf("Id: %d, type: %s, Data: %s",
                key, value.getEventType(), value.getData()));
    }
}
