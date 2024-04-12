package faang.school.godbless.catchingEvents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<Integer, StreamEvent> eventsById = new HashMap<>();
    private static final Map<String, List<StreamEvent>> eventsByType = new HashMap<>();
    private static final List<StreamEvent> events = new ArrayList<>();

    public static void main(String[] args) {
        addNewEvent(1, "Party", "New Year party");
        addNewEvent(2, "Family", "Dad's birthday");
        addNewEvent(3, "Friends", "John's wedding");
        addNewEvent(4, "Party", "Mike's pool party");
        System.out.println("-----Printing All Events from List----");
        printEventList();
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
        events.add(eventToAdd);
        eventsById.put(id, eventToAdd);
        eventsByType.put(type, events.stream().filter(streamEvents -> streamEvents.getEventType().equals(type)).toList());
    }

    public static StreamEvent findEventById(int id) {
        return eventsById.get(id);
    }

    public static List<StreamEvent> findEventsByType(String type) {
        return eventsByType.get(type);
    }

    //НЕ ПОНЯТНО, ПОЧЕМУ НЕ РАБОТАЕ???
    public static void removeEvent(int id) {
        StreamEvent eventToRemove = events.stream().filter(event -> event.getId() == id).findFirst().orElse(null);
        if (eventToRemove == null) {
            System.out.println("Event id not found!");
            return;
        }
        events.remove(eventToRemove);
        eventsById.remove(id);
        System.out.println("--------------" + eventToRemove);
//        eventsByType.get(eventToRemove.getEventType()).remove(eventToRemove);
//        List<StreamEvent> updatedList = eventsByType.get(eventToRemove.getEventType());
//        System.out.println("---------------------------"+updatedList);
//        updatedList.remove(eventToRemove);
//        System.out.println("---------------------------"+updatedList);
//        eventsByType.put(eventToRemove.getEventType(), updatedList);
//        eventsByType.put(eventToRemove.getEventType(), events);
//        eventsByType.values().forEach(eventList-> eventList.removeIf(event-> event.equals(eventToRemove)));


        for (List<StreamEvent> listOfEvents : eventsByType.values()) {
            for (StreamEvent event : listOfEvents){
                System.out.println("event:"+event);
                System.out.println("eventToRemove:"+eventToRemove);
                if(event.equals(eventToRemove)){
                    System.out.println("we are here");
                    System.out.println("event:"+event);
                    System.out.println("eventToRemove:"+eventToRemove);
                    try{
                        listOfEvents.remove(event);
                        System.out.println("break point");
                    }catch (Exception e){
                        System.out.println("Object not match to remove");
                    }
                    break;
                }
            }
        }
    }

    public static void printEventList() {
        events.forEach((value) -> System.out.println("Id: " + value.getId() + ", Type: " + value.getEventType() + ", Data: " + value.getData()));
    }

    public static void printAllEvents() {
        eventsById.forEach((key, value) -> System.out.println("Id: " + value.getId() + ", Type: " + value.getEventType() + ", Data: " + value.getData()));
    }

    //    public static void printEventsByType() {
//        eventsByType.forEach((key, value) -> System.out.println(value.toString()));
//    }
    public static void printEventsByType() {
        eventsByType.forEach((key, value) -> value.forEach((event) -> System.out.println("Id: " + event.getId() + ", Type: " + event.getEventType() + ", Data: " + event.getData())));
    }

}
