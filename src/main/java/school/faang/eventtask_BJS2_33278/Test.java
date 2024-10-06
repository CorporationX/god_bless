package school.faang.eventtask_BJS2_33278;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Test {
    private static final HashMap<Integer, StreamEvent> eventsMap = new HashMap<>();
    private static final HashMap<String, List<StreamEvent>> eventsByTypeMap = new HashMap<>();

    public static void main(String[] args) {
        addEvent(new StreamEvent(100, "set", "01.10.2024"));
        addEvent(new StreamEvent(110, "get", "04.10.2024"));
        addEvent(new StreamEvent(200, "push", "05.10.2024"));
        addEvent(new StreamEvent(220, "poll", "31.09.2024"));
        addEvent(new StreamEvent(130, "set", "02.10.2024"));
        addEvent(new StreamEvent(140, "set", "03.10.2024"));
        printEvents();

        System.out.println();
        int id = 140;
        removeEventById(id);
        System.out.println("Remove by id=140");
        printEvents();

        System.out.println();
        Optional<StreamEvent> eventOtherOptional = findEventById(id);
        if (eventOtherOptional.isEmpty()) {
            System.out.println("Not found by id=140");
        } else {
            System.out.println("Find by id=140");
            System.out.println(eventOtherOptional.get());
        }

        System.out.println();
        Optional<StreamEvent> eventOptional = findEventById(110);
        eventOptional.ifPresent(event -> {
            System.out.println("Found by id=110");
            System.out.println(event);
        });

        System.out.println();
        Optional<List<StreamEvent>> eventListOptional = findEventListByEventType("set");
        eventListOptional.ifPresent(list -> {
            System.out.println("Found by EventType = set");
            printEventList(list);
        });

        System.out.println();
        Optional<List<StreamEvent>> eventListOtherOptional = findEventListByEventType("SET");
        if (eventListOtherOptional.isEmpty()) {
            System.out.println("Not found by EventType = SET");
        } else {
            System.out.println("Found by EventType = SET");
            System.out.println(eventListOtherOptional.get());
        }
    }

    private static void addEvent(StreamEvent newEvent) {
        eventsMap.put(newEvent.getId(), newEvent);
        List<StreamEvent> eventList = eventsByTypeMap.computeIfAbsent(newEvent.getEventType(), k -> new ArrayList<>());
        if (!eventList.contains(newEvent)) {
            eventList.add(newEvent);
        }
    }

    private static Optional<StreamEvent> findEventById(int id) {
        StreamEvent streamEvent = eventsMap.get(id);
        if (streamEvent != null) {
            return Optional.of(streamEvent);
        }
        return Optional.empty();
    }

    private static Optional<List<StreamEvent>> findEventListByEventType(String eventType) {
        List<StreamEvent> eventList = eventsByTypeMap.get(eventType);
        if (eventList != null) {
            return Optional.of(eventList);
        }
        return Optional.empty();
    }

    private static void removeEventById(int id) {
        StreamEvent streamEvent = eventsMap.get(id);
        if (streamEvent == null) {
            return;
        }

        List<StreamEvent> eventList = eventsByTypeMap.get(streamEvent.getEventType());
        if (eventList == null) {
            return;
        }

        eventList.remove(streamEvent);

        eventsMap.remove(id);
    }

    private static void printEvents() {
        for (Map.Entry<String, List<StreamEvent>> stringListEntry : eventsByTypeMap.entrySet()) {
            System.out.printf("%s:%n", stringListEntry.getKey());
            printEventList(stringListEntry.getValue());
        }
    }

    private static void printEventList(List<StreamEvent> list) {
        for (StreamEvent streamEvent : list) {
            System.out.println(streamEvent);
        }
    }
}
