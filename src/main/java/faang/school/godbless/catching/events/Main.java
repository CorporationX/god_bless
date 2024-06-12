package faang.school.godbless.catching.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static Map<Integer, StreamEvent> eventById = new HashMap<>();
    private static Map<String, List<StreamEvent>> eventByType = new HashMap<>();

    public static void addEvent(StreamEvent event) {
        eventById.put(event.getId(), event);
        // containsKey() не работает
        if (!eventByType.containsKey(event.getEventType())) {
            eventByType.put(event.getEventType(), new ArrayList<>());
        }
        eventByType.get(event.getEventType()).add(event);
    }


    public static StreamEvent findEventById(int id) {
        if(id != 0) {
            return eventById.get(id);
        }
        else {
            System.err.println("Error!");
            return null;
        }
    }

    public static List<StreamEvent> findEventsByType(String eventType) {
        if(eventType != null) {
            return eventByType.get(eventType);
        }
        else {
            System.err.println("Error!");
            return null;
        }
    }

    public static void removeEventById(int id) {
        if(id != 0 && !eventById.containsKey(id)) {
            eventById.remove(id);
        }
        else {
            System.err.println("Error!");
        }

    }

    public static void printAllEvents() {
        for (Map.Entry<Integer, StreamEvent> entry : eventById.entrySet()) {
            System.out.println(entry.toString());
        }
    }


    public static void main(String[] args) {
        addEvent(new StreamEvent(1, "login", "User1 logged in"));
        addEvent(new StreamEvent(2, "logout", "User1 logged out"));
        addEvent(new StreamEvent(3, "login", "User2 logged in"));

        System.out.println("Find event by ID 2: " + findEventById(2));
        System.out.println("Find events by type 'login': " + findEventsByType("login"));

        removeEventById(2);

        printAllEvents();
    }
}
