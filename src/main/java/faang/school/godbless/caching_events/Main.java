package faang.school.godbless.caching_events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static Map<Integer, StreamEvent> streamEventById = new HashMap<>();

    public static Map<String, List<StreamEvent>> streamEventsByType = new HashMap<>();

    public static void main(String[] args) {
        addStreamEvent(1, "event", "data");
        addStreamEvent(2, "event2", "data2");
        addStreamEvent(3, "event", "data2");

        printAllStreamEvents();

        System.out.println(findStreamEventById(1));

        System.out.println(findStreamEventByEventType("event"));

        removeStreamEventById(4);

        printAllStreamEvents();
    }

    public static void addStreamEvent(int id, String eventType, String data) {
        StreamEvent streamEvent = new StreamEvent(id, eventType, data);

        streamEventById.put(streamEvent.getId(), streamEvent);

        if (!streamEventsByType.containsKey(streamEvent.getEventType())) {
            streamEventsByType.put(streamEvent.getEventType(), new ArrayList<>(List.of(streamEvent)));
        } else {
            streamEventsByType.get(streamEvent.getEventType()).add(streamEvent);
        }
    }

    public static StreamEvent findStreamEventById(int id) {
        return streamEventById.get(id);
    }

    public static List<StreamEvent> findStreamEventByEventType(String eventType) {
        return streamEventsByType.get(eventType);
    }

    public static void removeStreamEventById(int id) {
        StreamEvent streamEvent = streamEventById.get(id);
        streamEventById.remove(id);
        try {
            streamEventsByType.get(streamEvent.getEventType()).remove(id);
        } catch (NullPointerException ex) {
            System.out.println("StreamEvent с айди - " + id + " не найден!");
        }
    }

    public static void printAllStreamEvents() {
        for (Map.Entry<Integer, StreamEvent> entry : streamEventById.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
