package faang.school.godbless.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<Integer, StreamEvent> idMap = new HashMap<>();
    private static Map<String, List<StreamEvent>> eventTypeMap = new HashMap<>();
    public static void main(String... args) {
        StreamEvent first = new StreamEvent(1, "event", "firstEvent");
        StreamEvent second = new StreamEvent(2, "anotherEvent", "secondEvent");
        StreamEvent third = new StreamEvent(3, "event", "thirdEvent");
        StreamEvent fourth = new StreamEvent(4, "anotherEvent", "fourthEvent");
        StreamEvent fifth = new StreamEvent(5, "justEvent", "fifthEvent");
        newEvent(first);
        newEvent(second);
        newEvent(third);
        newEvent(fourth);
        newEvent(fifth);
        List<StreamEvent> list = getEventsByEventType("event");
        for (StreamEvent event1 : list) {
            System.out.println(event1.getId() + " " + event1.getEventType() + " " + event1.getData());
        }
        StreamEvent event = getStreamEventById(3);
        System.out.println(event.getId() + " " + event.getEventType() + " " + event.getData());
        removeEventById(3);
        list = getEventsByEventType("event");
        for (StreamEvent event1 : list) {
            System.out.println(event1.getId() + " " + event1.getEventType() + " " + event1.getData());
        }
        printAllEvents();
    }

    public static void newEvent(StreamEvent event) {
        idMap.put(event.getId(), event);
        List<StreamEvent> streamEventList = eventTypeMap.get(event.getEventType());
        if (streamEventList == null) {
            streamEventList = new ArrayList<>();
        }
        streamEventList.add(event);
        eventTypeMap.put(event.getEventType(), streamEventList);
    }

    public static StreamEvent getStreamEventById(Integer id) {
        return idMap.get(id);
    }

    public static List<StreamEvent> getEventsByEventType(String type) {
        return eventTypeMap.get(type);
    }

    public static void removeEventById(Integer id) {
        StreamEvent event = idMap.remove(id);
        List<StreamEvent> streamEventList = eventTypeMap.get(event.getEventType());
        streamEventList.remove(event);
        eventTypeMap.put(event.getEventType(), streamEventList);
    }

    public static void printAllEvents() {
        for (Map.Entry<Integer, StreamEvent> entry : idMap.entrySet()) {
            System.out.println(String.format("ID: %d, EventType: %s, Data: %s", entry.getKey(),
                    entry.getValue().getEventType(), entry.getValue().getData()));
        }
    }
}
