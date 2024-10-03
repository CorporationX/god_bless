package school.faang.catch_ivents_BJS2_33206;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<String, StreamEvent> allStreamEvents = new HashMap<>();
    private static final Map<String, ArrayList<StreamEvent>> eventsSortedByType = new HashMap<>();

    public static void main(String[] args) {

        StreamEvent event1 = new StreamEvent("1", "USER_LOGIN", "User John logged in");
        StreamEvent event2 = new StreamEvent("2", "ORDER_PLACED", "Order #12345 placed");
        StreamEvent event3 = new StreamEvent("3", "FILE_UPLOADED", "File report.pdf uploaded");
        StreamEvent event4 = new StreamEvent("4", "ORDER_PLACED", "Order #65345 placed");

        addNewEvent(event1);
        addNewEvent(event2);
        addNewEvent(event3);
        addNewEvent(event4);
        printAllEvents();
        System.out.println(findEventById("2"));
        System.out.println(findEventById("15"));
        System.out.println(findEventByType("ORDER_PLACED"));
        System.out.println(findEventByType("login"));
        deleteEventById("2");
        printAllEvents();

    }

    public static void addNewEvent(StreamEvent streamEvent) {
        allStreamEvents.put(streamEvent.getId(), streamEvent);
        eventsSortedByType.computeIfAbsent(streamEvent.getEventType(), k -> new ArrayList<>()).add(streamEvent);
    }

    public static StreamEvent findEventById(String id) {
        return allStreamEvents.get(id);
    }

    public static List<StreamEvent> findEventByType(String eventType) {
        return eventsSortedByType.get(eventType);
    }

    public static void deleteEventById(String id) {
        StreamEvent event = allStreamEvents.get(id);
        allStreamEvents.remove(id);
        eventsSortedByType.remove(event.getEventType());
    }

    public static void printAllEvents() {
        for (Map.Entry<String, StreamEvent> eventEntry : allStreamEvents.entrySet()) {
            String id = eventEntry.getValue().getId();
            String eventType = eventEntry.getValue().getEventType();
            String data = eventEntry.getValue().getData();
            System.out.printf("ID of event : %s. Type of event : %s. Data of event : %s \n", id, eventType, data);
        }
    }

}
