package BJS2_8789;

import java.util.*;

public class Main {
    static Map<Integer, StreamEvent> events = new HashMap<>();
    static Map<String, List<StreamEvent>> groupEvents = new HashMap<>();

    public static void main(String[] args) {
        StreamEvent event1 = new StreamEvent(1, "in", "user1 logged into the session");
        StreamEvent event2 = new StreamEvent(3, "out", "user2 logout into the session");
        StreamEvent event3 = new StreamEvent(4, "in", "user3 logged into the session");
        StreamEvent event4 = new StreamEvent(10, "out", "user4 logout into the session");

        addEvent(event1);
        addEvent(event2);
        addEvent(event3);
        addEvent(event4);

        System.out.println(findEventById(2));
        findEventByType("in").forEach(System.out::println);

        deleteEvent(13);
        deleteEvent(3);

        printAllEvents();
    }

    public static void addEvent(StreamEvent event) {
        events.putIfAbsent(event.getId(), event);
        groupEvents.computeIfAbsent(event.getEventType(), k -> new ArrayList<>()).add(event);
    }

    public static StreamEvent findEventById(int id) {
        return events.getOrDefault(id, null);
    }

    public static List<StreamEvent> findEventByType(String eventType) {
        return groupEvents.getOrDefault(eventType, null);
    }

    public static void deleteEvent(int id) {
        StreamEvent event = events.get(id);
        if (event != null) {
            events.remove(id);
            groupEvents.get(event.getEventType()).remove(event);
        }
    }

    public static void printAllEvents() {
        groupEvents.forEach((k, v) -> {
            System.out.println("Event type: " + k);
            v.forEach(value -> System.out.println(" " + value));
        });
    }
}