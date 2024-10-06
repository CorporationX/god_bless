package school.faang.catch_event;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        var eventIds = new HashMap<Integer, StreamEvent>();
        var eventTypes = new HashMap<String, List<StreamEvent>>();

        add(eventIds, eventTypes, new StreamEvent(1, "Birthday", "Happy Birthday"));
        add(eventIds, eventTypes, new StreamEvent(2, "Party", "Nice Party"));
        add(eventIds, eventTypes, new StreamEvent(3, "Party", "Nice Party"));
        add(eventIds, eventTypes, new StreamEvent(4, "Dancing", "Let's do it"));

        System.out.println("Find by id: " + findById(1, eventIds));
        System.out.println("Find by type: " + findByType("Party", eventTypes));

        removeById(2, eventIds, eventTypes);
        System.out.println("\nAfter remove:");
        print(eventIds, eventTypes);
    }

    private static void add(Map<Integer, StreamEvent> eventIds, Map<String, List<StreamEvent>> eventTypes,
                            StreamEvent streamEvent) {
        eventIds.put(streamEvent.id(), streamEvent);
        eventTypes.computeIfAbsent(streamEvent.eventType(), v -> new ArrayList<>()).add(streamEvent);
    }

    private static StreamEvent findById(int id, Map<Integer, StreamEvent> eventIds) throws NoSuchElementException {
        return Optional.of(eventIds.get(id)).orElseThrow(() -> new NoSuchElementException("Event does not exist"));
    }

    private static List<StreamEvent> findByType(String type, Map<String, List<StreamEvent>> typeEvents)
            throws NoSuchElementException {
        return Optional.of(typeEvents.get(type)).orElseThrow(() ->
                new NoSuchElementException("List of events does not exist"));
    }

    private static void removeById(int id, Map<Integer, StreamEvent> eventIds, Map<String, List<StreamEvent>> eventTypes) {
        eventIds.remove(id);
        eventTypes.entrySet().removeIf(entry -> entry.getValue().removeIf(event -> event.id() == id));
    }

    private static void print(Map<Integer, StreamEvent> eventIds, Map<String, List<StreamEvent>> eventTypes) {
        eventIds.forEach((k, v) -> System.out.println(k + " " + v));
        eventTypes.forEach((k, v) -> System.out.println(k + " " + v));
    }
}
