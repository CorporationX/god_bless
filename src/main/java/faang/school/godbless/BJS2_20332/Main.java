package faang.school.godbless.BJS2_20332;

import java.util.*;

public class Main {
    private static Map<Integer, StreamEvent> events = new HashMap<>();
    private static Map<String, List<StreamEvent>> typesEvents = new HashMap<>();

    public static void main(String[] args) {
        addEvent(new StreamEvent(1, "auth", "login"));
        addEvent(new StreamEvent(2, "sendEmail", "asdf@asdf.ru"));
        addEvent(new StreamEvent(3, "auth", "logout"));
        addEvent(new StreamEvent(4, "auth", "login"));
        addEvent(new StreamEvent(5, "sendEmail", "fasa@fasd.ru"));
        addEvent(new StreamEvent(6, "db", "deleteFromDB"));
        addEvent(new StreamEvent(7, "auth", "login"));
        addEvent(new StreamEvent(8, "updates", "install"));
        addEvent(new StreamEvent(9, "db", "updateDb"));
        addEvent(new StreamEvent(10, "db", "addToDb"));
        addEvent(new StreamEvent(11, "updates", "rollback"));

        Optional<StreamEvent> optionalEvent = Optional.ofNullable(findEventById(10));
        if (optionalEvent.isPresent()) {
            System.out.println(optionalEvent.get().getId() + " " + optionalEvent.get().getEventType()
                    + " " + optionalEvent.get().getData());
        } else {
            System.out.println("No event found");
        }
        System.out.println("-------------");
        printAllEvents();
        System.out.println("-------------");

        Optional<List<StreamEvent>> optionalListEvent = Optional.ofNullable(findEventsByType("db"));
        if (optionalListEvent.isPresent()) {
            List<StreamEvent> eventList = optionalListEvent.get();
            eventList.forEach(eventType -> System.out.println(eventType.getId() + " " + eventType.getData()));
        } else {
            System.out.println("No such even type found");
        }
        System.out.println("-------------");
        removeEvent(66);
        printAllEvents();
    }

    public static void addEvent(StreamEvent event) {
        events.put(event.getId(), event);
        System.out.println("evenid " + event.getId());
        if (!typesEvents.containsKey(event.getEventType())) {
            typesEvents.put(event.getEventType(), new ArrayList<>() {{
                add(event);
            }});
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
        Optional<StreamEvent> optionalEvent = Optional.ofNullable(events.get(id));
        if (optionalEvent.isPresent()) {
            StreamEvent event = optionalEvent.get();
            events.remove(id);
            List<StreamEvent> list = typesEvents.get(event.getEventType());
            list.remove(event);
        } else {
            System.out.println("No such event found for remove");
        }
    }

    public static void printAllEvents() {
        for (var entry : typesEvents.entrySet()) {
            System.out.println("Event type: " + entry.getKey());
            entry.getValue().forEach(event -> System.out.println(event.getId() + " " + event.getData()));
        }
    }
}
