package streamEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<Integer, StreamEvent> EVENT_MAP = new HashMap<>();
    private static final Map<String, List<StreamEvent>> EVENT_GROUP = new HashMap<>();

    public static void addEvent(StreamEvent event) {
        EVENT_MAP.putIfAbsent(event.getId(), event);
        EVENT_GROUP.putIfAbsent(event.getEventType(), new ArrayList<>());
        EVENT_GROUP.get(event.getEventType()).add(event);
    }

    public static StreamEvent getEvent(int id) {
        return EVENT_MAP.get(id);
    }

    public static List<StreamEvent> getEventGroup(String eventType) {
        return EVENT_GROUP.get(eventType);
    }

    public static void deleteEvent(int id) {
        EVENT_GROUP.get(EVENT_MAP.get(id).getEventType()).remove(EVENT_MAP.get(id));
        EVENT_MAP.remove(id);
    }

    public static void printEvents() {
        for (Map.Entry<Integer, StreamEvent> entry : EVENT_MAP.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public static void main(String[] args) {
        addEvent(new StreamEvent(1, "INFO", "Событие 1"));
        addEvent(new StreamEvent(2, "ERROR", "Событие 2"));
        addEvent(new StreamEvent(3, "WARNING", "Событие 3"));
        addEvent(new StreamEvent(4, "INFO", "Событие 4"));
        addEvent(new StreamEvent(5, "DEBUG", "Событие 5"));
        addEvent(new StreamEvent(6, "ERROR", "Событие 6"));
        addEvent(new StreamEvent(7, "INFO", "Событие 7"));
        addEvent(new StreamEvent(8, "WARNING", "Событие 8"));
        addEvent(new StreamEvent(9, "DEBUG", "Событие 9"));
        addEvent(new StreamEvent(10, "ERROR", "Событие 10"));

        printEvents();

        System.out.println(getEvent(3));
        System.out.println(getEventGroup("ERROR"));

        deleteEvent(3);

        printEvents();
        System.out.println(getEvent(3));
        System.out.println(getEventGroup("WARNING"));

    }
}
