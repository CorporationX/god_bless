package HashMap_events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<Integer, StreamEvent> eventsById = new HashMap<>();
    private static Map<String, List<StreamEvent>> eventsByType = new HashMap<>();

    public static void main(String[] args) {
        addStreamEvent(new StreamEvent(1, "workshop", "Java Collections explained"));
        addStreamEvent(new StreamEvent(2, "seminar", "Java Strings explained"));
        addStreamEvent(new StreamEvent(3, "masterclass", "Java HashMap explained"));

        System.out.println(getEventById(1));

        System.out.println(getEventsByType("workshop"));

        removeEvent(new StreamEvent(1, "workshop", "Java Collections explained"));

        for (Map.Entry<Integer, StreamEvent> entry : eventsById.entrySet()) {
            System.out.println(
                    "ID: " + entry.getValue().getId() + "\n" +
                    "Event Type: " + entry.getValue().getEventType() + "\n" +
                    "Event Data: " + entry.getValue().getData()
            );
        }
    }

    public static void addStreamEvent(StreamEvent streamEvent) {
        eventsById.put(streamEvent.getId(), streamEvent);

        if (!eventsByType.containsKey(streamEvent.getEventType())) {
            eventsByType.put(streamEvent.getEventType(), new ArrayList<>());
        }

        eventsByType.get(streamEvent.getEventType()).add(streamEvent);
    }

    public static StreamEvent getEventById(int streamEventId) {
        return eventsById.get(streamEventId);
    }

    public static List<StreamEvent> getEventsByType(String eventType) {
        return eventsByType.get(eventType);
    }

    public static void removeEvent(StreamEvent streamEvent) {
        eventsById.remove(streamEvent.getId());
        eventsByType.remove(streamEvent.getEventType());
    }
}
