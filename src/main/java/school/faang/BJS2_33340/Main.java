package school.faang.BJS2_33340;

import java.util.*;

public class Main {

    private static Map<Integer, StreamEvent> eventById = new HashMap<>();
    private static Map<String, List<StreamEvent>> eventsByType = new HashMap<>();
    final static int EVENT_COUNT = 20;

    public static void main(String[] args) {
        Random random = new Random();

        System.out.println(findEventById(random.nextInt(EVENT_COUNT)));
        System.out.println(findEventsListByType(StreamEvent.eventTypes[random.nextInt(StreamEvent.EVENT_TYPES_COUNT)]));

        for (int i = 0; i < EVENT_COUNT; i++) {
            addNewEvent(StreamEvent.generateEvent());
        }
        printEventsById();
        printEventsByType();

        System.out.println("\n" + findEventById(random.nextInt(EVENT_COUNT)));
        System.out.println("\n" + findEventsListByType(StreamEvent.eventTypes[random.nextInt(StreamEvent.EVENT_TYPES_COUNT)]));

        deleteEventById(random.nextInt(EVENT_COUNT));
        deleteEventById(random.nextInt(EVENT_COUNT));
        deleteEventById(random.nextInt(EVENT_COUNT));

        printEventsById();
        printEventsByType();
    }

    public static boolean addNewEvent(StreamEvent event){
        if (event == null) {
            return false;
        }
        eventById.put(event.getId(), event);
        eventsByType.putIfAbsent(event.getEventType(), new LinkedList<StreamEvent>());
        eventsByType.get(event.getEventType()).add(event);
        return true;
    }

    public static StreamEvent getEventById(int id){
        return eventById.get(id);
    }

    public static List<StreamEvent> getEventsByType(String type){
        if (type == null) {
            return new LinkedList<StreamEvent>();
        }
        return eventsByType.get(type);
    }

    public static StreamEvent findEventById(int id){
        return eventById.get(id);
    }

    public static List<StreamEvent> findEventsListByType(String type){
        return eventsByType.get(type);
    }

    public static boolean deleteEventById(int id) {
        StreamEvent event = eventById.get(id);
        if (event == null) {
            return false;
        }
        eventsByType.get(event.getEventType()).remove(event);
        eventById.remove(id);
        return true;
    }

    public static void printEventsById() {
        System.out.println("========================EventsByID start========================");
        for (Map.Entry<Integer, StreamEvent> entry : eventById.entrySet()) {
            System.out.println(entry);
        }
    }

    public static void printEventsByType(){
        System.out.println("=========================EventsByType start==========================");
        for (Map.Entry<String, List<StreamEvent>> entry : eventsByType.entrySet()) {
            System.out.println("List of events with EventType = " + entry.getKey());
            for (StreamEvent event : entry.getValue()) {
                System.out.println(event);
            }
            System.out.println("-------------------------------------------------------------");
        }
    }
}
