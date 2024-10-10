package school.faang.java_hashmap.catch_events;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<Integer, StreamEvent> EVENT_MAP = new HashMap<>();
    private static final Map<String, List<StreamEvent>> EVENT_TYPE = new HashMap<>();

    public static void main(String[] args) {
        addEvent(new StreamEvent(1, "INFO", "Event data 1"));
        addEvent(new StreamEvent(2, "ERROR", "Event data 2"));
        addEvent(new StreamEvent(3, "INFO", "Event data 3"));

        System.out.println("All Events");
        displayAllEvents();

        System.out.println("Event with ID 1" + getEventById(1));

        System.out.println("INFO EVENT  " + getEventByType("INFO"));

        removeById(1);
        System.out.println("All events after removing ID 1:");

        displayAllEvents();
    }

    public static void addEvent(StreamEvent streamEvent) {
        EVENT_MAP.put(streamEvent.getId(), streamEvent);
        EVENT_TYPE.putIfAbsent(streamEvent.getEventType(), new ArrayList<>());
        EVENT_TYPE.get(streamEvent.getEventType()).add(streamEvent);
    }

    public static StreamEvent getEventById(int id) {
        return EVENT_MAP.get(id);
    }

    public static List<StreamEvent> getEventByType(String eventType) {
        return EVENT_TYPE.getOrDefault(eventType, new ArrayList<>());
    }

    public static void removeById(int id) {
        StreamEvent event = EVENT_MAP.remove(id);
        if (event != null) {
            List<StreamEvent> events = EVENT_TYPE.get(event.getEventType());
            events.remove(event);
            if (events.isEmpty()) {
                EVENT_TYPE.remove(event.getEventType());
            }
        }
    }

    public static void displayAllEvents() {
        for (Map.Entry<Integer, StreamEvent> entry : EVENT_MAP.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}


