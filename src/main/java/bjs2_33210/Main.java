package bjs2_33210;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static Map<Integer, StreamEvent> events = new HashMap<>();
    public static Map<String, List<StreamEvent>> groupsOfEvents = new HashMap<>();
    //key - event id, value - index in list
    public static Map<Integer, Integer> index = new HashMap<>();

    public static void addEvent(Integer id, String eventType, String data) {
        addEvent(new StreamEvent(id, eventType, data));
    }

    public static void addEvent(StreamEvent event) {
        events.put(event.getId(), event);
        if (groupsOfEvents.containsKey(event.getEventType())) {
            index.put(event.getId(), groupsOfEvents.get(event.getEventType()).size());
            groupsOfEvents.get(event.getEventType()).add(event);
        } else {
            groupsOfEvents.put(event.getEventType(), new ArrayList<>(List.of(event)));
            index.put(event.getId(), 0);
        }
    }

    public static StreamEvent findEventById(Integer id) {
        return events.get(id);
    }

    public static List<StreamEvent> findEventsByType(String eventType) {
        return groupsOfEvents.get(eventType);
    }

    public static void deleteEventById(int id) {
        groupsOfEvents
                .get(events.get(id).getEventType())
                .remove(index.get(id).intValue());
        events.remove(id);
    }

    public static void printAllEvents() {
        for (var entry : events.entrySet()) {
            System.out.printf("Id: %d, type: %s, data: %s",
                    entry.getKey(), entry.getValue().getEventType(), entry.getValue().getData());
            System.out.println();
        }
    }


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
        printAllEvents();
        System.out.println("====================");
        deleteEventById(1);
        printAllEvents();
        System.out.println("====================");
        System.out.println(findEventsByType("type1"));
    }
}
