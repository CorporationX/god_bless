package school.faang.CatchingEvents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<Integer, StreamEvent> EVENTS_BY_ID = new HashMap<>();
    private static final Map<String, List<StreamEvent>> EVENTS_BY_TYPE = new HashMap<>();

    public static void main(String[] args) {
        StreamEvent event1 = new StreamEvent(1, "TYPE_1", "Data 1");
        StreamEvent event2 = new StreamEvent(2, "TYPE_2", "Data 2");
        StreamEvent event3 = new StreamEvent(3, "TYPE_3", "Data 3");
        StreamEvent event4 = new StreamEvent(4, "TYPE_3", "Data 4");

        addEvent(event1);
        addEvent(event2);
        addEvent(event3);
        addEvent(event4);

        System.out.println("Events: ");
        printEvents();

        System.out.println("Event with id 2: ");
        System.out.println(findEventById(2));

        System.out.println("Events with TYPE_3: ");
        System.out.println(findEventsByType("TYPE_3"));

        System.out.println("Remove event with id 1");
        removeEventById(1);
        printEvents();

    }

    public static void addEvent(StreamEvent event) {
        EVENTS_BY_ID.put(event.getId(), event);
        EVENTS_BY_TYPE.computeIfAbsent(event.getEventType(), k -> new ArrayList<>()).add(event);
    }

    public static StreamEvent findEventById(int id) {
        return EVENTS_BY_ID.get(id);
    }

    public static List<StreamEvent> findEventsByType(String type) {
        return EVENTS_BY_TYPE.get(type);
    }

    public static void removeEventById(int id) {
        StreamEvent event = EVENTS_BY_ID.remove(id);

        if (event != null) {
            List<StreamEvent> events = EVENTS_BY_TYPE.get(event.getEventType());
            events.remove(event);
            if (events.isEmpty()) {
                EVENTS_BY_TYPE.remove(event.getEventType());
            }
        }
    }

    public static void printEvents() {
        EVENTS_BY_ID.forEach((id, event) -> {
            System.out.println(event.toString());
        });
    }
}
