package faang.school.godbless.catch_event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static Map<Integer, StreamEvent> dataOfEvents = new HashMap<>();
    static Map<String, List<StreamEvent>> eventsByType = new HashMap<>();

    public static void main(String[] args) {
        addNewEvent(1, "payment", "data1");
        addNewEvent(2, "payment", "data2");
        addNewEvent(3, "send", "data1");

        printAllInfo();

        System.out.println("\n");
        System.out.println(searchEvents(1));

        System.out.println("\n");
        System.out.println(searchEvents("payment"));;

        System.out.println("\n");
        System.out.println(removeEvent(1));
        System.out.println("\n");

        printAllInfo();
    }

    public static void addNewEvent(int id, String eventType, String data) {
        StreamEvent event = new StreamEvent(id, eventType, data);
        dataOfEvents.put(event.getId(), event);
        eventsByType.computeIfAbsent(eventType, k -> new ArrayList<>()).add(event);
    }

    public static StreamEvent searchEvents(int id) {
        if (dataOfEvents.containsKey(id)) {
            return dataOfEvents.get(id);
        }
        return null;
    }

    public static List<StreamEvent> searchEvents(String eventType) {
        if (eventsByType.containsKey(eventType)) {
            eventsByType.get(eventType).forEach(System.out::println);
            return eventsByType.get(eventType);
        }
        return List.of();
    }

    public static boolean removeEvent(int id) {
        for (Map.Entry<String, List<StreamEvent>> entry : eventsByType.entrySet()) {
            entry.getValue().remove(dataOfEvents.get(id));
        }
        return dataOfEvents.remove(id) != null;
    }

    public static void printAllInfo() {
        for (Map.Entry<String, List<StreamEvent>> entry : eventsByType.entrySet()) {
            System.out.println(entry);
            for (StreamEvent event : entry.getValue()) {
                System.out.println("\t" + event);
            }
        }
    }
}
