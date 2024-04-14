package faang.school.godbless.catchingEvents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<Integer, StreamEvent> eventsById = new HashMap<>();
    private static final Map<String, List<StreamEvent>> eventsByType = new HashMap<>();

    public static void main(String[] args) {
        addNewEvent(1, "Party", "New Year party");
        addNewEvent(2, "Family", "Dad's birthday");
        addNewEvent(3, "Friends", "John's wedding");
        addNewEvent(4, "Party", "Mike's pool party");
        System.out.println("-----Printing All Events from List----");
        System.out.println("Printing findEventsByType: " + findEventsByType("Party"));
        System.out.println("Printing findEventById: " + findEventById(1));
        removeEvent(1);
        System.out.println("-----Printing All Events----");
        printAllEvents();
        System.out.println("-----Printing All Events----");
        printEventsByType();
    }

    public static void addNewEvent(int id, String type, String data) {
        StreamEvent eventToAdd = new StreamEvent(id, type, data);
        eventsById.put(id, eventToAdd);
        if (eventsByType.containsKey(type)) {
            eventsByType.get(type).add(eventToAdd);
        } else {
            eventsByType.put(type, new ArrayList<>());
            eventsByType.get(type).add(eventToAdd);
        }
    }

    public static StreamEvent findEventById(int id) {
        return eventsById.get(id);
    }

    public static List<StreamEvent> findEventsByType(String type) {
        return eventsByType.get(type);
    }

    public static void removeEvent(int id) {
        StreamEvent eventToRemove = eventsById.remove(id);
        System.out.println("--------------" + eventToRemove);
        if (eventsByType.containsKey(eventToRemove.getEventType())) {
            List<StreamEvent> listOfEventsByType = eventsByType.get(eventToRemove.getEventType());
            listOfEventsByType.removeIf(event -> event.equals(eventToRemove));
        }
    }

    public static void printAllEvents() {
        eventsById.forEach((key, value) -> System.out.println("Id: " + value.getId() + ", Type: " + value.getEventType() + ", Data: " + value.getData()));
    }

    public static void printEventsByType() {
        eventsByType.forEach((key, value) -> value.forEach((event) -> System.out.println("Id: " + event.getId() + ", Type: " + event.getEventType() + ", Data: " + event.getData())));
    }

}
