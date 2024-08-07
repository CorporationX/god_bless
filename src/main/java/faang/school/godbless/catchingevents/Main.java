package faang.school.godbless.catchingevents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<Integer, StreamEvent> eventsById = new HashMap<>();
    private static Map<String, List<StreamEvent>> eventsByType = new HashMap<>();

    public static void main(String[] args) {
        StreamEvent event1 = new StreamEvent(1, "Sports", "Football match");
        StreamEvent event2 = new StreamEvent(2, "Music", "Concert");
        StreamEvent event3 = new StreamEvent(3, "Sports", "Basketball game");
        StreamEvent event4 = new StreamEvent(4, "Music", "Opera");

        addStreamEvent(event1);
        addStreamEvent(event2);
        addStreamEvent(event3);
        addStreamEvent(event4);

        showAllStreamEvents();

        StreamEvent foundEvent = findStreamEventById(2);
        if (foundEvent != null) {
            System.out.println("\nНайдено событие: " + foundEvent);
        } else {
            System.out.println("\nСобытие с ID 2 не найдено.");
        }

        List<StreamEvent> sportsEvents = findStreamEventsByType("Sports");
        if (sportsEvents.isEmpty()) {
            System.out.println("\nСобытия с типом Sports не найдены.");
        } else {
            System.out.println("\nНайдены события типа Sports:");
            for (StreamEvent event : sportsEvents) {
                System.out.println(event);
            }
        }

        List<StreamEvent> comedyEvents = findStreamEventsByType("Comedy");
        if (comedyEvents.isEmpty()) {
            System.out.println("\nСобытия с типом Comedy не найдены.");
        }

        boolean removed = removeStreamEventById(3);
        if (removed) {
            System.out.println("\nСобытие с ID 3 удалено.\n");
        } else {
            System.out.println("\nСобытие с ID 3 не найдено.\n");
        }

        showAllStreamEvents();
    }

    public static void addStreamEvent(StreamEvent event) {
        eventsById.put(event.getId(), event);
        eventsByType.computeIfAbsent(event.getEventType(), k -> new ArrayList<>()).add(event);
    }

    public static StreamEvent findStreamEventById(int id) {
        return eventsById.get(id);
    }

    public static List<StreamEvent> findStreamEventsByType(String eventType) {
        return eventsByType.getOrDefault(eventType, new ArrayList<>());
    }

    public static boolean removeStreamEventById(int id) {
        StreamEvent event = eventsById.remove(id);
        if (event != null) {
            eventsByType.get(event.getEventType()).remove(event);
            return true;
        }
        return false;
    }

    public static void showAllStreamEvents() {
        if (eventsById.isEmpty()) {
            System.out.println("Нет событий в потоке.");
        } else {
            System.out.println("Все события потока:");
            for (Map.Entry<Integer, StreamEvent> entry : eventsById.entrySet()) {
                System.out.println(entry.getValue());
            }
        }
    }
}
