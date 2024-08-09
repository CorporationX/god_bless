package BJS2_20476;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");

    public static void main(String[] args) {
        final List<StreamEvent> eventsList = new ArrayList<>();
        Map<Integer, StreamEvent> eventsById = new HashMap<>();
        Map<String, List<StreamEvent>> eventsByType = new HashMap<>();

        addEvent(eventsList, eventsById, eventsByType, new StreamEvent("Cache", DATE_TIME_FORMATTER.format(LocalDateTime.now())));
        addEvent(eventsList, eventsById, eventsByType, new StreamEvent("Cache", DATE_TIME_FORMATTER.format(LocalDateTime.now())));
        addEvent(eventsList, eventsById, eventsByType, new StreamEvent("Log", DATE_TIME_FORMATTER.format(LocalDateTime.now())));
        addEvent(eventsList, eventsById, eventsByType, new StreamEvent("Log", DATE_TIME_FORMATTER.format(LocalDateTime.now())));
        addEvent(eventsList, eventsById, eventsByType, new StreamEvent("Payment Service", DATE_TIME_FORMATTER.format(LocalDateTime.now())));
        addEvent(eventsList, eventsById, eventsByType, new StreamEvent("Payment Service", DATE_TIME_FORMATTER.format(LocalDateTime.now())));

        printEvents(eventsById);

        System.out.println(getEventById(eventsById, 2));
        System.out.println(getEventByType(eventsByType, "Cache"));
        removeEventById(eventsById, eventsByType, 2);

        printEvents(eventsById);
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