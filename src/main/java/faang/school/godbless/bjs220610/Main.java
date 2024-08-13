package faang.school.godbless.bjs220610;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, StreamEvent> eventsById = new HashMap<>();
        Map<String, List<StreamEvent>> eventsByType = new HashMap<>();

        StreamEventManager.addStreamEvent(eventsById, eventsByType, 1, "INFO", "User logged in");
        StreamEventManager.addStreamEvent(eventsById, eventsByType, 2, "ERROR", "Database connection failed");
        StreamEventManager.addStreamEvent(eventsById, eventsByType, 3, "WARNING", "Low disk space");
        StreamEventManager.addStreamEvent(eventsById, eventsByType, 4, "INFO", "User updated profile");
        StreamEventManager.addStreamEvent(eventsById, eventsByType, 5, "DEBUG", "Debugging application startup");

        System.out.println(StreamEventManager.findById(eventsById,3));
        System.out.println(StreamEventManager.findByType(eventsByType, "INFO"));
        StreamEventManager.deleteEvent(eventsById, eventsByType, 2);
        StreamEventManager.printEvents(eventsById);
    }
}
