package faang.school.godbless.streamevent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, StreamEvent> eventsMap = new HashMap<>();
        Map<String, List<StreamEvent>> eventsTypeMap = new HashMap<>();

        addEvent(eventsMap, eventsTypeMap, new StreamEvent(1, "Add", "Add Message"));
        addEvent(eventsMap, eventsTypeMap, new StreamEvent(2, "Update", "Update Message"));
        addEvent(eventsMap, eventsTypeMap, new StreamEvent(3, "Delete", "Delete Message"));
        addEvent(eventsMap, eventsTypeMap, new StreamEvent(4, "Add", "Add Message2"));
        addEvent(eventsMap, eventsTypeMap, new StreamEvent(5, "Update", "Update Message2"));

        eventsInfo(eventsMap);
        System.out.println();

        System.out.println(findEventById(eventsMap, 1));
        System.out.println(findEventById(eventsMap, 5) + "\n");

        System.out.println(findEventsByType(eventsTypeMap, "Update"));
        System.out.println(findEventsByType(eventsTypeMap, "Delete") + "\n");

        removeEvent(eventsMap, eventsTypeMap, 3);
        removeEvent(eventsMap, eventsTypeMap, 4);

        eventsInfo(eventsMap);
        System.out.println();
    }

    private static void addEvent(Map<Integer, StreamEvent> eventsMap, Map<String, List<StreamEvent>> eventsTypeMap,
                                 StreamEvent streamEvent) {
        eventsMap.put(streamEvent.getId(), streamEvent);
        eventsTypeMap.computeIfAbsent(streamEvent.getEventType(), k -> new ArrayList<>()).add(streamEvent);
    }

    private static StreamEvent findEventById(Map<Integer, StreamEvent> eventsMap, Integer eventId) {
        return eventsMap.get(eventId);
    }

    private static List<StreamEvent> findEventsByType(Map<String, List<StreamEvent>> eventsTypeMap, String eventType) {
        return eventsTypeMap.get(eventType);
    }

    private static void removeEvent(Map<Integer, StreamEvent> eventsMap, Map<String, List<StreamEvent>> eventsTypeMap, Integer eventId) {
        StreamEvent removedEvent = eventsMap.remove(eventId);
        eventsTypeMap.get(removedEvent.getEventType()).remove(removedEvent);
    }

    public static void eventsInfo(Map<Integer, StreamEvent> eventsMap) {
        eventsMap.forEach((key, value) -> System.out.println("Event ID: " + key + ", EventType: " +
                value.getEventType() + ", Data: " + value.getData()));
    }
}
