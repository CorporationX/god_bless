package school.faang.bjs2_33326;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, StreamEvent> idToStreamEventMap = new HashMap<>();
        Map<String, List<StreamEvent>> eventTypeToStreamEventsMap = new HashMap<>();
        testAddStreamEventUpdateBothMaps(idToStreamEventMap, eventTypeToStreamEventsMap);
        testFindEventById(idToStreamEventMap);
        testFindEventsByType(eventTypeToStreamEventsMap);
    }

    public static void testAddStreamEventUpdateBothMaps(Map<Integer, StreamEvent> idToStreamEventMap,
                                                        Map<String, List<StreamEvent>> eventTypeToStreamEventsMap) {
        System.out.println("testAddStreamEventUpdateBothMaps\n");

        System.out.println("idToStreamEventMap before: " + idToStreamEventMap);
        System.out.println("eventTypeToStreamEventsMap before: " + eventTypeToStreamEventsMap);
        StreamEvent streamEventForAdd = new StreamEvent(5, "Start", "Data1");
        System.out.println("\nadd: " + streamEventForAdd + "\n");

        StreamEventUtils.addStreamEvent(streamEventForAdd, idToStreamEventMap, eventTypeToStreamEventsMap);
        System.out.println("idToStreamEventMap after: " + idToStreamEventMap);
        System.out.println("eventTypeToStreamEventsMap after: " + eventTypeToStreamEventsMap);
    }

    public static void testFindEventById(Map<Integer, StreamEvent> idToStreamEventMap) {
        System.out.println("\ntestFindEventById\n");

        int idEvent = 5;
        System.out.println("ID event: " + idEvent);

        StreamEvent eventById = StreamEventUtils.findEventById(idEvent, idToStreamEventMap);
        System.out.println("event by Id: " + eventById);
    }

    public static void testFindEventsByType(Map<String, List<StreamEvent>> eventTypeToStreamEventsMap) {
        System.out.println("\ntestFindEventsByType\n");

        String eventType = "Start";
        System.out.println("event type: " + eventType);

        List<StreamEvent> eventsByType = StreamEventUtils.findEventsByType(eventType, eventTypeToStreamEventsMap);
        System.out.println("events by type" + eventsByType);
    }
}
