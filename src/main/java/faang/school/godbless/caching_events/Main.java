package faang.school.godbless.caching_events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static Map<Integer, StreamEvent> streamEventMap = new HashMap<>();

    public static Map<String, List<StreamEvent>> eventTypeMap = new HashMap<>();

    public static void main(String[] args) {

        addStreamEvent(1, "event", "data");
        addStreamEvent(2, "event2", "data2");
        addStreamEvent(3, "event", "data2");

        printAllStreamEvents();

        findStreamEventById(1);

        findStreamEventByEventType("event");

        removeStreamEventById(1);

        printAllStreamEvents();
    }

    public static void addStreamEvent(int id, String eventType, String data) {
        StreamEvent streamEvent = new StreamEvent(id, eventType, data);

        streamEventMap.put(streamEvent.getId(), streamEvent);

        if (!eventTypeMap.containsKey(streamEvent.getEventType())) {
            eventTypeMap.put(streamEvent.getEventType(), new ArrayList<>(List.of(streamEvent)));
        } else {
            eventTypeMap.get(streamEvent.getEventType()).add(streamEvent);
        }
    }

    public static StreamEvent findStreamEventById(int id) {
        return streamEventMap.get(id);
    }

    public static List<StreamEvent> findStreamEventByEventType(String eventType) {
        return eventTypeMap.get(eventType);
    }

    public static void removeStreamEventById(int id) {
        StreamEvent streamEvent = streamEventMap.get(id);
        streamEventMap.remove(id);

        eventTypeMap.get(streamEvent.getEventType()).remove(id);
    }

    public static void printAllStreamEvents() {
        for (Map.Entry<Integer, StreamEvent> entry : streamEventMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
