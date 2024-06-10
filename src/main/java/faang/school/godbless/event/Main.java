package faang.school.godbless.event;

import java.util.*;

public class Main {
    private static Map<Integer, StreamEvent> EVENTS = new HashMap<>();
    private static Map<String, List<StreamEvent>> GROUP_EVENTS = new HashMap<>();

    public static void main(String[] args) {
        try {
            addEvent(new StreamEvent(1, "login", "User A logged in"));
            addEvent(new StreamEvent(2, "logout", "User B logged out"));
            addEvent(new StreamEvent(3, "login", "User C logged in"));

            System.out.println("Event with ID 1:\n" + getEventById(1));
            System.out.println("Events of type 'login':\n" + getEventsByType("login"));
            deleteEventById(2);
            printEvents();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void addEvent(StreamEvent event) {
        Objects.requireNonNull(event, "Event cannot be null");
        EVENTS.put(event.id(), event);
        GROUP_EVENTS.computeIfAbsent(event.eventType(), v -> new ArrayList<>()).add(event);
        System.out.println("Event [" + event + "] is added successfully");
    }

    public static StreamEvent getEventById(int id) {
        StreamEvent event = EVENTS.get(id);
        if (event != null) {
            return event;
        } else {
            throw new NullPointerException("No such event with id : " + id);
        }
    }

    public static List<StreamEvent> getEventsByType(String eventToType) {
        Objects.requireNonNull(eventToType, "Event type cannot be null");
        List<StreamEvent> events = GROUP_EVENTS.get(eventToType);
        if (GROUP_EVENTS.get(eventToType) != null) {
            return events;
        } else {
            throw new NullPointerException("No such event with type : " + eventToType);
        }
    }

    public static void deleteEventById(int id) {
        StreamEvent remove = EVENTS.remove(id);
        if (remove != null) {
            GROUP_EVENTS.remove(remove);
            System.out.println("Event : " + remove + " is deleted successfully");
        } else {
            throw new NullPointerException("No such event in events list!");
        }
    }

    public static void printEvents() {
        EVENTS.forEach((k, v) -> System.out.println("id: " + k + ", event type: " +
                v.eventType() + ", event data: " + v.data()));
    }
}
