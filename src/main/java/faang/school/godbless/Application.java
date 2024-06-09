package faang.school.godbless;

import faang.school.godbless.task10.StreamEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EventListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Application {
    static Map<Integer, StreamEvent> streamEvents = new HashMap<>();
    static Map<String, List<StreamEvent>> streamEventsList = new HashMap<>();
    public static void addEvent(StreamEvent event) {
        streamEvents.computeIfAbsent(event.getId(), k -> event);
        streamEventsList.computeIfAbsent(event.getEventType(), k -> new ArrayList<>()).add(event);
    }

    public static StreamEvent findEvent(Integer id) {
        return streamEvents.get(id);
    }
    public static List<StreamEvent> findEvents(String eventType) {
        return streamEventsList.get(eventType);
    }

    public static void deleteEvent(Integer id) {
        StreamEvent event = streamEvents.remove(id);
        streamEventsList.computeIfPresent(event.getEventType(), (k, v) -> {
            v.remove(event);
            return v;
        });
    }

    public static void printEvents() {
        for (Map.Entry<Integer, StreamEvent> entry: streamEvents.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue().getEventType() + " " +
                    entry.getValue().getData());
        }
    }
    public static void main(String[] args) {
        StreamEvent event1 = new StreamEvent(812398481, "download", "faang-school");
        StreamEvent event2 = new StreamEvent(81245223, "upload", "faang-school");
        StreamEvent event3 = new StreamEvent(8122323, "show", "maang-school");
        StreamEvent event4 = new StreamEvent(8122324, "show", "maang-school");
        addEvent(event1);
        addEvent(event2);
        addEvent(event3);
        addEvent(event4);
        findEvent(81245223);
        findEvents("show");
        deleteEvent(8122323);
        printEvents();
    }
}