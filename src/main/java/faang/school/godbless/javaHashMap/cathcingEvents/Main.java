package faang.school.godbless.javaHashMap.cathcingEvents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private Map<Integer, StreamEvent> eventsById;
    private Map<String, List<StreamEvent>> eventsByType;

    public Main() {
        eventsByType = new HashMap<>();
        eventsById = new HashMap<>();
    }

    public static void main(String[] args) {
        Main eventsManager = new Main();

        System.out.println("Stream events manager check");

        System.out.println("Events base state at start point:");
        eventsManager.printAllEventsInfo();


        System.out.println("\n\nAdding some new events:");
        eventsManager.addNewEvent(1, "click", "Clicked on homepage button");
        eventsManager.addNewEvent(2, "hover", "Hovered over product image");
        eventsManager.addNewEvent(3, "scroll", "Scrolled down the page");
        eventsManager.addNewEvent(4, "click", "Clicked on 'Add to Cart'");
        eventsManager.addNewEvent(5, "hover", "Hovered over navigation menu");

        System.out.println("Events base state at this point:");
        eventsManager.printAllEventsInfo();


        System.out.println("\n\nGetting event by id (3) :");
        System.out.println(eventsManager.getEventById(3));


        System.out.println("\n\nGetting events by type (hover) :");
        System.out.println(eventsManager.getStreamEventsByType("hover"));


        System.out.println("\n\nRemoving event by id (3) :");
        eventsManager.removeEvent(3);

        System.out.println("Events base state at this point");
        eventsManager.printAllEventsInfo();

        System.out.println("\n\nDone.");
    }

    public StreamEvent addNewEvent(int id, String eventType, String data) {
        StreamEvent newEvent = new StreamEvent(id, eventType, data);

        eventsById.put(id, newEvent);

        List<StreamEvent> eventList = eventsByType.computeIfAbsent(eventType, key -> new ArrayList<>());

        if(eventList.contains(newEvent)) {
            return newEvent;
        }

        eventList.add(newEvent);
        return newEvent;
    }

    public StreamEvent getEventById(int id) {
        return eventsById.get(id);
    }

    public List<StreamEvent> getStreamEventsByType(String eventType) {
        return eventsByType.get(eventType);
    }

    public void removeEvent(int id) {
        StreamEvent eventToBeRemoved = getEventById(id);

        if(eventToBeRemoved == null) {
            return;
        }

        eventsById.remove(eventToBeRemoved);
        eventsByType.get(eventToBeRemoved.getEventType()).remove(eventToBeRemoved);
    }

    public void printAllEventsInfo() {
        if(eventsById.isEmpty()) {
            System.out.println("Events base is empty.");
        }

        eventsById.entrySet().forEach(System.out::println);
    }
}
