package mod1sp12.catchingEvents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<Integer, StreamEvent> STREAM_EVENTS = new HashMap<>();
    private static final Map<String, List<StreamEvent>> LIST_OF_EVENT_WITH_TYPE = new HashMap<>();

    private static void addEvent(StreamEvent newEvent) {
        STREAM_EVENTS.put(newEvent.getId(), newEvent);
        LIST_OF_EVENT_WITH_TYPE.computeIfAbsent(newEvent.getEventType(), key -> new ArrayList<>()).add(newEvent);
    }

    private static StreamEvent searchStreamEventById(int id) {
        return STREAM_EVENTS.get(id);
    }

    private static List<StreamEvent> searchListStreamEventsByType(String eventType) {
        return LIST_OF_EVENT_WITH_TYPE.get(eventType);
    }

    private static void removeStreamEventById(int id) {
        if (STREAM_EVENTS.containsKey(id)) {
            StreamEvent event = STREAM_EVENTS.get(id);
            LIST_OF_EVENT_WITH_TYPE.get(event.getEventType()).remove(event);
            STREAM_EVENTS.remove(id);
        } else {
            throw new IllegalArgumentException("Event with id " + id + " not found");
        }
    }

    private static void printStreamEvents() {
        for (Map.Entry<Integer, StreamEvent> entry : STREAM_EVENTS.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static void printListStreamEvents() {
        for (Map.Entry<String, List<StreamEvent>> entry : LIST_OF_EVENT_WITH_TYPE.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        StreamEvent event1 = new StreamEvent("Работа", "Сбер");
        StreamEvent event2 = new StreamEvent("Игра", "God of War");
        StreamEvent event3 = new StreamEvent("Работа", "Т-Банк");

        addEvent(event1);
        printStreamEvents();
        printListStreamEvents();
        System.out.println();

        addEvent(event2);
        printStreamEvents();
        printListStreamEvents();
        System.out.println();

        addEvent(event3);
        printStreamEvents();
        printListStreamEvents();
        System.out.println();

        removeStreamEventById(1);
        printStreamEvents();
        printListStreamEvents();
        System.out.println();

        removeStreamEventById(2);
        printStreamEvents();
        printListStreamEvents();
        System.out.println();

        addEvent(event1);
        printStreamEvents();
        printListStreamEvents();
        System.out.println();
    }
}
