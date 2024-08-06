package faang.school.godbless.streamEvents;

import java.util.*;

public class Main {
    private static HashMap<Integer, StreamEvent> events = new HashMap<>();
    private static HashMap<String, List<StreamEvent>> eventsByTypes = new HashMap<>();

    public static void addEvent(StreamEvent event) {
        events.put(event.getId(), event);
        if (eventsByTypes.containsKey(event.getEventType())) {
            eventsByTypes.get(event.getEventType()).add(event);
        } else {
            eventsByTypes.put(event.getEventType(), new LinkedList<>(List.of(event)));
        }
    }

    public static StreamEvent getEventById(int id) {
        return events.get(id);
    }

    public static List<StreamEvent> getEventsByType(String type) {
        return eventsByTypes.get(type);
    }

    public static void deleteEvent(int id) {
        eventsByTypes.get(events.get(id).getEventType()).remove(events.get(id));
        events.remove(id);
    }

    public static void printAllEvents(){
        for (StreamEvent event : events.values()) {
            System.out.println(event);
        }
    }

    public static void main(String[] args) {
        addEvent(new StreamEvent(1, "Messages", "Sending message"));
        addEvent(new StreamEvent(2, "Messages", "Comment"));
        addEvent(new StreamEvent(3, "Financial data", "Purchase"));
        addEvent(new StreamEvent(4, "Financial data", "Transfer"));
        addEvent(new StreamEvent(5, "Sensor data", "Getting temperature"));
        addEvent(new StreamEvent(6, "Sensor data", "Getting humidity"));
        addEvent(new StreamEvent(7, "Logging", "User logged in"));
        addEvent(new StreamEvent(8, "Logging", "Logging error"));
        addEvent(new StreamEvent(9, "Social media", "Like"));
        addEvent(new StreamEvent(10, "Social media", "Repost"));
        addEvent(new StreamEvent(11, "Social media", "Subscription"));
        addEvent(new StreamEvent(12, "Social media", "View"));

        System.out.println(getEventById(3));
        System.out.println(Arrays.toString(getEventsByType("Logging").toArray()));

        deleteEvent(10);

        System.out.println("All events:");
        printAllEvents();
    }
}
