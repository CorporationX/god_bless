package faang.school.godbless.eventcatch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Main {

    private static Map<Integer, StreamEvent> streamEvents = new HashMap<>();
    private static Map<String, List<StreamEvent>> streamEventsByTypes = new HashMap<>();

    public static void main(String[] args) {
        StreamEvent event1 = new StreamEvent(1, "Type1", "Data1");
        StreamEvent event2 = new StreamEvent(2, "Type2", "Data2");
        StreamEvent event3 = new StreamEvent(3, "Type1", "Data3");

        addStreamEvent(event1);
        addStreamEvent(event2);
        addStreamEvent(event3);

        Optional<StreamEvent> foundEvent = findEventById(2);
        if (foundEvent.isPresent()) {
            StreamEvent streamEvent = foundEvent.get();
            System.out.println(streamEvent.getId() + " " + streamEvent.getEventType() + " " + streamEvent.getData());
        }

        System.out.println();

        Optional<List<StreamEvent>> foundEventsByType = findEventsByEventType("Type1");
        if (foundEventsByType.isPresent()) {
            for (var event : foundEventsByType.get()) {
                System.out.println(event.getId() + " " + event.getEventType() + " " + event.getData());
            }
        }

        deleteEventById(1);
        printAllStreamEvents();
    }

    public static void addStreamEvent(StreamEvent streamEvent) {
        streamEvents.put(streamEvent.getId(), streamEvent);
        String eventType = streamEvent.getEventType();
        List<StreamEvent> events = streamEventsByTypes.get(eventType);
        if (events != null) {
            events.add(streamEvent);
        }
        else {
            List<StreamEvent> newEvents = new ArrayList<>();
            newEvents.add(streamEvent);
            streamEventsByTypes.put(eventType, newEvents);
        }
    }

    public static Optional<StreamEvent> findEventById(int id) {
        return Optional.ofNullable(streamEvents.get(id));
    }

    public static Optional<List<StreamEvent>> findEventsByEventType(String eventType) {
        return Optional.ofNullable(streamEventsByTypes.get(eventType));
    }

    public static void deleteEventById(int id) {
        StreamEvent streamEvent = streamEvents.remove(id);
        List<StreamEvent> events = streamEventsByTypes.get(streamEvent.getEventType());
        if (events != null) {
            events.remove(streamEvent);
        }
    }

    public static void printAllStreamEvents() {
        for (var entry : streamEvents.entrySet()) {
            System.out.println(String.format("ID: %d, EventType: %s, Data: %s", entry.getKey(),
                                                                                entry.getValue().getEventType(),
                                                                                entry.getValue().getData()));
        }
    }
}
