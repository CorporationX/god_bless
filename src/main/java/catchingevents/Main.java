package catchingevents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<Integer, StreamEvent> streamEvents = new HashMap<>();
    private static Map<String, List<StreamEvent>> eventsByType = new HashMap<>();

    public static void main(String[] args) {
        addNewStreamEvent(new StreamEvent(1, "type1", "data1"));
        addNewStreamEvent(new StreamEvent(2, "type1", "data2"));
        addNewStreamEvent(new StreamEvent(3, "type2", "data3"));
        addNewStreamEvent(new StreamEvent(4, "type3", "data4"));

        System.out.println(getEventById(4));
        System.out.println(getEventsByType("type1"));
        removeStreamEvent(4);
        printAllStreamEvents();

        removeStreamEvent(1);
        System.out.println(getEventsByType("type1"));
    }

    public static void addNewStreamEvent(StreamEvent streamEvent) {
        streamEvents.put(streamEvent.getId(), streamEvent);

        if (eventsByType.containsKey(streamEvent.getEventType())) {
            eventsByType.get(streamEvent.getEventType()).add(streamEvent);
        } else {
            List<StreamEvent> newTypeEvents = new ArrayList<>();
            newTypeEvents.add(streamEvent);
            eventsByType.put(streamEvent.getEventType(), newTypeEvents);
        }
    }

    public static StreamEvent getEventById(int eventId) {
        return streamEvents.get(eventId);
    }

    public static List<StreamEvent> getEventsByType(String eventType) {
        return eventsByType.get(eventType);
    }

    public static void removeStreamEvent(int eventId) {
        String eventType = streamEvents.get(eventId).getEventType();
        eventsByType.get(eventType).remove(getEventById(eventId));
        streamEvents.remove(eventId);
    }

    public static void printAllStreamEvents() {
        for (var entry : streamEvents.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
