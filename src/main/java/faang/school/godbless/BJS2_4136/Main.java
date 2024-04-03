package faang.school.godbless.BJS2_4136;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    private static final HashMap<Integer, StreamEvent> eventsById = new HashMap<>();
    private static final HashMap<String, List<StreamEvent>> eventsByType = new HashMap<>();

    public static void main(String[] args) {
        addEvent(new StreamEvent(1, "Тип 1", "Data 1"));
        addEvent(new StreamEvent(2, "Тип 2", "Data 2"));
        addEvent(new StreamEvent(3, "Тип 3", "Data 3"));
        addEvent(new StreamEvent(4, "Тип 2", "Data 3"));
        StreamEvent.printAllEvents(eventsById);

        System.out.println(StreamEvent.findEventById(2, eventsById));
        System.out.println(StreamEvent.findEventsByType("Тип 2", eventsByType));

        removeEventById(2);
        StreamEvent.printAllEvents(eventsById);
    }

    public static void addEvent(StreamEvent event) {
        eventsById.put(event.getId(), event);
        eventsByType.computeIfAbsent(event.getEventType(), k -> new ArrayList<>()).add(event);
    }

    public static void removeEventById(int id) {
        StreamEvent event = eventsById.remove(id);
        if (event != null) {
            eventsByType.computeIfPresent(event.getEventType(), (type, events) -> {
                events.removeIf(e -> e.getId() == id);
                return events;
            });
        }
    }
}
