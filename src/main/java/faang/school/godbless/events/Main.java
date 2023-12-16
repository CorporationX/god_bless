package faang.school.godbless.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<Integer, StreamEvent> streamMap;
    private static Map<String, List<StreamEvent>> streamEvents;

    public static void main(String[] args) {

        streamMap = new HashMap<>();
        streamEvents = new HashMap<>();

        StreamEvent event1 = new StreamEvent("Error", "all crash");
        StreamEvent event2 = new StreamEvent("Error", "all data is lost");
        StreamEvent event3 = new StreamEvent("Exception", "wrong type of data");
        StreamEvent event4 = new StreamEvent("Exception", "nothing");

        addEvent(event1);
        addEvent(event2);
        addEvent(event3);
        addEvent(event4);

        getEvents();
        System.out.println();
        getEventsSortedByType();
        System.out.println();

        deleteEventByID(1);
        getEvents();
        System.out.println();
        getEventsSortedByType();
        System.out.println();

        getEventByID(2);
        System.out.println();
        getEventsByType("Exception");
    }

    public static void addEvent(StreamEvent streamEvent) {
        streamMap.put(streamEvent.getId(), streamEvent);
        streamEvents.putIfAbsent(streamEvent.getEventType(), new ArrayList<>());
        streamEvents.get(streamEvent.getEventType()).add(streamEvent);
    }

    public static void getEventByID(int id) {
        System.out.println("StreamEvent: " + streamMap.get(id));
    }

    public static void getEventsByType(String type) {
        System.out.println("StreamEvents: " + streamEvents.get(type));
    }

    public static void deleteEventByID(int id) {
        StreamEvent event = streamMap.get(id);
        streamMap.remove(id);
        streamEvents.get(event.getEventType()).remove(event);
    }

    public static void getEvents() {
        for (Map.Entry<Integer, StreamEvent> entry : streamMap.entrySet()) {
            System.out.println("Event ID: " + entry.getKey() + " event type: " +
                    entry.getValue().getEventType() + " event data: " +
                    entry.getValue().getData());
        }
    }

    public static void getEventsSortedByType() {
        for (Map.Entry<String, List<StreamEvent>> entry : streamEvents.entrySet()) {
            System.out.println("Event type: " + entry.getValue());
        }
    }
}
