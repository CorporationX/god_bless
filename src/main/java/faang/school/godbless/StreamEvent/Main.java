package faang.school.godbless.StreamEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final Map<Integer, StreamEvent> streamEventMap = new HashMap<>();
    public static final Map<String, List<StreamEvent>> secondStreamEventMap = new HashMap<>();

    public static void addNewEvent(int id, String eventType, String data) {
        StreamEvent streamEvent = new StreamEvent(id, eventType, data);
        streamEventMap.put(id, streamEvent);
        secondStreamEventMap.computeIfAbsent(streamEvent.getEventType(), k -> new ArrayList<>()).add(streamEvent);
    }

    public static void searchEvent(int id) {
        streamEventMap.get(id);
    }

    public static void removeEvent(int id) {
        StreamEvent streamEvent = streamEventMap.get(id);
        String event = streamEvent.getEventType();
        secondStreamEventMap.remove(event);
        streamEventMap.remove(id);
    }

    public static void printAllEvents() {
        for (Map.Entry<Integer, StreamEvent> entry : streamEventMap.entrySet()) {
            System.out.println("ID: " + entry.getKey() + ", Event: " + entry.getValue());
        }
        for (Map.Entry<String, List<StreamEvent>> entry : secondStreamEventMap.entrySet()) {
            System.out.println("Event Type: " + entry.getKey());
            for (StreamEvent event : entry.getValue()) {
                System.out.println("    Event: " + event);
            }
        }
    }

    public static void main(String[] args) {
        addNewEvent(1, "BirthDay", "20 August");
        addNewEvent(2, "Victory Day", "9 May");
        addNewEvent(3, "New Year", "31 December");
        addNewEvent(4, "Meeting", "20 August");
        addNewEvent(5, "Anniversary", "15 June");
        addNewEvent(6, "Conference", "20 August");
        addNewEvent(7, "Workshop", "9 May");
        addNewEvent(8, "Seminar", "10 October");
        addNewEvent(9, "Presentation", "31 December");
        addNewEvent(10, "Holiday", "25 December");
        addNewEvent(11, "Party", "20 August");
        addNewEvent(12, "Concert", "15 June");
        addNewEvent(13, "Festival", "31 December");
        printAllEvents();
        searchEvent(1);
        removeEvent(1);
        printAllEvents();
    }
}