package faang.school.godbless.BJS2_20410;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static Map<Integer, StreamEvent> eventsAndIdMap = new HashMap<>();
    private static Map<String, List<StreamEvent>> eventAndTypeMap = new HashMap<>();

    public static void main(String[] args) {
        StreamEvent event1 = new StreamEvent(1, "TypeA", "DataA");
        StreamEvent event2 = new StreamEvent(2, "TypeB", "DataB");
        printAllEvents();
        System.out.println();
        addEvent(event1);
        addEvent(event2);
        printAllEvents();
        System.out.println();
        deleteEvent(1);
        printAllEvents();
    }

    private static void addEvent(StreamEvent event) {
        if (event == null) {
            throw new NullPointerException("Event cant be null");
        }

        eventsAndIdMap.put(event.getId(), event);

        List<StreamEvent> streamEvents = eventAndTypeMap.getOrDefault(event.getEventType(), new ArrayList<>());
        streamEvents.add(event);
        eventAndTypeMap.put(event.getEventType(), streamEvents);
    }

    private static StreamEvent getEvent(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("Event id cant be negative");
        }

        if (eventsAndIdMap.containsKey(id)) {
            return eventsAndIdMap.get(id);
        } else {
            System.out.println("Event with id " + id + " not found");
            return null;
        }
    }

    private static List<StreamEvent> getEventsList(String eventType) {
        if (eventType.isEmpty()) {
            throw new IllegalArgumentException("Event type cant be empty");
        }

        if (eventAndTypeMap.containsKey(eventType)) {
            return eventAndTypeMap.get(eventType);
        } else {
            System.out.println("Event with type " + eventType + " not found");
            return null;
        }
    }

    private static void deleteEvent(int id) {

        StreamEvent removedEvent = eventsAndIdMap.remove(id);

        if (removedEvent != null) {

            List<StreamEvent> eventsList = eventAndTypeMap.get(removedEvent.getEventType());

            if (eventsList != null) {
                eventsList.remove(removedEvent);

                if (eventsList.isEmpty()) {
                    eventAndTypeMap.remove(removedEvent.getEventType());
                }
            }

        } else {
            System.out.println("No event found with ID: " + id);
        }
    }

    private static void printAllEvents() {
        if (!eventsAndIdMap.isEmpty()) {
            for (Map.Entry<Integer, StreamEvent> entry : eventsAndIdMap.entrySet()) {
                System.out.println("Id: " + entry.getKey() + ", Type: " + entry.getValue().getEventType() + ", data: " + entry.getValue().getData());
            }
        } else {
            System.out.println("No events found");
        }

    }

}
