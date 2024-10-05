package school.faang.catchEvents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<Integer, StreamEvent> EVENTS_ID = new HashMap<>();
    private static final Map<String, List<StreamEvent>> EVENTS_TYPES = new HashMap<>();

    public static void main(String[] args) {
        StreamEvent logEvent1 = new StreamEvent(0, "Logging", "Something is being logged");
        StreamEvent hashEvent = new StreamEvent(1, "Hashing", "Something is being hashed");
        StreamEvent logEvent2 = new StreamEvent(2, "Logging", "Something is being logged again..");

        add(logEvent1);
        add(hashEvent);
        add(logEvent2);
        findEventById(1);
        findEventsByType("Logging");
        printAllEvents();
        remove(1);
        printAllEvents();
        remove(2);
        printAllEvents();
    }

    private static void add(StreamEvent event) {
        EVENTS_ID.put(event.getId(), event);
        EVENTS_TYPES.computeIfAbsent(event.getEventType(), k -> new ArrayList<>()).add(event);
    }

    private static void remove(int id) {
        StreamEvent tempEvent = EVENTS_ID.get(id);
        if (tempEvent != null) {
            List<StreamEvent> booksOfType = EVENTS_TYPES.get(tempEvent.getEventType());
            if (booksOfType != null) {
                booksOfType.remove(tempEvent);
                if (booksOfType.isEmpty()) {
                    EVENTS_TYPES.remove(tempEvent.getEventType());
                }
            }
            EVENTS_ID.remove(id);
        }
    }

    private static void findEventById(int id) {
        System.out.println("Id: " + id + ", event = " + EVENTS_ID.get(id));
    }

    private static void findEventsByType(String type) {
        System.out.println("Type: " + type + ", list of events = " + EVENTS_TYPES.get(type));
    }

    private static void printAllEvents() {
        System.out.println("Info for EVENTS_ID hashmap:");
        for (var entry : EVENTS_ID.entrySet()) {
            System.out.println(entry.getValue().toString());
        }
        System.out.println("Info for EVENTS_TYPE hashmap:");
        for (var entry : EVENTS_TYPES.entrySet()) {
            System.out.println("List of events with type: " + entry.getKey()
                    + " = " + entry.getValue());
        }
    }
}
