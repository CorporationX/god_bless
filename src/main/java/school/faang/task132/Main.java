package school.faang.task132;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final HashMap<Integer, StreamEvent> eventById = new HashMap<>();
    private static final HashMap<String, List<StreamEvent>> eventsByEventType = new HashMap<>();

    public void addEvent(StreamEvent streamEvent) {
        eventById.put(streamEvent.getId(), streamEvent);
        eventsByEventType.computeIfAbsent(streamEvent.getEventType(), K -> new ArrayList<>()).add(streamEvent);
    }

    public StreamEvent findEventById(int id) {
        return eventById.get(id);
    }

    public List<StreamEvent> findEventListByEventType(String event) {
        return eventsByEventType.get(event);
    }

    public void removeEventById(int id) {
        String eventType = eventById.get(id).getEventType();
        eventsByEventType.get(eventType).removeIf(p -> (p.getId() == id));
        eventById.remove(id);
    }

    public void printAllEvents() {
        for (Map.Entry<String, List<StreamEvent>> entry : eventsByEventType.entrySet()) {
            for (StreamEvent event : entry.getValue()) {
                System.out.println(event);
            }
        }
    }

    public void addListOfEvents(List<StreamEvent> events) {
        for (StreamEvent event : events) {
            addEvent(event);
        }
    }

    public void printAllEventsFromList(List<StreamEvent> events) {
        for (StreamEvent event : events) {
            System.out.println(event);
        }
    }

    public static void main(String[] args) {
        StreamEvent streamEvent1 = new StreamEvent(1, "USER LOGIN", "Some Information");
        StreamEvent streamEvent2 = new StreamEvent(2, "USER LOGOUT", "Some Information");
        StreamEvent streamEvent3 = new StreamEvent(3, "USER UPDATE", "Some Information");
        StreamEvent streamEvent4 = new StreamEvent(4, "USER LOGIN", "Some Information");
        StreamEvent streamEvent5 = new StreamEvent(5, "USER LOGOUT", "Some Information");
        StreamEvent streamEvent6 = new StreamEvent(6, "USER UPDATE", "Some Information");
        StreamEvent streamEvent7 = new StreamEvent(7, "USER LOGIN", "Some Information");
        List<StreamEvent> listWithEvents = List.of(streamEvent1, streamEvent2, streamEvent3, streamEvent4, streamEvent5, streamEvent6, streamEvent7);

        Main main = new Main();
        main.addListOfEvents(listWithEvents);
        main.printAllEvents();
        System.out.println();

        System.out.println(main.findEventById(4));
        System.out.println();

        listWithEvents = main.findEventListByEventType("USER LOGIN");
        main.printAllEventsFromList(listWithEvents);
        System.out.println();

        main.removeEventById(4);
        main.printAllEvents();
    }
}
