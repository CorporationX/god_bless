package faang.school.godbless.catchEvents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static Map<Integer, StreamEvent> events;
    static Map<String, List<StreamEvent>> eventsByType;

    public static void main(String[] args) {
        events = new HashMap<>();
        eventsByType = new HashMap<>();
        Main.addEvent(new StreamEvent(1, "warning", "Pay attention to ..!"));
        Main.addEvent(new StreamEvent(2, "warning", "Never mind"));
        Main.addEvent(new StreamEvent(3, "error", "BSD"));
        Main.showAllEvent();
        System.out.println("Search by id=1");
        System.out.println(Main.findById(1));
        System.out.println("List of warnings");
        for (StreamEvent events : Main.findByType("warning")) {
            System.out.println(events);
        }
        Main.remove(1);
        System.out.println("After delete id=1");
        Main.showAllEvent();
    }

    private static void showAllEvent() {
        for (Map.Entry<Integer, StreamEvent> event : events.entrySet()) {
            System.out.println(event);
        }
    }

    private static void remove(int id) {
        eventsByType.get(events.get(id).getEventType()).remove(events.get(id));
        events.remove(id);
    }

    private static List<StreamEvent> findByType(String type) {
        return eventsByType.get(type);
    }

    private static StreamEvent findById(int id) {
        return events.get(id);
    }

    private static void addEvent(StreamEvent streamEvent) {
        events.put(streamEvent.getId(), streamEvent);
        eventsByType.putIfAbsent(streamEvent.getEventType(), new ArrayList<>());
        eventsByType.get(streamEvent.getEventType()).add(streamEvent);
    }
}
