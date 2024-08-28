package faang.school.godbless.BJS2_20669;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static Map<Integer,StreamEvent> eventById = new HashMap<>();
    private static Map<String, List<StreamEvent>> eventsByType = new HashMap<>();
    public static void main(String[] args) {
        addStreamEvent(new StreamEvent(1, "click", "User clicked on button"));
        addStreamEvent(new StreamEvent(2, "scroll", "User scrolled the page"));
        addStreamEvent(new StreamEvent(3, "click", "User clicked on link"));

        System.out.println(findStreamEventById(1));

        System.out.println(findStreamEventsByType("click"));

        removeStreamEventById(1);

        printAllStreamEvents();
    }

    public static void addStreamEvent(StreamEvent event) {
        eventById.put(event.getId(), event);
        eventsByType.computeIfAbsent(event.getEventType(), k -> new ArrayList<>()).add(event);
    }
    public static StreamEvent findStreamEventById(int id) {
        return eventById.get(id);
    }

    public static List<StreamEvent> findStreamEventsByType(String eventType) {
        return eventsByType.getOrDefault(eventType, new ArrayList<>());
    }
    public static void removeStreamEventById(int id) {
        StreamEvent removedEvent = eventById.remove(id);
        if (removedEvent != null) {
            List<StreamEvent> events = eventsByType.get(removedEvent.getEventType());
            if (events != null) {
                events.remove(removedEvent);
                if (events.isEmpty()) {
                    eventsByType.remove(removedEvent.getEventType());
                }
            }
        }
    }
    public static void printAllStreamEvents() {
        for (Map.Entry<Integer, StreamEvent> entry : eventById.entrySet()) {
            System.out.println("ID: " + entry.getKey() + ", Event: " + entry.getValue());
        }
    }
}
