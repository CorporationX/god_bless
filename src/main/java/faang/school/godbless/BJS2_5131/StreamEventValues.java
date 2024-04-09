package faang.school.godbless.BJS2_5131;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StreamEventValues {
    Map<Integer, StreamEvent> events = new HashMap<>();
    Map<String, List<StreamEvent>> eventsByGroup = new HashMap<>();

    public void addStream(StreamEvent streamEvent) {
        events.put(streamEvent.getId(), streamEvent);
        eventsByGroup.computeIfAbsent(streamEvent.getEventType(), k -> new ArrayList<>()).add(streamEvent);
    }

    public StreamEvent getEventById(int id) {
        return events.get(id);
    }

    public List<StreamEvent> getEventsByType(String eventType) {
        return eventsByGroup.get(eventType);
    }

    public void removeStream(int id) {
        StreamEvent streamEvent = events.get(id);
        events.remove(id);
        eventsByGroup.get(streamEvent.getEventType()).remove(streamEvent);
    }

    public void printAllEvents() {
        for (Map.Entry<String, List<StreamEvent>> entry : eventsByGroup.entrySet()) {
            System.out.println(entry.getValue());
            for (StreamEvent streamEvent : entry.getValue()) {
                System.out.println(streamEvent);
            }
        }
    }
}
