package school.faang.catchevents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final Map<Integer, StreamEvent> ID_TO_EVENT = new HashMap<>();
    private static final Map<String, List<StreamEvent>> TYPE_TO_EVENTS = new HashMap<>();

    public static void main(String[] args) {
        int id = 1;
        String eventType = "event_type";
        String data = "data";
        StreamEvent event = new StreamEvent(id, eventType, data);

        addEvent(event);
        System.out.println("Found event: " + getEventById(id));
        System.out.println("Found events: " + getEventsByType(eventType));
        removeEventById(id);
        System.out.println("Found events after remove: " + getEventsByType(eventType));
    }

    public static void addEvent(StreamEvent event) {
        if (event == null) {
            throw new IllegalArgumentException("Event cannot be null");
        }
        ID_TO_EVENT.put(event.getId(), event);
        TYPE_TO_EVENTS.computeIfAbsent(event.getEventType(), k -> new ArrayList<>()).add(event);
    }

    public static StreamEvent getEventById(int id) {
        return ID_TO_EVENT.get(id);
    }

    public static List<StreamEvent> getEventsByType(String type) {
        return TYPE_TO_EVENTS.get(type);
    }

    public static void removeEventById(int id) {
        StreamEvent removedEvent = ID_TO_EVENT.remove(id);
        if (removedEvent != null) {
            TYPE_TO_EVENTS.get(removedEvent.getEventType()).remove(removedEvent);
        }
    }
}
