package faang.school.godbless.bjs220610;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StreamEventManager {
    public static void addStreamEvent(
            Map<Integer, StreamEvent> eventsById, Map<String, List<StreamEvent>> eventsByType, int id, String type, String data
    ) {
        StreamEvent newEvent = new StreamEvent(id, type, data);
        eventsById.put(id, newEvent);
        if (eventsByType.containsKey(type)) {
            eventsByType.computeIfPresent(type, (typeKey, eventList) -> {
                eventList.add(newEvent);
                return eventList;
            });
        } else {
            eventsByType.computeIfAbsent(type, typeKey -> {
                List<StreamEvent> eventList = new ArrayList<>();
                eventList.add(newEvent);
                return eventList;
            });
        }
    }

    public static StreamEvent findById(Map<Integer, StreamEvent> eventsById, int id) {
        return eventsById.get(id);
    }

    public static List<StreamEvent> findByType(Map<String, List<StreamEvent>> eventsByType, String type) {
        return eventsByType.get(type);
    }

    public static void deleteEvent(Map<Integer, StreamEvent> eventsById, Map<String, List<StreamEvent>> eventsByType, int id) {
        String eventType = eventsById.get(id).getEventType();
        if (eventType != null && eventsByType.containsKey(eventType)) {
            eventsByType.computeIfPresent(eventType, (type, eventList) -> {
                eventList.removeIf(event -> event.getId() == id);
                return eventList;
            });
        }
        eventsById.remove(id);
    }

    public static void printEvents(Map<Integer, StreamEvent> eventsById) {
        for (Map.Entry<Integer, StreamEvent> event : eventsById.entrySet()) {
            System.out.printf("ID-%d %s: %s \n", event.getValue().getId(), event.getValue().getEventType(), event.getValue().getData());
        }
    }

}
