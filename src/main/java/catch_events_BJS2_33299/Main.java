package catch_events_BJS2_33299;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static Map<Integer, StreamEvent> eventById = new HashMap<>();
    private static Map<String, List<StreamEvent>> eventsByType = new HashMap<>();

    public static void addEvent(StreamEvent event) {
        eventById.put(event.getId(), event);

        eventsByType.putIfAbsent(event.getEventType(), new ArrayList<>());
        eventsByType.get(event.getEventType()).add(event);
    }

    public static StreamEvent getEventById(int id) {
        return eventById.get(id);
    }

    public static List<StreamEvent> getEventsByType(String eventType) {
        return eventsByType.getOrDefault(eventType, new ArrayList<>());
    }

    public static void removeEventById(int id) {
        StreamEvent event = eventById.remove(id);

        if (event != null) {
            List<StreamEvent> eventList = eventsByType.get(event.getEventType());
            eventList.remove(event);

            if (eventList.isEmpty()) {
                eventsByType.remove(event.getEventType());
            }
        }
    }

    public static void printAllEvents() {
        System.out.println("All Stream Events:");
        for (Map.Entry<Integer, StreamEvent> entry : eventById.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public static void main(String[] args) {

        StreamEvent event1 = new StreamEvent(1, "ERROR", "Exception");
        StreamEvent event2 = new StreamEvent(2, "INFO", "Application closed");
        StreamEvent event3 = new StreamEvent(3, "ERROR", "Array Index Out of Bound");

        addEvent(event1);
        addEvent(event2);
        addEvent(event3);

        printAllEvents();

        System.out.println("Event with ID 2:" + getEventById(2));

        System.out.println("Events of type ERROR:");
        for (StreamEvent event : getEventsByType("ERROR")) {
            System.out.println(event);
        }

        System.out.println("Removing event with ID 3");
        removeEventById(3);
        printAllEvents();
    }
}