package faang.school.godbless.stream_event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static Map<Integer, StreamEvent> mapEventID = new HashMap<>();
    private static Map<String, List<StreamEvent>> mapEventType = new HashMap<>();

    public static void main(String[] args) {

        addEvent(1, "type One", "data One");
        addEvent(2, "type Two", "data Two");
        addEvent(1, "type One", "data One");
        addEvent(3, "type Three", "data Three");
        addEvent(1, "type One", "data One");

        removeTheEvent(2);
        updateTheEvent(1, "type New", "data New");
        printAllEvents();
        System.out.println(searchEventById(3));
        System.out.println(searchEventsByType("type Two"));

    }

    public static void updateTheEvent(int oldID, String newEventType, String newData) {
        removeTheEvent(oldID);
        addEvent(oldID, newEventType, newData);
    }

    public static void removeTheEvent(int id) {
        StreamEvent streamEvent = mapEventID.remove(id);
        if (streamEvent != null) {
            List<StreamEvent> events = mapEventType.get(streamEvent.getEventType());
            if (events != null) {
                events.remove(streamEvent);
            }
        }
    }

    public static void addEvent(int id, String eventType, String data) {
        StreamEvent streamEvent = new StreamEvent(id, eventType, data);
        mapEventID.put(id, streamEvent);
        mapEventType.computeIfAbsent(eventType, k -> new ArrayList<>()).add(streamEvent);
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
