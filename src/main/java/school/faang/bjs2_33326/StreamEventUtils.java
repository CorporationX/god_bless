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

    public static StreamEvent findEventById(int idEvent, Map<Integer, StreamEvent> idToStreamEventMap) {
        return idToStreamEventMap.get(idEvent);
    }

    public static List<StreamEvent> findEventsByType(String eventType,
                                                     Map<String, List<StreamEvent>> eventTypeToStreamEventsMap) {
        return eventTypeToStreamEventsMap.get(eventType);
    }

    public static void removeEventById(int idEvent, Map<Integer, StreamEvent> idToStreamEventMap,
                                       Map<String, List<StreamEvent>> eventTypeToStreamEventsMap) {
        StreamEvent streamEvent = idToStreamEventMap.get(idEvent);
        String eventType = streamEvent.getEventType();
        idToStreamEventMap.remove(idEvent);

        List<StreamEvent> streamEvents = eventTypeToStreamEventsMap.get(eventType);
        if (streamEvents == null) {
            return;
        }
        streamEvents.remove(streamEvent);

    }

    public static void printAllEvents(Map<Integer, StreamEvent> idToStreamEventMap) {
        for (Map.Entry<Integer, StreamEvent> integerStreamEventEntry : idToStreamEventMap.entrySet()) {
            StreamEvent eventValueEntry = integerStreamEventEntry.getValue();
            System.out.println(eventValueEntry.getId() + " " + eventValueEntry.getEventType() + " " + eventValueEntry.getData());

        }
    }
}
