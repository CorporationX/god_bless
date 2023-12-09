package faang.school.godbless.BJS2_571;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static Map<Integer, StreamEvent> streamEvents = new HashMap<>();
    public static Map<String, List<StreamEvent>> streamEventsByType = new HashMap<>();

    public static void main(String[] args) {
        StreamEvent streamEvent1 = new StreamEvent("some event", "data data");
        StreamEvent streamEvent2 = new StreamEvent("same type", "data2");
        StreamEvent streamEvent3 = new StreamEvent("same type", "dataaaaaaa");
        StreamEvent streamEvent4 = new StreamEvent("another event", "another data");
        StreamEvent streamEvent5 = new StreamEvent("some event", "data data");
        StreamEvent streamEvent6 = new StreamEvent("same type", "ATAD");

        addEvent(streamEvent1);
        addEvent(streamEvent2);
        addEvent(streamEvent3);
        addEvent(streamEvent4);
        addEvent(streamEvent5);
        addEvent(streamEvent6);

        System.out.println(findByEventType("same type"));

        System.out.println("-----------------------------------------");

        infoAllStreamEvent();
    }

    public static void addEvent(StreamEvent streamEvent) {
        streamEvents.put(streamEvent.getId(), streamEvent);

        streamEventsByType.computeIfAbsent(streamEvent.getEventType(), k -> new ArrayList<>())
                .add(streamEvent);
    }

    public static StreamEvent findById(int id) {
        return streamEvents.get(id);
    }

    public static List<StreamEvent> findByEventType(String eventType) {
        return streamEventsByType.get(eventType);
    }

    public static void removeStreamEventById(int id) {
        StreamEvent removedEvent = streamEvents.remove(id);
        if (removedEvent != null) {
            streamEventsByType.get(removedEvent.getEventType()).remove(removedEvent);
        }
    }

    public static void infoAllStreamEvent() {
        streamEvents.values().forEach(event ->
                System.out.printf("id: %s. Event type: %s. Event data: %s.%n"
                        , event.getId(), event.getEventType(), event.getData())
        );
    }
}