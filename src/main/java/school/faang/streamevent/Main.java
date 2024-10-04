package school.faang.streamevent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static Map<Integer, StreamEvent> events = new HashMap<>();
    public static Map<String, List<StreamEvent>> sortedEvents = new HashMap<>();

    public static void main(String[] args) {
        addEvent(new StreamEvent(1, "Eat", "19:00"));
        addEvent(new StreamEvent(2, "Sleep", "21:00"));
        addEvent(new StreamEvent(3, "Rave", "22:00"));
        addEvent(new StreamEvent(4, "Repeat", "23:00"));

        searchForEventById(3);
        printEvents();
        deleteEventById(1);
        printEvents();
    }

    public static void addEvent(StreamEvent event) {
        events.put(event.getId(), event);
        sortedEvents.computeIfAbsent(event.getEventType(), k -> new ArrayList<>()).add(event);
    }

    public static void searchForEventById(int id) {
        for (Map.Entry<Integer, StreamEvent> entry : events.entrySet()) {
            if (entry.getValue().getId() == id) {
                System.out.println(entry.getValue().getEventType());
            }
        }
    }

    public static void deleteEventById(int id) {
        events.remove(id);

        for (Map.Entry<String, List<StreamEvent>> entry : sortedEvents.entrySet()) {
            List<StreamEvent> eventList = entry.getValue();
            eventList.removeIf(event -> event.getId() == id);
        }
    }

    public static void printEvents() {
        for (Map.Entry<Integer, StreamEvent> entry : events.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}

