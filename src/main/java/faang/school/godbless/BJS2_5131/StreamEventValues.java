package faang.school.godbless.BJS2_5131;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StreamEventValues {
    private final Map<Integer, StreamEvent> eventsGroupById = new HashMap<>();
    private final Map<String, List<StreamEvent>> eventsGroupByEventType = new HashMap<>();

    public void addStream(StreamEvent streamEvent) {
        if (streamEvent != null) {
            eventsGroupById.put(streamEvent.getId(), streamEvent);
            eventsGroupByEventType.computeIfAbsent(streamEvent.getEventType(), k -> new ArrayList<>()).add(streamEvent);
        } else {
            throw new IllegalArgumentException("Method - addStream, streamEvent = null");
        }
    }

    public StreamEvent getEventById(int id) {
        return eventsGroupById.get(id);
    }

    public List<StreamEvent> getEventsByType(String eventType) {
        return eventsGroupByEventType.get(eventType);
    }

    public void removeStream(int id) {
        StreamEvent streamEvent = eventsGroupById.get(id);
        if (streamEvent != null) {
            eventsGroupById.remove(id);
            eventsGroupByEventType.get(streamEvent.getEventType()).remove(streamEvent);
        } else {
            throw new IllegalArgumentException("Method - removeStream, streamEvent = null");
        }
    }

    public void printAllEvents() {
        for (Map.Entry<String, List<StreamEvent>> entry : eventsGroupByEventType.entrySet()) {
            System.out.println(entry.getValue());
            for (StreamEvent streamEvent : entry.getValue()) {
                System.out.println(streamEvent);
            }
        }
    }
}
