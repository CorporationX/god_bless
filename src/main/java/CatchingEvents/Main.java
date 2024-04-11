package CatchingEvents;

import java.util.*;

public class Main {

    private static final Map<Integer, StreamEvent> EVENTS = new HashMap<>();
    private static final Map<String, List<StreamEvent>> EVENTS_TYPE = new HashMap<>();

    public static void main(String[] args) {
        addEvent(new StreamEvent(1, "Сходить в зал", "22.05.24"));
        addEvent(new StreamEvent(2, "Поесть", "22.05.24"));
        addEvent(new StreamEvent(4, "Программирование", "22.05.24"));
        addEvent(new StreamEvent(5, "Почитать", "22.05.24"));
        addEvent(new StreamEvent(12, "Поспать", "22.05.24"));
        addEvent(new StreamEvent(3, "Сходить погулять", "23.05.24"));

        removeById(2);
        printInfo(EVENTS, EVENTS_TYPE);

        System.out.println("\n" + searchById(3));
        System.out.println(searchByEventType("Программирование"));
    }

    private static void addEvent(StreamEvent streamEvent) {
        Integer key = streamEvent.getId();
        EVENTS.put(key, streamEvent);

        if (!EVENTS_TYPE.containsKey(streamEvent.getEventType())) {
            EVENTS_TYPE.put(streamEvent.getEventType(), new ArrayList<>());
        }
        EVENTS_TYPE.get(streamEvent.getEventType()).add(streamEvent);
    }

    private static StreamEvent searchById(int id) {
        if (!EVENTS.containsKey(id)) {
            return new StreamEvent();
        }
        return EVENTS.get(id);
    }

    private static List<StreamEvent> searchByEventType(String eventType) {
        if (!EVENTS_TYPE.containsKey(eventType)) {
            return new LinkedList<>();
        }
        return EVENTS_TYPE.get(eventType);
    }

    private static void removeById(int id) {
        String eventType = EVENTS.remove(id).getEventType();
        EVENTS_TYPE.remove(eventType);
    }

    private static void printInfo(Map<Integer, StreamEvent> events, Map<String, List<StreamEvent>> eventsType) {
        for (Map.Entry<Integer, StreamEvent> entry : events.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println("\n");
        for (Map.Entry<String, List<StreamEvent>> entry : eventsType.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
