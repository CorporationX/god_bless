package catch_event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static final Map<Integer, StreamEvent> STREAM_EVENTS = new HashMap<>();
    static final Map<String, List<StreamEvent>> EVENTS_BY_USER = new HashMap<>();

    public static void main(String[] args) {;
        addNewEvent(new StreamEvent(1, "user.created", "John"));
        addNewEvent(new StreamEvent(2, "user.created", "Kate"));
        addNewEvent(new StreamEvent(3, "user.login", "Kate"));

        System.out.println(STREAM_EVENTS);
        System.out.println(EVENTS_BY_USER);

        searchEventByID(1);

        searchEventsByType("user.login");

        removeEventByID(2);

        System.out.println(STREAM_EVENTS);
        System.out.println(EVENTS_BY_USER);

        printAllInfo();
    }

    public static void addNewEvent(StreamEvent streamEvent) {
        STREAM_EVENTS.put(streamEvent.getId(), streamEvent);
        EVENTS_BY_USER.computeIfAbsent(streamEvent.getEventType(), k -> new ArrayList<>()).add(streamEvent);
    }

    public static void searchEventByID(int id) {
        System.out.println(STREAM_EVENTS.get(id));
    }

    public static void searchEventsByType(String eventType) {
        System.out.println(EVENTS_BY_USER.get(eventType));
    }

    public static void removeEventByID(int id) {
        StreamEvent removedEvent = STREAM_EVENTS.remove(id);
        EVENTS_BY_USER.remove(removedEvent.getEventType()).remove(removedEvent);
    }

    public static void printAllInfo() {
        for (Map.Entry<Integer, StreamEvent> entry : STREAM_EVENTS.entrySet()) {
            System.out.println("ID: " + entry.getKey() + ", type: " + entry.getValue().getEventType() + ", data: " + entry.getValue().getData());
        }
    }
}
