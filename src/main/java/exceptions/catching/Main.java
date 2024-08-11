package exceptions.catching;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, StreamEvent> eventsMap = new HashMap<>();
        Map<String, List<StreamEvent>> eventsTypeLists = new HashMap<>();
        StreamEvent event1 = new StreamEvent(1, "Error", "smth");
        StreamEvent event2 = new StreamEvent(2, "Warning", "smth");
        StreamEvent event3 = new StreamEvent(3, "Error", "smth");
        addEvent(eventsMap, eventsTypeLists, event1);
        addEvent(eventsMap, eventsTypeLists, event2);
        addEvent(eventsMap, eventsTypeLists, event3);
        printStreamEvents(eventsMap);
        addEvent(eventsMap, eventsTypeLists, new StreamEvent(4, "Warning", "smth"));
        printStreamEvents(eventsMap);
        System.out.println(searchEventById(eventsMap, 1));
        System.out.println(searchEventById(eventsMap, 5));
        System.out.println();
        searchEventListByType(eventsTypeLists, "Error").forEach(System.out::println);
        var list = searchEventListByType(eventsTypeLists, "Success");
        if (list == null) {
            System.out.println("null");
        }
        removeEvent(eventsMap, eventsTypeLists, 2);
        printStreamEvents(eventsMap);
        removeEvent(eventsMap, eventsTypeLists, 49);
        printStreamEvents(eventsMap);
        printStreamEvents(eventsMap);

    }

    public static void addEvent(
            @NonNull Map<Integer, StreamEvent> eventsMap,
            @NonNull Map<String, List<StreamEvent>> eventsTypeLists,
            @NonNull StreamEvent event
    ) {
        if (eventsMap.containsKey(event.getId())) {
            System.out.println("\nEvent is already in stream");
        } else {
            eventsMap.put(event.getId(), event);
            eventsTypeLists.computeIfAbsent(event.getEventType(), v -> new ArrayList<>()).add(event);
            System.out.println("\nEvent is added in stream");
        }
    }

    public static StreamEvent searchEventById(@NonNull Map<Integer, StreamEvent> eventsMap, int id) {
        return eventsMap.get(id);
    }

    public static List<StreamEvent> searchEventListByType(
            @NonNull Map<String, List<StreamEvent>> eventsTypeLists,
            @NonNull String eventType
    ) {
        return eventsTypeLists.get(eventType);
    }

    public static void removeEvent(
            @NonNull Map<Integer, StreamEvent> eventsMap,
            @NonNull Map<String, List<StreamEvent>> eventsTypeLists,
            int id
    ) {
        if (!eventsMap.containsKey(id)) {
            System.out.println("\nEvent with this id not in the stream");
        } else {
            StreamEvent event = eventsMap.remove(id);
            List<StreamEvent> list = eventsTypeLists.get(event.getEventType());
            list.remove(event);
            if (list.isEmpty()) {
                eventsTypeLists.remove(event.getEventType());
            }
            System.out.println("\nRemove event from stream");
        }
    }

    public static void printStreamEvents(Map<Integer, StreamEvent> eventsMap) {
        System.out.println("\nEvents in stream:");
        eventsMap.forEach((k, v) -> System.out.println(v));
    }
}
