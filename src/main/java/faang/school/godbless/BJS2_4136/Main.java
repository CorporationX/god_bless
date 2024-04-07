package faang.school.godbless.BJS2_4136;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<Integer, StreamEvent> EVENTS_BY_ID = new HashMap<>();
    private static final Map<String, List<StreamEvent>> EVENTS_BY_TYPE = new HashMap<>();

    public static void main(String[] args) {
        addEvent(new StreamEvent(1, "Тип 1", "Data 1"));
        addEvent(new StreamEvent(2, "Тип 2", "Data 2"));
        addEvent(new StreamEvent(3, "Тип 3", "Data 3"));
        addEvent(new StreamEvent(4, "Тип 2", "Data 3"));
        printAllEvents(EVENTS_BY_ID);

        System.out.println(findEventById(2, EVENTS_BY_ID));
        System.out.println(findEVENTS_BY_TYPE("Тип 2", EVENTS_BY_TYPE));

        removeEventById(2);
        printAllEvents(EVENTS_BY_ID);
    }

    public static void addEvent(StreamEvent event) {
        EVENTS_BY_ID.put(event.getId(), event);
        EVENTS_BY_TYPE.computeIfAbsent(event.getEventType(), k -> new ArrayList<>()).add(event);
    }

    public static void removeEventById(int id) {
        StreamEvent event = EVENTS_BY_ID.remove(id);
        if (event != null) {
            EVENTS_BY_TYPE.computeIfPresent(event.getEventType(), (type, events) -> {
                events.removeIf(e -> e.getId() == id);
                return events;
            });
        }
    }

    public static StreamEvent findEventById(int id, Map<Integer, StreamEvent> target) {
        return target.get(id);
    }

    public static List<StreamEvent> findEVENTS_BY_TYPE(String eventType, Map<String, List<StreamEvent>> target) {
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
