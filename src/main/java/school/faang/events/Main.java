package school.faang.events;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@Getter
public class Main {
    public static Map<Integer, StreamEvent> eventMap = new HashMap<>();
    public static Map<String, List<StreamEvent>> eventsByType = new HashMap<>();

    public static void main(String[] args) {
        List<StreamEvent> events = List.of(
                new StreamEvent(1, "type1", "Event 1"),
                new StreamEvent(2, "type2", "Event 2"),
                new StreamEvent(3, "type1", "Event 3"),
                new StreamEvent(3, "type1", "Event 4")
        );

        for (StreamEvent event : events) {
            addEvent(event);
        }

        printEvents();
        printEventsByType();
        printAllEvents(eventMap);

        int id = 2;
        System.out.println("\nEvent with id " + id + ": " + getEventById(2));

        String type = "type2";
        System.out.println("\nEvent with type " + type + ": " + getEventListByType(type));

        System.out.println("\nRemoving events: remove one object from multiple");
        removeEvent(3);

        printEvents();
        printEventsByType();

        System.out.println("\nRemoving events: remove single object from the list, entry with this type removed");
        removeEvent(1);

        printEvents();
        printEventsByType();
    }

    public static void addEvent(StreamEvent event) {
        eventMap.put(event.getId(), event);
        eventsByType.computeIfAbsent(event.getEventType(), k -> new ArrayList<>()).add(event);
    }

    public static void removeEvent(Integer idToRemove) {
        StreamEvent eventRemoved = eventMap.remove(idToRemove);
        if (eventRemoved != null) {
            String eventType = eventRemoved.getEventType();
            eventsByType.get(eventType).removeIf(event -> event.getId() == idToRemove);
            if (eventsByType.get(eventType).isEmpty()) {
                eventsByType.remove(eventType);
            }
        }
    }

    public static StreamEvent getEventById(Integer idToFind) {
        return eventMap.get(idToFind);
    }

    public static List<StreamEvent> getEventListByType(String typeToFind) {
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

    public static void printEvents() {
        System.out.println("\nEvent Map:");
        for (Integer key : eventMap.keySet()) {
            System.out.printf("| %-15s | %-35s |\n", key, eventMap.get(key));
        }
    }

    public static void printEventsByType() {
        System.out.println("\nEvents Grouped by Type: ");
        for (String key : eventsByType.keySet()) {
            System.out.printf("| %-15s | %-150s |\n", key, eventsByType.get(key));
        }
    }
}
