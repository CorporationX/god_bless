package BJS2_20476;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");

    public static void main(String[] args) {
        Map<Integer, StreamEvent> eventsById = new HashMap<>();
        Map<String, List<StreamEvent>> eventsByType = new HashMap<>();

        StreamEvent.addEvent(eventsById, eventsByType, new StreamEvent("Cache", DATE_TIME_FORMATTER.format(LocalDateTime.now())));
        StreamEvent.addEvent(eventsById, eventsByType, new StreamEvent("Cache", DATE_TIME_FORMATTER.format(LocalDateTime.now())));
        StreamEvent.addEvent(eventsById, eventsByType, new StreamEvent("Log", DATE_TIME_FORMATTER.format(LocalDateTime.now())));
        StreamEvent.addEvent(eventsById, eventsByType, new StreamEvent("Log", DATE_TIME_FORMATTER.format(LocalDateTime.now())));
        StreamEvent.addEvent(eventsById, eventsByType, new StreamEvent("Payment Service", DATE_TIME_FORMATTER.format(LocalDateTime.now())));
        StreamEvent.addEvent(eventsById, eventsByType, new StreamEvent("Payment Service", DATE_TIME_FORMATTER.format(LocalDateTime.now())));

        StreamEvent.printEvents(eventsById);

        System.out.println(StreamEvent.getEventById(eventsById, 2));
        System.out.println(StreamEvent.getEventByType(eventsByType, "Cache"));
        StreamEvent.removeEventById(eventsById, eventsByType, 2);

        StreamEvent.printEvents(eventsById);
    }
}