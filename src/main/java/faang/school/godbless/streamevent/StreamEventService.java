package faang.school.godbless.streamevent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StreamEventService {

    public void addEvent(Map<Integer, StreamEvent> eventsMap, Map<String, List<StreamEvent>> eventsTypeMap,
                         StreamEvent streamEvent) {
        eventsMap.put(streamEvent.getId(), streamEvent);
        eventsTypeMap.computeIfAbsent(streamEvent.getEventType(), k -> new ArrayList<>()).add(streamEvent);
    }

    public StreamEvent findEventById(Map<Integer, StreamEvent> eventsMap, Integer eventId) {
        var event = eventsMap.getOrDefault(eventId, null);

        if (event == null) {
            System.out.println("Event not found" + "\n");
        }

        return event;
    }

    public List<StreamEvent> findEventsByType(Map<String, List<StreamEvent>> eventsTypeMap, String eventType) {
        var events = eventsTypeMap.getOrDefault(eventType, null);

        if (events == null) {
            System.out.println("Events not found" + "\n");
        }
        return events;
    }

    public void removeEvent(Map<Integer, StreamEvent> eventsMap, Map<String, List<StreamEvent>> eventsTypeMap, Integer eventId) {
        var removedEvent = eventsMap.remove(eventId);

        if (removedEvent == null) {
            System.out.println("Event not found" + "\n");
        } else {
            eventsTypeMap.get(removedEvent.getEventType()).remove(removedEvent);
        }
    }

    public void eventsInfo(Map<Integer, StreamEvent> eventsMap) {
        eventsMap.forEach((key, value) ->
                System.out.println("Event ID: " + key +
                        ", EventType: " + value.getEventType() +
                        ", Data: " + value.getData()));
    }
}
