package faang.school.godbless.catchevent;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private final static Map<Integer, StreamEvent> eventsMap = new HashMap<>();
    private final static Map<String, List<StreamEvent>> eventsStream = new HashMap<>();

    public static void addEvent(StreamEvent event) {
        eventsMap.put(event.getId(), event);

        if (!eventsStream.containsKey(event.getEventType())) {
            eventsStream.put(event.getEventType(), new ArrayList<>());
        }

        eventsStream.get(event.getEventType()).add(event);
    }

    public static StreamEvent getEvent(int id) {
        return eventsMap.get(id);
    }

    public static List<StreamEvent> getEventsStream(String eventType) {
        return eventsStream.get(eventType);
    }

    public static void removeEvent(int id) {
        getEventsStream(eventsMap.get(id).getEventType()).remove(eventsMap.get(id));
        if (getEventsStream(eventsMap.get(id).getEventType()).isEmpty()) {
            eventsStream.remove(eventsMap.get(id).getEventType());
        }
        eventsMap.remove(id);
    }

    public static void printAllEvents() {
        for (Map.Entry<Integer, StreamEvent> entry : eventsMap.entrySet()) {
            System.out.println("id: " + entry.getValue().getId() +
                    "; type: " + entry.getValue().getEventType() +
                    "; data: " + entry.getValue().getData());
        }
    }

    public static void main(String[] args) {
        System.out.println("add new event...");
        System.out.println("eventsMap before: " + eventsMap);
        System.out.println("eventsStreams before: " + eventsStream);

        addEvent(new StreamEvent(0, "new zero event", "some data"));
        addEvent(new StreamEvent(1, "new first event", "some data for first event"));
        addEvent(new StreamEvent(2, "event for stream 0", "some data for stream 0 event"));
        addEvent(new StreamEvent(3, "event for stream 0", "some data for stream 0 event"));
        addEvent(new StreamEvent(4, "event for stream 1", "some data for stream 0 event"));
        addEvent(new StreamEvent(5, "event for stream 1", "some data for stream 0 event"));

        System.out.println();
        System.out.println("eventsMap after: " + eventsMap);
        System.out.println("eventsStreams after: " + eventsStream);

        System.out.println();

        System.out.println("get added events by id:");
        System.out.println(getEvent(0));
        System.out.println(getEvent(1));

        System.out.println();

        System.out.println("get stream events by type:");
        System.out.println(getEventsStream("event for stream 0"));
        System.out.println(getEventsStream("event for stream 1"));

        System.out.println();
        System.out.println("remove events by id:");

        System.out.println("eventsMap before: " + eventsMap);
        System.out.println("eventsStreams before: " + eventsStream);

        removeEvent(0);
        removeEvent(1);

        System.out.println();
        System.out.println("eventsMap after: " + eventsMap);
        System.out.println("eventsStreams after: " + eventsStream);

        System.out.println();
        System.out.println("print all events by entry:");
        printAllEvents();
    }
}
