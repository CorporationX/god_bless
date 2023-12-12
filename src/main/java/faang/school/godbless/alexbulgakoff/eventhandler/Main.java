package faang.school.godbless.alexbulgakoff.eventhandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Alexander Bulgakov
 */

public class Main {

    private static final Map<Integer, StreamEvent> EVENTS = new HashMap<>();
    private static final Map<String, List<StreamEvent>> EVENTS_LIST = new HashMap<>();

    public static void main(String[] args) {
        StreamEvent streamEvent1 = new StreamEvent(1, "ERROR", "Error exception");
        StreamEvent streamEvent2 = new StreamEvent(2, "CONNECTED", "User is connect");
        StreamEvent streamEvent3 = new StreamEvent(3, "TIME_OUT", "Time from connection is out");
        StreamEvent streamEvent4 = new StreamEvent(4, "ERROR", "Server error");
        StreamEvent streamEvent5 = new StreamEvent(5, "NEW", "New connection wait connect");

        //Add events
        addEvents(streamEvent1);
        addEvents(streamEvent2);
        addEvents(streamEvent3);
        addEvents(streamEvent4);
        addEvents(streamEvent5);

        System.out.println(EVENTS);
        System.out.println(EVENTS_LIST);

        //new line
        System.out.println();

        //search event by id
        System.out.println(getEventById(2));
        System.out.println(getEventById(4));

        //new line
        System.out.println();

        //search list events by type
        System.out.println(getListEventsByType("ERROR"));
        System.out.println(getListEventsByType("NEW"));

        //new line
        System.out.println();

        //remove event by id from EVENTS && EVENT_LIST
        removeEvent(3);
        System.out.println(EVENTS);
        System.out.println(EVENTS_LIST);

        //new line
        System.out.println();

        //get all events with information
        getAllEventInfo();
    }

    public static void addEvents(StreamEvent newStreamEvent) {
        EVENTS.put(newStreamEvent.getId(), newStreamEvent);
        EVENTS_LIST.putIfAbsent(newStreamEvent.getEventType(), new ArrayList<>());
        EVENTS_LIST.get(newStreamEvent.getEventType()).add(newStreamEvent);
    }

    public static StreamEvent getEventById(Integer id) {
        return EVENTS.get(id);
    }

    public static List<StreamEvent> getListEventsByType(String typeEvent) {
        return EVENTS_LIST.get(typeEvent);
    }

    public static void getAllEventInfo() {
        for (Map.Entry<Integer, StreamEvent> entry : EVENTS.entrySet()) {
            System.out.println("Event ID: " + entry.getValue().getId());
            System.out.println("Event TYPE: " + entry.getValue().getEventType());
            System.out.println("Event DATA: " + entry.getValue().getData());
            System.out.println();
        }
    }

    public static void removeEvent(Integer id) {
        StreamEvent event = EVENTS.get(id);
        List<StreamEvent> removableListEvent =
                EVENTS_LIST.get(event.getEventType());

        removableListEvent.remove(event);

        EVENTS.remove(event.getId());
    }
}
