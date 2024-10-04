package catchEvents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<Integer, StreamEvent> EVENTS = new HashMap<>();
    private static final Map<String, List<StreamEvent>> EVENTS_BY_TYPE = new HashMap<>();

    public static void main(String[] args) {

        addEvent("event1", "data1");
        addEvent("event2", "data2");
        addEvent("event1", "data3");
        addEvent("event3", "data4");
        addEvent("event3", "data5");

        printAllStreamEvents();


    }

    public static void addEvent(String eventType, String data) {
        StreamEvent event = new StreamEvent(eventType, data);
        EVENTS.putIfAbsent(event.getId(), event);
        EVENTS_BY_TYPE.computeIfAbsent(eventType, k -> new ArrayList<>()).add(event);
    }

    public static StreamEvent findEventByID(int id) {
        return null;
    }

    public static List<StreamEvent> findEventsByType(String eventType) {
        return null;
    }

    public static void removeEvent(int id) {
    }

    public static void printAllStreamEvents(){
        for(Map.Entry<Integer, StreamEvent> entry : EVENTS.entrySet()) {
            System.out.println(
                    "ID: " + entry.getKey() +
                    ", тип события: " + entry.getValue().getEventType() +
                    ", данные: " + entry.getValue().getData());
        }
    }

}
