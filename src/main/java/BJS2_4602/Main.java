package BJS2_4602;

import java.util.*;

public class Main {
    private static final Map<Integer, StreamEvent> EVENT_MAP = new HashMap<>();
    private static final Map<String, List<StreamEvent>> EVENTS = new HashMap<>();

    public static void main(String[] args) {
        addNewEvent(EVENT_MAP, EVENTS, new StreamEvent(1, "Add", "Message"));
        addNewEvent(EVENT_MAP, EVENTS, new StreamEvent(2, "Delete", "Delete Message"));
        addNewEvent(EVENT_MAP, EVENTS, new StreamEvent(3, "Update", "Update Message"));
        addNewEvent(EVENT_MAP, EVENTS, new StreamEvent(3, "Add", "Message2"));
        addNewEvent(EVENT_MAP, EVENTS, new StreamEvent(4, "Update", "Update Message2"));
        addNewEvent(EVENT_MAP, EVENTS, new StreamEvent(5, "Add", "Message3"));
        deleteEvent(EVENT_MAP, EVENTS, 3);
        System.out.println(streamFind(EVENT_MAP, 4));
        System.out.println(eventListFind(EVENTS, "Update"));
        infoEvent(EVENT_MAP);
    }


    private static void addNewEvent(Map<Integer, StreamEvent> eventMap, Map<String, List<StreamEvent>> events,
                                    StreamEvent streamEvent) {
        eventMap.put(streamEvent.getId(), streamEvent);
        events.computeIfAbsent(streamEvent.getEventType(), k -> new ArrayList<>()).add(streamEvent);
    }

    private static StreamEvent streamFind(Map<Integer, StreamEvent> eventMap, Integer idEvent) {
        return eventMap.get(idEvent);
    }

    private static List<StreamEvent> eventListFind(Map<String, List<StreamEvent>> events, String typeEvent) {
        return events.get(typeEvent);
    }

    private static void deleteEvent(Map<Integer, StreamEvent> eventMap, Map<String, List<StreamEvent>> events,
                                    int idEvent) {
        StreamEvent streamEvent = eventMap.get(idEvent);
        eventMap.remove(idEvent);
        Objects.requireNonNull(events.computeIfPresent(streamEvent.getEventType(), (k, v) -> v)).remove(streamEvent);
    }

    private static void infoEvent(Map<Integer, StreamEvent> events) {
        for (Map.Entry<Integer, StreamEvent> event : events.entrySet()) {
            System.out.println("ID:" + event.getKey() + " Type Event:" + event.getValue().getEventType() +
                    " Data Event:" + event.getValue().getData());
        }
    }
}
