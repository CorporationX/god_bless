package school.faang.HashMaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<Integer, StreamEvent> eventMap = new HashMap<>();
    private static Map<String, List<StreamEvent>> eventTypeMap = new HashMap<>();

    public static void main(String[] args) {
        addEvent(new StreamEvent(1, "type1", "info"));
        addEvent(new StreamEvent(2, "type2", "info"));
        addEvent(new StreamEvent(3, "type1", "info"));
        addEvent(new StreamEvent(4, "type2", "info"));
        addEvent(new StreamEvent(5, "type1", "info"));

        System.out.println(eventMap);
        System.out.println(eventTypeMap);
        searchEvent(2);
        System.out.println(searchEvents("type1"));
        deleteEvent(2);
        System.out.println(eventMap);
        System.out.println(eventTypeMap);
        getAllStreamInfo();
    }

    public static void addEvent(StreamEvent event) {
        eventMap.put(event.getId(), event);
        eventTypeMap.computeIfAbsent(event.getEventType(), e -> new ArrayList<>()).add(event);
    }

    public static StreamEvent searchEvent(int id) {
        return eventMap.get(id);
    }

    public static List<StreamEvent> searchEvents(String eventType) {
        return eventTypeMap.get(eventType);
    }

    public static void deleteEvent(int id) {
        StreamEvent event = eventMap.get(id);
        eventMap.remove(id);
        eventTypeMap.get(event.getEventType()).remove(event);
    }

    public static void getAllStreamInfo() {
        eventMap.forEach((id, event) -> System.out.println("ID " + id + ": " + "Event type: %s. Info: %s"
                .formatted(event.getEventType(), event.getData())));
    }
}
