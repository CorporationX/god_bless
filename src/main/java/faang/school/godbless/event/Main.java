package faang.school.godbless.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Main {
    public static final Map<Integer, StreamEvent> idEventMap = new HashMap<>();
    public static final Map<EventType, List<StreamEvent>> typeEventsMap = new HashMap<>();

    public static void main(String[] args) {
        addEvent(new StreamEvent(1, EventType.CREATE, "User1 created a post"));
        addEvent(new StreamEvent(2, EventType.UPDATE, "User1 updated a post"));
        addEvent(new StreamEvent(3, EventType.UPDATE, "User2 created a post"));
        addEvent(new StreamEvent(4, EventType.DELETE, "User1 deleted a post"));

        printAll();
    }

    public static void addEvent(StreamEvent event) {
        idEventMap.put(event.getId(), event);
        typeEventsMap.computeIfAbsent(event.getEventType(), k -> new ArrayList<>()).add(event);
    }

    public static StreamEvent findEvent(int eventId) {
        return idEventMap.get(eventId);
    }

    public static List<StreamEvent> findEventList(EventType eventType) {
        return typeEventsMap.get(eventType);
    }

    public static void deleteEvent(int eventId) {
        Optional.ofNullable(idEventMap.remove(eventId))
                .ifPresent(event -> typeEventsMap.get(event.getEventType()).remove(event));
    }

    private static void printAll() {
        idEventMap.values().forEach(System.out::println);
    }
}
