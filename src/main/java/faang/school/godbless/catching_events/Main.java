package faang.school.godbless.catching_events;

import java.util.*;

public class Main {
    private static final Map<Integer, StreamEvent> ID_EVENT = new HashMap<>();
    private static final Map<String, List<StreamEvent>> TYPE_EVENT = new HashMap<>();

    public static void main(String[] args) {
        addEvent(new StreamEvent(1, "type1", "data1"));
        addEvent(new StreamEvent(2, "type2", "data2"));
        addEvent(new StreamEvent(3, "type3", "data3"));
        System.out.println(getEventById(1));
        System.out.println(getEventsByType("type2"));
        removeEventById(2);
        printAllEvents();
    }

    public static void addEvent(StreamEvent event){
        ID_EVENT.put(event.getId(), event);
        TYPE_EVENT.computeIfAbsent(event.getEventType(), k -> new ArrayList<>()).add(event);
    }

    public static StreamEvent getEventById(int id) {
        return ID_EVENT.get(id);
    }

    public static List<StreamEvent> getEventsByType(String eventType) {
        return TYPE_EVENT.getOrDefault(eventType, Collections.emptyList());
    }

    public static void removeEventById(int id) {
        StreamEvent removedEvent = ID_EVENT.remove(id);
        if (removedEvent != null) {
            List<StreamEvent> eventList = TYPE_EVENT.get(removedEvent.getEventType());
            if (eventList != null) {
                eventList.removeIf(event -> event.getId() == id);
            }
        }
    }

    public static void printAllEvents() {
        for (Map.Entry<Integer, StreamEvent> entry : ID_EVENT.entrySet()) {
            StreamEvent event = entry.getValue();
            System.out.println("ID: " + event.getId() + ", Type: " + event.getEventType() + ", Data: " + event.getData());
        }
    }
}
