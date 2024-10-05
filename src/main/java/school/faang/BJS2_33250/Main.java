package school.faang.BJS2_33250;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<Integer, StreamEvent> idToEvent = new HashMap<>();
    private static final Map<String, List<StreamEvent>> typeToEvents = new HashMap<>();

    public static void main(String[] args) {
        StreamEvent event1 = new StreamEvent("INFO", "First event data");
        StreamEvent event2 = new StreamEvent("ERROR", "Second event data");
        StreamEvent event3 = new StreamEvent("INFO", "Third event data");
        StreamEvent event4 = new StreamEvent("DEBUG", "Fourth event data");
        StreamEvent event5 = new StreamEvent("ERROR", "Fifth event data");

        addEvent(event1);
        addEvent(event2);
        addEvent(event3);
        addEvent(event4);
        addEvent(event5);

        System.out.println("All events:");
        printAllEvents();

        System.out.println("\nEvent with id 1:");
        System.out.println(getEvent(1));

        System.out.println("\nEvents with type 'ERROR':");
        System.out.println(getEvents("ERROR"));

        System.out.println("\nRemoving event with id 2");
        removeEvent(2);

        System.out.println("\nAll events after removing event with id 2:");
        printAllEvents();
    }

    private static void addEvent(StreamEvent event) {
        if (event == null) {
            throw new IllegalArgumentException("Event can't be null");
        }
        idToEvent.put(event.getId(), event);
        typeToEvents.computeIfAbsent(event.getEventType(), eventType -> new ArrayList<>()).add(event);
    }

    private static StreamEvent getEvent(int id) {
        return idToEvent.get(id);
    }

    private static List<StreamEvent> getEvents(String eventType) {
        if (eventType == null || eventType.isBlank()) {
            throw new IllegalArgumentException("Invalid eventType.");
        }
        return typeToEvents.getOrDefault(eventType, new ArrayList<>());
    }

    private static void removeEvent(int id) {
        StreamEvent event = idToEvent.remove(id);
        List<StreamEvent> eventsOfType = typeToEvents.get(event.getEventType());
        eventsOfType.remove(event);
        if (eventsOfType.isEmpty()) {
            typeToEvents.remove(event.getEventType());
        }
    }

    private static void printAllEvents() {
        for (var entry: idToEvent.values()) {
            System.out.println(entry);
        }
    }
}
