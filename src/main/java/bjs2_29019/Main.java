package bjs2_29019;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Map<Integer, StreamEvent> eventById = new HashMap<>();
        Map<String, List<StreamEvent>> eventsByType = new HashMap<>();

        addEvent(eventById, eventsByType, new StreamEvent(1, "Random", "Event"));
        addEvent(eventById, eventsByType, new StreamEvent(2, "0", "voobrazheniya"));
        addEvent(eventById, eventsByType, new StreamEvent(3, "Random", "Event2"));

        System.out.println(searchEventById(eventById, 1));
        System.out.println(searchEventsByType(eventsByType, "Random"));
        System.out.println();

        printAllEventsByIds(eventById);
        System.out.println();

        deleteEventById(eventById, eventsByType, 1);

        printAllEventsByIds(eventById);
    }

    public static void addEvent(Map<Integer, StreamEvent> eventById,
                                Map<String, List<StreamEvent>> eventsByType,
                                StreamEvent streamEvent) {
        eventById.put(streamEvent.getId(), streamEvent);
        eventsByType.computeIfAbsent(streamEvent.getEventType(), k -> new ArrayList<StreamEvent>()).add(streamEvent);
    }

    public static StreamEvent searchEventById(Map<Integer, StreamEvent> eventById, Integer id) {
        return eventById.get(id);
    }

    public static List<StreamEvent> searchEventsByType(Map<String, List<StreamEvent>> eventsByType,
                                                       String eventType) {
        return eventsByType.get(eventType);
    }

    public static void deleteEventById(Map<Integer, StreamEvent> eventById,
                                       Map<String, List<StreamEvent>> eventsByType,
                                       Integer id) {
        StreamEvent event = eventById.get(id);

        eventById.remove(id);
        eventsByType.get(event.getEventType()).remove(event);
    }

    public static void printAllEventsByIds(Map<Integer, StreamEvent> eventsById) {
        for (var entry : eventsById.entrySet()) {
            System.out.printf("Event: %s\n", entry.getValue());
        }
    }
}
