package faang.school.godbless.BJS2_4136;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<Integer, StreamEvent> eventsById = new HashMap<>();
    private static final Map<String, List<StreamEvent>> eventsByType = new HashMap<>();

    public static void main(String[] args) {
        addEvent(new StreamEvent(1, "Тип 1", "Data 1"));
        addEvent(new StreamEvent(2, "Тип 2", "Data 2"));
        addEvent(new StreamEvent(3, "Тип 3", "Data 3"));
        addEvent(new StreamEvent(4, "Тип 2", "Data 3"));
        printAllEvents(eventsById);

        System.out.println(findEventById(2, eventsById));
        System.out.println(findEventsByType("Тип 2", eventsByType));

        removeEventById(2);
        printAllEvents(eventsById);
    }

    public static void addEvent(StreamEvent event) {
        eventsById.put(event.getId(), event);
        eventsByType.computeIfAbsent(event.getEventType(), k -> new ArrayList<>()).add(event);
    }

    public static void removeEventById(int id) {
        StreamEvent event = eventsById.remove(id);
        if (event != null) {
            eventsByType.computeIfPresent(event.getEventType(), (type, events) -> {
                events.removeIf(e -> e.getId() == id);
                return events;
            });
        }
    }

    public static StreamEvent findEventById(int id, Map<Integer, StreamEvent> target) {
        return target.get(id);
    }

    public static List<StreamEvent> findEventsByType(String eventType, Map<String, List<StreamEvent>> target) {
        return target.getOrDefault(eventType, new ArrayList<>());
    }

    public static void printAllEvents(Map<Integer, StreamEvent> target) {
        System.out.println("Все события:");
        for (Map.Entry<Integer, StreamEvent> entry : target.entrySet()) {
            StreamEvent event = entry.getValue();
            System.out.printf("ID=%s, Type=%s, Data=%s", event.getId(), event.getEventType(), event.getData());
            System.out.println();
        }
    }
}
