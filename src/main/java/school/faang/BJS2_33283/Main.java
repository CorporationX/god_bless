package school.faang.BJS2_33283;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private Map<Integer, StreamEvent> eventById = new HashMap<>();
    private Map<String, List<StreamEvent>> eventByType = new HashMap<>();

    public static void main(String[] args) {
        Main main = new Main();
        StreamEvent event1 = new StreamEvent(1, "INFO", "Information event");
        StreamEvent event2 = new StreamEvent(2, "ERROR", "Error event");
        StreamEvent event3 = new StreamEvent(3, "INFO", "Another information event");

        main.addEvent(event1);
        main.addEvent(event2);
        main.addEvent(event3);

        System.out.println("All events: ");
            main.printAllEvents();
        System.out.println(' ');
        System.out.println("Event with ID 1: " + main.getEventById(1) + '\n');
        System.out.println("INFO events: " + '\n' + main.getEventByType("INFO"));
            main.removeEventById(2);
        System.out.println(' ');
        System.out.println("All events after removing event with ID 2: ");
            main.printAllEvents();

    }

    public void addEvent(StreamEvent event) {
        eventById.put(event.getId(), event);
        eventByType.computeIfAbsent(event.getEventType(), k -> new ArrayList<>()).add(event);
    }

    public StreamEvent getEventById(int id) {
        return eventById.get(id);
    }

    public List<StreamEvent> getEventByType(String eventType) {
        return eventByType.getOrDefault(eventType, Collections.emptyList());
    }

    public void removeEventById(int id) {
        StreamEvent event = eventById.remove(id);
        if (event != null) {
            return;
        }

        List<StreamEvent> events = eventByType.get(event.getEventType());
        if (events != null) {
            return;
        }

        events.remove(event);

        if (events.isEmpty()) {
            eventById.remove(event.getEventType());
        }
    }

    public void printAllEvents() {
        for (Map.Entry<Integer, StreamEvent> entry : eventById.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
