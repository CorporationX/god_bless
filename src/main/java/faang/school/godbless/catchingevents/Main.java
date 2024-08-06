package faang.school.godbless.catchingevents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<Integer, StreamEvent> eventsById = new HashMap<>();
    private static Map<String, List<StreamEvent>> eventsByType = new HashMap<>();

    public static void main(String[] args) {

    }

    public static void addStreamEvent(StreamEvent event) {
        eventsById.put(event.getId(), event);
        eventsByType.computeIfAbsent(event.getEventType(), k -> new ArrayList<>()).add(event);
        System.out.println("Событие добавлено: " + event);
    }

    public static void findStreamEventById(int id) {
        StreamEvent event = eventsById.get(id);
        if (event != null) {
            System.out.println("Найдено событие: " + event);
        } else {
            System.out.println("Событие с ID " + id + " не найдено.");
        }
    }

    public static void findStreamEventsByType(String eventType) {
        List<StreamEvent> events = eventsByType.get(eventType);
        if (events != null) {
            System.out.println("Найдены события:");
            for (StreamEvent event : events) {
                System.out.println(event);
            }
        } else {
            System.out.println("События с типом " + eventType + " не найдены.");
        }
    }

    public static void removeStreamEventById(int id) {
        StreamEvent event = eventsById.remove(id);
        if (event != null) {
            eventsByType.get(event.getEventType()).remove(event);
            System.out.println("Событие удалено: " + event);
        } else {
            System.out.println("Событие с ID " + id + " не найдено.");
        }
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
