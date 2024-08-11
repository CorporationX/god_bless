package faang.school.godbless.BJS220463;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<Integer, StreamEvent> idToEventMap = new HashMap<>();
    private static Map<String, List<StreamEvent>> typeToEventMap = new HashMap<>();

    public static void addStreamEvent(StreamEvent event) {
        idToEventMap.put(event.getId(), event);
        typeToEventMap.computeIfAbsent(event.getEventType(), key -> new ArrayList<>()).add(event);
    }

    public static StreamEvent getStreamEventById(int id) {
        return idToEventMap.get(id);
    }

    public static List<StreamEvent> getStreamEventByType(String eventType) {
        return typeToEventMap.get(eventType);
    }

    public static void deleteStreamEventById(int id) {
        StreamEvent event = idToEventMap.remove(id);
        if (event != null) {
            List<StreamEvent> events = typeToEventMap.get(event.getEventType());
            if (events != null) {
                events.remove(event);
                if (events.isEmpty()) {
                    typeToEventMap.remove(event.getEventType());
                }
            }
        }
    }

    public static void printAllStreamEvent() {
        for (Map.Entry<Integer, StreamEvent> entry : idToEventMap.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public static void main(String[] args) {
        StreamEvent event1 = new StreamEvent(1, "info", "one");
        StreamEvent event2 = new StreamEvent(2, "sending", "two");
        StreamEvent event3 = new StreamEvent(3, "accepted", "three");
        StreamEvent event4 = new StreamEvent(4, "error", "four");

        addStreamEvent(event1);
        addStreamEvent(event2);
        addStreamEvent(event3);
        addStreamEvent(event4);

        printAllStreamEvent();
        System.out.println();

        System.out.println(getStreamEventById(3));
        System.out.println();

        System.out.println(getStreamEventByType("error"));
        System.out.println();

        deleteStreamEventById(1);
        printAllStreamEvent();
    }
}
