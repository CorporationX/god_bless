package school.faang.streamevent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private final Map<Integer, StreamEvent> eventById = new HashMap<>();
    private final Map<String, List<StreamEvent>> eventsByType = new HashMap<>();

    public void addEvent(StreamEvent event) {
        eventById.put(event.getId(), event);
        eventsByType.computeIfAbsent(event.getEventType(), k -> new ArrayList<>()).add(event);
    }

    public StreamEvent getEventById(int id) {
        return eventById.get(id);
    }

    public List<StreamEvent> getEventsByType(String eventType) {
        return eventsByType.getOrDefault(eventType, new ArrayList<>());
    }

    public void removeEventById(int id) {
        StreamEvent event = eventById.remove(id);
        if (event != null) {
            List<StreamEvent> eventList = eventsByType.get(event.getEventType());
            if (eventList != null) {
                eventList.remove(event);
                if (eventList.isEmpty()) {
                    eventsByType.remove(event.getEventType());
                }
            }
        }
    }

    public void printAllEvents() {
        for (Map.Entry<Integer, StreamEvent> entry : eventById.entrySet()) {
            StreamEvent event = entry.getValue();
            System.out.println("ID: " + event.getId() + ", Type: " + event.getEventType() + ", Data: " + event.getData());
        }
    }

    public static void main(String[] args) {
        Main streamProcessor = new Main();

        StreamEvent event1 = new StreamEvent(1, "LOGIN", "User1 logged in");
        StreamEvent event2 = new StreamEvent(2, "LOGOUT", "User1 logged out");
        StreamEvent event3 = new StreamEvent(3, "LOGIN", "User2 logged in");

        streamProcessor.addEvent(event1);
        streamProcessor.addEvent(event2);
        streamProcessor.addEvent(event3);

        System.out.println("Event by ID 1: " + streamProcessor.getEventById(1));
        System.out.println("Events by Type 'LOGIN': " + streamProcessor.getEventsByType("LOGIN"));

        streamProcessor.printAllEvents();

        streamProcessor.removeEventById(1);
        System.out.println("After removing event ID 1:");
        streamProcessor.printAllEvents();
    }
}
