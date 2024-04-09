package faang.school.godbless.stream_event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<Integer, StreamEvent> mapEventID = new HashMap<>();
    private static Map<String, List<StreamEvent>> mapEventType = new HashMap<>();

    public static void main(String[] args) {

        StreamEvent streamEvent1 = new StreamEvent(1, "type One", "data One");
        StreamEvent streamEvent2 = new StreamEvent(2, "type Two", "data Two");
        StreamEvent streamEvent3 = new StreamEvent(1, "type One", "data One");
        StreamEvent streamEvent4 = new StreamEvent(3, "type Three", "data Three");
        StreamEvent streamEvent5 = new StreamEvent(1, "type One", "data One");

        addEvent(streamEvent1);
        addEvent(streamEvent2);
        addEvent(streamEvent3);
        addEvent(streamEvent4);
        addEvent(streamEvent5);

        removeTheEvent(3);
        updateTheEvent(streamEvent1);
        printAllEvents();
        System.out.println(searchEventById(3));
        System.out.println(searchEventsByType("type Two"));
    }

    public static void updateTheEvent(StreamEvent streamEvent) {
        removeTheEvent(streamEvent.getId());
        addEvent(streamEvent);
    }

    public static void removeTheEvent(int id) {
        StreamEvent streamEvent = mapEventID.remove(id);
        if (streamEvent != null) {
            List<StreamEvent> events = mapEventType.get(streamEvent.getEventType());
            if (events != null) {
                events.removeIf(event -> event.getId() == id);
            }
        }
    }

    public static void addEvent(StreamEvent streamEvent) {
        mapEventID.put(streamEvent.getId(), streamEvent);
        mapEventType.computeIfAbsent(streamEvent.getEventType(), k -> new ArrayList<>()).add(streamEvent);
    }

    public static StreamEvent searchEventById(int id) {
        return mapEventID.get(id);
    }

    public static List<StreamEvent> searchEventsByType(String eventType) {
        return mapEventType.getOrDefault(eventType, new ArrayList<>());
    }

    public static void printAllEvents() {
        for (Map.Entry<Integer, StreamEvent> entry : mapEventID.entrySet()) {
            StreamEvent event = entry.getValue();
            System.out.println("ID: " + event.getId() + ". Type of events: " + event.getEventType() + ". Data: " + event.getData());
        }
    }
}
