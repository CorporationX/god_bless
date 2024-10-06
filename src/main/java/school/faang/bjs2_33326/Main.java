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
        testRemoveEventById(idToStreamEventMap, eventTypeToStreamEventsMap);
        testPrintAllEvents(idToStreamEventMap);
    }

    private static void testAddStreamEventUpdateBothMaps(Map<Integer, StreamEvent> idToStreamEventMap,
                                                        Map<String, List<StreamEvent>> eventTypeToStreamEventsMap) {
        System.out.println("testAddStreamEventUpdateBothMaps\n");

        System.out.println("idToStreamEventMap before: " + idToStreamEventMap);
        System.out.println("eventTypeToStreamEventsMap before: " + eventTypeToStreamEventsMap);
        StreamEvent streamEventForAdd = new StreamEvent(5, "Start", "Stream start");
        System.out.println("\nadd: " + streamEventForAdd + "\n");

        StreamEventUtils.addStreamEvent(streamEventForAdd, idToStreamEventMap, eventTypeToStreamEventsMap);
        System.out.println("idToStreamEventMap after: " + idToStreamEventMap);
        System.out.println("eventTypeToStreamEventsMap after: " + eventTypeToStreamEventsMap);
    }

    private static void testFindEventById(Map<Integer, StreamEvent> idToStreamEventMap) {
        System.out.println("\ntestFindEventById\n");

        int idEvent = 5;
        System.out.println("ID event: " + idEvent);

        StreamEvent eventById = StreamEventUtils.findEventById(idEvent, idToStreamEventMap);
        System.out.println("event by Id: " + eventById);
    }

    private static void testFindEventsByType(Map<String, List<StreamEvent>> eventTypeToStreamEventsMap) {
        System.out.println("\ntestFindEventsByType\n");

        String eventType = "Start";
        System.out.println("event type: " + eventType);

        List<StreamEvent> eventsByType = StreamEventUtils.findEventsByType(eventType, eventTypeToStreamEventsMap);
        System.out.println("events by type" + eventsByType);
    }

    private static void testRemoveEventById(Map<Integer, StreamEvent> idToStreamEventMap,
                                           Map<String, List<StreamEvent>> eventTypeToStreamEventsMap) {
        System.out.println("\ntestRemoveEventById\n");

        System.out.println("idToStreamEventMap before: " + idToStreamEventMap);
        System.out.println("eventTypeToStreamEventsMap before: " + eventTypeToStreamEventsMap);
        int idEventForRemove = 5;
        System.out.println("\nid event for remove: " + idEventForRemove + "\n");

        StreamEventUtils.removeEventById(5, idToStreamEventMap, eventTypeToStreamEventsMap);
        System.out.println("idToStreamEventMap after: " + idToStreamEventMap);
        System.out.println("eventTypeToStreamEventsMap after: " + eventTypeToStreamEventsMap);
    }

    private static void testPrintAllEvents(Map<Integer, StreamEvent> idToStreamEventMap){
        System.out.println("\ntestPrintAllEvents\n");
        generateEventsAddMap(idToStreamEventMap);
        StreamEventUtils.printAllEvents(idToStreamEventMap);
    }
    private static void generateEventsAddMap(Map<Integer, StreamEvent> idToStreamEventMap){
        idToStreamEventMap.put(1, new StreamEvent(1, "START", "Stream started"));
        idToStreamEventMap.put(2, new StreamEvent(2, "PAUSE", "Stream paused"));
        idToStreamEventMap.put(3, new StreamEvent(3, "RESUME", "Stream resumed"));
    }
}
