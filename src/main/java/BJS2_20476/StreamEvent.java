package BJS2_20476;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Data
public class StreamEvent {
    private int id;
    private String eventType;
    private String data;

    public StreamEvent(String eventType, String data) {
        this.id = new Random().nextInt(4);
        this.eventType = eventType;
        this.data = data;
    }

    public static void addEvent(List<StreamEvent> eventsList, Map<Integer, StreamEvent> eventsById, Map<String, List<StreamEvent>> eventsByType, StreamEvent event) {
        eventsList.add(event);
        eventsById.put(event.getId(), event);
        eventsByType.putIfAbsent(event.getEventType(), new ArrayList<>());
        eventsByType.get(event.getEventType()).add(event);
    }

    public static StreamEvent getEventById(Map<Integer, StreamEvent> eventsById, int id) {
        return eventsById.get(id);
    }

    public static List<StreamEvent> getEventByType(Map<String, List<StreamEvent>> eventsByType, String eventType) {
        return eventsByType.getOrDefault(eventType, new ArrayList<>());
    }

    public static void removeEventById(Map<Integer, StreamEvent> eventsById, Map<String, List<StreamEvent>> eventsByType, int id) {
        StreamEvent event = eventsById.remove(id);

        if (event != null) {
            List<StreamEvent> eventsList = eventsByType.get(event.getEventType());
            eventsList.remove(event);

            if (eventsList.isEmpty()) {
                eventsByType.remove(event.getEventType());
            }
        }
    }

    public static void printEvents(Map<Integer, StreamEvent> eventsById) {
        for (Map.Entry<Integer, StreamEvent> entry : eventsById.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
