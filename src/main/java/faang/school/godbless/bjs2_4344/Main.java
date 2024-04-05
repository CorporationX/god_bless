package faang.school.godbless.bjs2_4344;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    private static final Map<Long, StreamEvent> STREAM_EVENT_MAP = new ConcurrentHashMap<>();
    private static final Map<String, List<StreamEvent>> STREAM_LIST_MAP = new ConcurrentHashMap<>();


    public static void main(String[] args) {
        //add StreamEvent
        addStreamEvent(new StreamEvent(1L, "Message", "First message"));

        //Search event by ID
        System.out.println(searchStreamById(1L));

        //add another StreamEvents
        addStreamEvent(new StreamEvent(2L, "Message", "Second message"));
        addStreamEvent(new StreamEvent(3L, "Alter", "First alert"));

        //Search events by EventType
        System.out.println("\nList messages");
        getEventListByEventType("Message").forEach(System.out::println);

        //Print all events
        System.out.println("\nPrint all events");
        printAllEvents();

        //Remove event
        removeStreamEventById(2L);
        System.out.println("\nRemove event with ID: 2");
        System.out.println("Print all events");
        printAllEvents();
    }

    public static void addStreamEvent(StreamEvent streamEvent) {
        STREAM_EVENT_MAP.put(streamEvent.getId(), streamEvent);
        STREAM_LIST_MAP.computeIfAbsent(streamEvent.getEventType(), key -> new ArrayList<>()).add(streamEvent);
    }

    public static StreamEvent searchStreamById(Long id) {
        return STREAM_EVENT_MAP.get(id);
    }

    public static List<StreamEvent> getEventListByEventType(String eventType) {
        return STREAM_LIST_MAP.get(eventType);
    }

    public static void removeStreamEventById(Long id) {
        var streamEvent = STREAM_EVENT_MAP.get(id);
        Objects.requireNonNull(STREAM_LIST_MAP.computeIfPresent(streamEvent.getEventType(), (key, value) -> value))
                .remove(streamEvent);
        STREAM_EVENT_MAP.remove(id);
    }

    public static void printAllEvents() {
        for (Map.Entry<Long, StreamEvent> eventEntry : STREAM_EVENT_MAP.entrySet()) {
            System.out.println("Event ID: " + eventEntry.getKey() + ", EventType: " +
                    eventEntry.getValue().getEventType() + ", Data: " + eventEntry.getValue().getData());
        }
    }
}


