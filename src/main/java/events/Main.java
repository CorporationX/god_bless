package events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private final static Map<Integer, StreamEvent> storeEventById = new HashMap<>();
    private final static Map<EventType, List<StreamEvent>> storeEventByType = new HashMap<>();

    public static void main(String[] args) {
        addEvent(1, EventType.MEETING, "New Meeting");
        addEvent(2, EventType.CONFERENCE, "New CONFERENCE 1");
        addEvent(3, EventType.CONFERENCE, "New CONFERENCE 2");
        addEvent(4, EventType.SEMINAR, "New SEMINAR 2");
        addEvent(5, EventType.SEMINAR, "New SEMINAR 3");

        System.out.println(getEventById(1));
        System.out.println(getEventsByType(EventType.CONFERENCE));
        removeEventById(1);
        removeEventById(2);
        System.out.println(getEventsByType(EventType.CONFERENCE));

        printEvents();
    }

    public static StreamEvent getEventById(Integer id) {
        return storeEventById.get(id);
    }

    public static List<StreamEvent> getEventsByType(EventType type) {
        return storeEventByType.get(type);
    }

    public static void printEvents() {
        for (Map.Entry<Integer, StreamEvent> entry : storeEventById.entrySet()) {
            System.out.printf(
                "Id: %s тип события: %s, данные события: %s",
                entry.getValue().getId(),
                entry.getValue().getEventType(),
                entry.getValue().getData()
            ).println();
        }
    }

    public static void removeEventById(Integer id) {
        storeEventById.remove(id);
        for (List<StreamEvent> events : storeEventByType.values()) {
            events.removeIf((event) -> event.getId().equals(id));
        }
    }

    public static void addEvent(Integer id, EventType eventType, String data) {
        StreamEvent event = new StreamEvent(id, eventType, data);

        if (!storeEventByType.containsKey(eventType)) {
            storeEventByType.put(eventType, new ArrayList<>());
        }

        storeEventById.put(id, event);
        storeEventByType.get(eventType).add(event);
    }
}
