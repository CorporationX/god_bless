package faang.school.godbless.catching_events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static HashMap<Integer, StreamEvent> events = new HashMap<>();
    public static HashMap<String, List<StreamEvent>> groupedEvents = new HashMap<>();

    public static void main(String[] args) {
        addNewStreamEvent(new StreamEvent(1, "type1", "abc"));
        addNewStreamEvent(new StreamEvent(2, "type2", "def"));
        addNewStreamEvent(new StreamEvent(3, "type3", "ghi"));
        addNewStreamEvent(new StreamEvent(4, "type2", "jkl"));
        printEvents();
        printGroupedEvents();
        System.out.println(searchStreamEventByIdInEvents(3));
        System.out.println(searchListStreamEventsByTypeInSortedEvents("type2"));
        deleteStreamEventById(1);
        printEvents();
        printGroupedEvents();
    }

    public static void addNewStreamEvent(StreamEvent streamEvent) {
        events.put(streamEvent.getId(), streamEvent);
        groupedEvents.computeIfAbsent(streamEvent.getEventType(), e -> new ArrayList<>()).add(streamEvent);
    }

    public static StreamEvent searchStreamEventByIdInEvents(int id) {
        return events.get(id);
    }

    public static List<StreamEvent> searchListStreamEventsByTypeInSortedEvents(String eventType) {
        return groupedEvents.get(eventType);
    }

    public static void deleteStreamEventById(int id) {
        StreamEvent deletedStreamEvent = events.get(id);
        events.remove(id);
        groupedEvents.get(deletedStreamEvent.getEventType()).remove(deletedStreamEvent);
    }

    public static void printEvents() {
        for (var entry : events.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue().getEventType() + ", " + entry.getValue().getData());
        }
        System.out.println(" ");
    }

    public static void printGroupedEvents() {
        for (var entry : groupedEvents.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println(" ");
    }
}
