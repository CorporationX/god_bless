package school.faang.hashmap.catchingEvents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    static HashMap<Integer, StreamEvent> eventMap = new HashMap<>();
    static HashMap<String, List<StreamEvent>> eventTypeMap = new HashMap<>();

    public static void main(String[] args) {

        addEvent(new StreamEvent(1, "login", "user1"));
        addEvent(new StreamEvent(2, "message", "Hello world!"));
        addEvent(new StreamEvent(3, "logout", "user1"));
        addEvent(new StreamEvent(4, "login", "user2"));

        printAllEvents();

        StreamEvent event = getEventById(2);
        System.out.println("\nСобытие с ID 2: " + event.getData());

        List<StreamEvent> loginEvents = getEventsByType("login");
        System.out.println("\nСобытия типа 'login':");
        for (StreamEvent e : loginEvents) {
            System.out.println("ID: " + e.getId() + ", Данные: " + e.getData());
        }

        removeEvent(3);

        printAllEvents();
    }

    public static void addEvent(StreamEvent event) {
        eventMap.put(event.getId(), event);
        eventTypeMap.computeIfAbsent(event.getEventType(),
                k -> new ArrayList<>()).add(event);
    }

    public static StreamEvent getEventById(int id) {
        return eventMap.get(id);
    }

    public static List<StreamEvent> getEventsByType(String eventType) {
        return eventTypeMap.get(eventType);
    }

    public static void removeEvent(int id) {
        StreamEvent event = eventMap.remove(id);
        if (event != null) {
            eventTypeMap.get(event.getEventType()).removeIf(e -> e.getId() == id);
        }
    }

    public static void printAllEvents() {
        eventMap.forEach((key, value) -> System.out.printf("ID: %d, Тип: %s," +
                        " Данные: %s%n", key, value.getEventType(),
                value.getData()));
    }
}


