package bjs2_33210;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static Map<Integer, StreamEvent> events = new HashMap<>();
    public static Map<String, List<StreamEvent>> groupsOfEvents = new HashMap<>();

    public static void main(String[] args) {
        addEvent(1, "type1", "data1");
        addEvent(2, "type2", "data2");
        addEvent(3, "type1", "data3");
        addEvent(4, "type3", "data4");
        addEvent(5, "type3", "data5");

        printAllEvents();
        System.out.println("====================");
        System.out.println(findEventById(3));
        System.out.println("====================");
        System.out.println(findEventsByType("type3"));
        System.out.println("====================");
        deleteEventById(1);
        printAllEvents();
        System.out.println("====================");
        System.out.println(findEventsByType("type1"));
    }

    public static void addEvent(Integer id, String eventType, String data) {
        addEvent(new StreamEvent(id, eventType, data));
    }

    public static void addEvent(StreamEvent event) {
        events.put(event.getId(), event);
        groupsOfEvents
                .putIfAbsent(event.getEventType(), new ArrayList<>());
        groupsOfEvents.get(event.getEventType()).add(event);
    }

    public static StreamEvent findEventById(Integer id) {
        return events.get(id);
    }

    public static List<StreamEvent> findEventsByType(String eventType) {
        return groupsOfEvents.get(eventType);
    }

    public static void deleteEventById(int id) {
        StreamEvent event = events.get(id);
        if (event == null) {
            return;
        }
        String eventType = event.getEventType();

        List<StreamEvent> listEvents = groupsOfEvents.get(eventType);
        listEvents.remove(event);
        if (listEvents.isEmpty()) {
            groupsOfEvents.remove(eventType);
        }

        events.remove(id);
    }

    public static void printAllEvents() {
        for (var entry : events.entrySet()) {
            System.out.printf("Id: %d, type: %s, data: %s",
                    entry.getKey(),
                    entry.getValue().getEventType(),
                    entry.getValue().getData());
            System.out.println();
        }
    }
}
