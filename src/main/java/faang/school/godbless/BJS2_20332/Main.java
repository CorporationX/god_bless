package faang.school.godbless.BJS2_20332;

import java.util.*;

public class Main {
    private static Map<Integer, StreamEvent> events = new HashMap<>();
    private static Map<String, List<StreamEvent>> typesEvents = new HashMap<>();

    public static void main(String[] args) {
        addEvent(new StreamEvent("auth", "login"));
        addEvent(new StreamEvent("sendEmail", "asdf@asdf.ru"));
        addEvent(new StreamEvent("auth", "logout"));
        addEvent(new StreamEvent("auth", "login"));
        addEvent(new StreamEvent("sendEmail", "fasa@fasd.ru"));
        addEvent(new StreamEvent("db", "deleteFromDB"));
        addEvent(new StreamEvent("auth", "login"));
        addEvent(new StreamEvent("updates", "install"));
        addEvent(new StreamEvent("db", "updateDb"));
        addEvent(new StreamEvent("db", "addToDb"));
        addEvent(new StreamEvent("updates", "rollback"));

        StreamEvent event = findEventById(5);
        System.out.println(event.getId() + " " + event.getEventType() + " " + event.getData());
        System.out.println("-------------");
        printAllEvents();
        System.out.println("-------------");
        List<StreamEvent> listEvents = findEventsByType("db");
        listEvents.forEach(eventType -> System.out.println(eventType.getId() + " " + eventType.getData()));
        System.out.println("-------------");
        removeEvent(6);
        printAllEvents();
    }

    public static void addEvent(StreamEvent event) {
        event.setId(events.size() + 1);
        events.put(event.getId(), event);
        if (!typesEvents.containsKey(event.getEventType())) {
            typesEvents.put(event.getEventType(), new ArrayList<>(List.of(event)));
        } else {
            typesEvents.get(event.getEventType()).add(event);
        }
    }

    public static StreamEvent findEventById(int id) {
        return events.get(id);
    }

    public static List<StreamEvent> findEventsByType(String type) {
        return typesEvents.get(type);
    }

    public static void removeEvent(int id) {
        StreamEvent event = events.get(id);
        events.remove(id);
        List<StreamEvent> list = typesEvents.get(event.getEventType());
        list.remove(event);
    }

    public static void printAllEvents() {
        for (var entry : typesEvents.entrySet()) {
            System.out.println("Event type: " + entry.getKey());
            entry.getValue().forEach(event -> System.out.println(event.getId() + " " + event.getData()));
        }
    }
}
