package school.faang.bjs2_33326;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StreamEventUtils {
    public static void addStreamEvent(StreamEvent event, Map<Integer, StreamEvent> idToStreamEventMap,
                                      Map<String, List<StreamEvent>> eventTypeToStreamEventsMap) {
        int idEvent = event.getId();
        idToStreamEventMap.put(idEvent, event);

        String eventType = event.getEventType();
        List<StreamEvent> streamEvents = eventTypeToStreamEventsMap.get(eventType);
        if (streamEvents == null) {
            streamEvents = new ArrayList<>();
            eventTypeToStreamEventsMap.put(eventType, streamEvents);
        }
        streamEvents.add(event);
    }

    public static StreamEvent findEventById(int id, Map<Integer, StreamEvent> idToStreamEventMap) {
        return idToStreamEventMap.get(id);
    }

    public static List<StreamEvent> findEventsByType(String eventType,
                                                     Map<String, List<StreamEvent>> eventTypeToStreamEventsMap) {
        return eventTypeToStreamEventsMap.get(eventType);
    }
}
