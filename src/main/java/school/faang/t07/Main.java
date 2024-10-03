package school.faang.t07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final Map<Integer, StreamEvent> EVENT = new HashMap<>(); // ID + eventType
    private static final Map<String, List<StreamEvent>> LIST_MAP = new HashMap<>(); // eventType + eventTypeList


    public static void main(String[] args) {

        StreamEvent eventOne = new StreamEvent(1, "login", "User 1 has logged in");
        StreamEvent eventTwo = new StreamEvent(3, "login", "User 2 has logged in");
        StreamEvent eventTree = new StreamEvent(4, "exit", "User 1 has logged out");
        StreamEvent eventFour = new StreamEvent(5, "login", "User 3 has logged in");
        StreamEvent eventFive = new StreamEvent(7, "exit", "User 3 has logged out");
        StreamEvent eventSix = new StreamEvent(8, "login", "User 4 has logged in");
        StreamEvent eventSeven = new StreamEvent(9, "login", "User 5 has logged in");

        addStreamEvent(eventOne);
        addStreamEvent(eventTwo);
        addStreamEvent(eventTree);
        addStreamEvent(eventFour);
        addStreamEvent(eventFive);
        addStreamEvent(eventSix);
        addStreamEvent(eventSeven);

        System.out.println(findStreamEventById(1));

        System.out.println(findStreamByEventType("login"));

        removeStreamEventById(3);

        EventsInfo();
    }

    public static void addStreamEvent(StreamEvent streamEvent) {
        EVENT.put(streamEvent.getId(), streamEvent);
        LIST_MAP.computeIfAbsent(streamEvent.getEventType(), k -> new ArrayList<>()).add(streamEvent);
    }

    public static StreamEvent findStreamEventById(int id) {
        return EVENT.get(id);
    }

    public static List<StreamEvent> findStreamByEventType(String eventType) {
        return LIST_MAP.get(eventType);
    }

    public static void removeStreamEventById(int id) {
        StreamEvent streamEvent = EVENT.remove(id);
        EVENT.remove(id);
        LIST_MAP.get(streamEvent.getEventType()).remove(streamEvent);
    }

    public static void EventsInfo() {
        for (Map.Entry<Integer, StreamEvent> entry : EVENT.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}




