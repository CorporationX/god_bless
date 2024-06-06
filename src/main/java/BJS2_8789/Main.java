package BJS2_8789;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static Map<Integer, StreamEvent> events = new HashMap<>();
    static Map<String, List<StreamEvent>> groupEvents = new HashMap<>();


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
        events.entrySet().removeIf(event -> events.containsKey(id));

        groupEvents.entrySet().stream().map(Map.Entry::getValue).flatMap(events->)

    }
}
