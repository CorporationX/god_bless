package school.faang.catchingevents;

import school.faang.catchingevents.classes.StreamEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static Map<Integer, StreamEvent> eventMap = new HashMap<>();
    public static Map<String, List<StreamEvent>> eventTypeMap = new HashMap<>();

    public static void addEvent(StreamEvent streamEvent) {
        eventMap.put(streamEvent.getId(), streamEvent);
        eventTypeMap.computeIfAbsent(streamEvent.getEventType(), k -> new ArrayList<>()).add(streamEvent);
    }

    public static StreamEvent findEventById(Integer id) {
        return eventMap.get(id);
    }

    public static List<StreamEvent> findEventByType(String type) {
        return eventTypeMap.get(type);
    }

    public static void deleteEventById(Integer id) {
        StreamEvent streamEvent = eventMap.get(id);
        eventTypeMap.get(streamEvent.getEventType()).remove(streamEvent);
        eventMap.remove(id);
    }

    public static void displayAllEvents() {
        for(Map.Entry<Integer, StreamEvent> eventEntry : eventMap.entrySet()) {
            System.out.printf("Событие %d %s\n", eventEntry.getKey(), eventEntry.getValue());
        }
    }

    public static void main(String[] args) {
        addEvent(new StreamEvent("NEW", "Покормить кота"));
        addEvent(new StreamEvent("NEW", "Прочитать книгу"));
        addEvent(new StreamEvent("OLD", "Заправить машину"));
        addEvent(new StreamEvent("PROCESS", "Сходить в магазин"));

        deleteEventById(3);
        System.out.println(findEventById(0));
        System.out.println(findEventByType("NEW"));
        displayAllEvents();
    }
}