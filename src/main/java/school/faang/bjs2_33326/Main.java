package school.faang.bjs2_33326;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, StreamEvent> idToStreamEventMap = new HashMap<>();
        Map<String, List<StreamEvent>> eventTypeToStreamEventsMap = new HashMap<>();
        testAddStreamEventUpdateBothMaps(idToStreamEventMap,eventTypeToStreamEventsMap);

    }

    public static void testAddStreamEventUpdateBothMaps(Map<Integer, StreamEvent> idToStreamEventMap,
                                                        Map<String, List<StreamEvent>> eventTypeToStreamEventsMap) {
        System.out.println("testAddStreamEventUpdateBothMaps\n");

        System.out.println("idToStreamEventMap before: " + idToStreamEventMap);
        System.out.println("eventTypeToStreamEventsMap before: " + eventTypeToStreamEventsMap);
        StreamEvent streamEventForAdd = new StreamEvent(5, "Start", "Data1");
        System.out.println("add: " + streamEventForAdd);

        StreamEventUtils.addStreamEvent(streamEventForAdd, idToStreamEventMap, eventTypeToStreamEventsMap);
        System.out.println("idToStreamEventMap after: " + idToStreamEventMap);
        System.out.println("eventTypeToStreamEventsMap after: " + eventTypeToStreamEventsMap);
    }
}
