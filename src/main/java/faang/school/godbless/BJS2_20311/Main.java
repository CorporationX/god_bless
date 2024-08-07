package faang.school.godbless.BJS2_20311;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<Integer, StreamEvent> eventMap = new HashMap<>();
    private static Map<String, List<StreamEvent>> eventsByType = new HashMap<>();

    public static void main(String[] args) {
        var rockEvent = new StreamEvent(1, "rock", "Rock concert");
        var museumEvent = new StreamEvent(2, "museum", "Night of museums");
        var dancingEvent = new StreamEvent(3, "dancing", "Dance concert");
        var cinemaIvent = new StreamEvent(4, "cinema", "New film");
        var kannesEvent = new StreamEvent(5, "cinema", "Festivale in Cannes");

        addEventToMaps(rockEvent);
        addEventToMaps(museumEvent);
        addEventToMaps(dancingEvent);
        addEventToMaps(cinemaIvent);
        addEventToMaps(kannesEvent);
        System.out.println(getStreamEventById(4));
        System.out.println(getEventListByEventType("cinema"));
        removeStreamEvent(4);
        printAllStreanEvents();
    }

    private static void addEventToMaps(StreamEvent event) {
        eventMap.put(event.id(), event);
        eventsByType.computeIfAbsent(event.eventType(), (x) -> new ArrayList<>()).add(event);
    }

    private static StreamEvent getStreamEventById(int id) {
        return eventMap.get(id);
    }

    private static List<StreamEvent> getEventListByEventType(String eventType) {
        return eventsByType.get(eventType);
    }

    private static void removeStreamEvent(int id) {
        StreamEvent deletedEvent = eventMap.remove(id);
        eventsByType.get(deletedEvent.eventType()).remove(deletedEvent);
    }

    private static void printAllStreanEvents(){
        eventMap.forEach((id, event) -> System.out.println(event));
    }
}
