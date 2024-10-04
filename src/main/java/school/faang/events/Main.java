package school.faang.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

    public static void main(String[] args) {
        Map<Integer, StreamEvent> eventMap = new HashMap<>();
        Map<String, List<StreamEvent>> eventsByType = new HashMap<>();

//        Add multiple events to Maps
        List<StreamEvent> events = List.of(
                new StreamEvent(1, "type1", "Event 1"),
                new StreamEvent(2, "type2", "Event 2"),
                new StreamEvent(3, "type1", "Event 3"),
                new StreamEvent(3, "type1", "Event 4")
        );

//        Add objects to both Maps
        for (StreamEvent event : events) {
            addEvent(eventMap, eventsByType, event);
        }

//        Print initial Maps
        printEvents(eventMap);
        printEventsByType(eventsByType);
        printAllEvents(eventMap);

//        Find event by id
        int id = 2;
        System.out.println("\nEvent with id " + id + ": " + getEventById(eventMap,2));

        String type = "type2";
        System.out.println("\nEvent with type " + type + ": " + getEventListByType(eventsByType,type));

        System.out.println("\nRemoving events: remove one object from multiple");
        removeEvent(eventMap,eventsByType,3);

//        Print lists after removal
        printEvents(eventMap);
        printEventsByType(eventsByType);

        System.out.println("\nRemoving events: remove single object from the list, entry with this type removed");
        removeEvent(eventMap,eventsByType,1);

//        Print lists after removal
        printEvents(eventMap);
        printEventsByType(eventsByType);

    }

    public static void addEvent(Map<Integer, StreamEvent> eventMap, Map<String, List<StreamEvent>> eventsByType, StreamEvent event) {
        eventMap.put(event.getId(), event);
        eventsByType.computeIfAbsent(event.getEventType(), k -> new ArrayList<>()).add(event);
    }

    public static void removeEvent(Map<Integer, StreamEvent> eventMap, Map<String, List<StreamEvent>> eventsByType, Integer idToRemove) {
        eventMap.remove(idToRemove);

        Iterator<Entry<String, List<StreamEvent>>> iterator = eventsByType.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry<String, List<StreamEvent>> entry = iterator.next();
            List<StreamEvent> eventList = entry.getValue();
            eventList.removeIf(event -> event.getId() == idToRemove);
            if (eventList.isEmpty()) {
                iterator.remove();
            }
        }
    }

    public static StreamEvent getEventById(Map<Integer, StreamEvent> eventMap, Integer idToFind) {
        return eventMap.get(idToFind);
    }

    public static List<StreamEvent> getEventListByType(Map<String, List<StreamEvent>> eventsByType, String typeToFind) {
        return eventsByType.get(typeToFind);
    }

    public static void printAllEvents(Map<Integer, StreamEvent> eventMap) {
        System.out.println("\nALL Events:");
        System.out.printf("| %-15s | %-15s | %-15s |%n", "Id", "Type", "Event");
        for (Entry entry : eventMap.entrySet()) {
            StreamEvent event = (StreamEvent) entry.getValue();
            System.out.printf("| %-15s | %-15s | %-15s |\n", event.getId(), event.getEventType(), event.getData());
        }
    }

    public static void printEvents(Map<Integer, StreamEvent> eventMap) {
        System.out.println("\nEvent Map:");
        for (Integer key : eventMap.keySet()) {
            System.out.printf("| %-15s | %-35s |\n", key, eventMap.get(key));
        }
    }

    public static void printEventsByType(Map<String, List<StreamEvent>> eventsByType) {
        System.out.println("\nEvents Grouped by Type: ");
        for (String key : eventsByType.keySet()) {
            System.out.printf("| %-15s | %-150s |\n", key, eventsByType.get(key));
        }
    }

}
