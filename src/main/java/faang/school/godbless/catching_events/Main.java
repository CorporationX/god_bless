package faang.school.godbless.catching_events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<Integer, StreamEvent> idToEventMap = new HashMap<>();
    private static final Map<String, List<StreamEvent>> eventTypeToEventsMap = new HashMap<>();

    public static void main(String[] args) {
        StreamEvent streamEvent = new StreamEvent(1, "Вход", "data1");
        StreamEvent event2 = new StreamEvent(1, "Вход", "data2");
        StreamEvent event3 = new StreamEvent(3, "Выход", "data3");
        StreamEvent event4 = new StreamEvent(4, "выход", "data4");
        StreamEvent event1 = new StreamEvent(5, "Удаление", "data1");

        addEvent(streamEvent);
        addEvent(event2);
        addEvent(event4);
        addEvent(event3);
        addEvent(event1);

        print();
        findEventById(3);
        findEventByEventType(streamEvent.getEventType());
        removeEventById(1);

    }

    public static void addEvent(StreamEvent event) {
        idToEventMap.put(event.getId(), event);

        List<StreamEvent> events = eventTypeToEventsMap.computeIfAbsent(event.getEventType(), k -> new ArrayList<>());

        boolean eventExists = events.stream().anyMatch(e -> e.getId() == event.getId());
        if (!eventExists) {
            events.add(event);
        }
    }

    public static void removeEventById(int eventId) {
        StreamEvent streamEvent = idToEventMap.get(eventId);
        if (streamEvent != null) {
            idToEventMap.remove(eventId);

            List<StreamEvent> events = eventTypeToEventsMap.get(streamEvent.getEventType());
            if (events != null) {
                events.removeIf(event -> event.getId() == eventId);
            }
        }
    }

    public static void findEventById(int eventId) {
        if (idToEventMap.containsKey(eventId)) {
            System.out.println(idToEventMap.get(eventId));
        } else {
            System.out.println("Событые не найдено");
        }
    }

    public static void findEventByEventType(String eventType) {
        if (eventTypeToEventsMap.containsKey(eventType)) {
            System.out.println(eventTypeToEventsMap.get(eventType));
        } else {
            System.out.println("Событые не найдено");
        }
    }

    public static void print() {
        System.out.println(idToEventMap);
        System.out.println("------------------");
        System.out.println(eventTypeToEventsMap);
        System.out.println("-----------------------------------------------------");
    }
}
