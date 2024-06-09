package faang.school.godbless.hashMap.catchingEvents;

import faang.school.godbless.exceptions.NotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static Map<Integer, StreamEvent> allEvents = new HashMap<>();
    static Map<String, List<StreamEvent>> eventsByType = new HashMap<>();

    public static void main(String[] args) {
        put(1, "type1", "data1");
        put(2, "type1", "data2");
        put(3, "type1", "data3");
        put(4, "type2", "data4");
        put(5, "type3", "data5");
        put(6, "type4", "data6");
        put(7, "type2", "data7");
        put(8, "type2", "data8");
        put(9, "type3", "data9");

        System.out.println("After putting");
        printAll();

        System.out.println("\nAfter putting");
        printAllByTypes();

        System.out.println("\nGetting by id");
        System.out.println(getEventById(2));

        deleteById(2);
        System.out.println("\nAfter deleting");
        printAllByTypes();

        System.out.println("\nGetting by type");
        System.out.println(getEventsByType("type3"));
    }

    private static void put(int id, String eventType, String data) {
        validateString(eventType);
        validateString(data);
        StreamEvent event = new StreamEvent(id, eventType, data);
        allEvents.put(id, event);
        eventsByType.computeIfAbsent(eventType, k -> new ArrayList<>()).add(event);
    }

    private static StreamEvent getEventById(int id) {
        StreamEvent event = allEvents.get(id);
        if (event == null) {
            throw new NotFoundException("Event by id " + id + " not found");
        }
        return event;
    }

    private static List<StreamEvent> getEventsByType(String eventType) {
        validateString(eventType);
        List<StreamEvent> events = eventsByType.get(eventType);
        if (events == null) {
            throw new NotFoundException("Events by type " + eventType + " not found");
        }
        return events;
    }

    private static void deleteById(int id) {
        StreamEvent event = allEvents.remove(id);
        if (event == null) {
            throw new NotFoundException("Event by id " + id + " not found");
        }
        eventsByType.get(event.getEventType()).remove(event);
    }

    private static void printAll() {
        for (Map.Entry<Integer, StreamEvent> entry : allEvents.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    private static void printAllByTypes() {
        for (Map.Entry<String, List<StreamEvent>> entry : eventsByType.entrySet()) {
            System.out.println("\nEvent type: " + entry.getKey());
            for (StreamEvent event : entry.getValue()) {
                System.out.println(event);
            }
        }
    }

    private static void validateString(String s) {
        if (s == null || s.isEmpty() || s.isBlank()) {
            throw new IllegalArgumentException("Field can`t be empty");
        }
    }
}
