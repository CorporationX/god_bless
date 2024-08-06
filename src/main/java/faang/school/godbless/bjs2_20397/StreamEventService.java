package faang.school.godbless.bjs2_20397;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StreamEventService {
    private final Map<Integer, StreamEvent> streamEvents;
    private final Map<EventType, List<StreamEvent>> streamEventsByType;

    private static StreamEventService instance;

    private StreamEventService() {
        streamEvents = new HashMap<>();
        streamEventsByType = new HashMap<>();
        for (EventType eventType : EventType.values()) {
            streamEventsByType.put(eventType, new ArrayList<>());
        }
    }

    public static StreamEventService getInstance() {
        if (instance == null) {
            instance = new StreamEventService();
        }
        return instance;
    }

    public void addStreamEvent(StreamEvent event) {
        streamEvents.put(event.getId(), event);
        streamEventsByType.get(event.getEventType()).add(event);
    }

    public StreamEvent findStreamEventById(Integer id) {
        return streamEvents.get(id);
    }

    public void removeStreamEventById(Integer id) {
        var foundEvent = findStreamEventById(id);
        if (foundEvent != null) {
            streamEventsByType.get(foundEvent.getEventType()).remove(foundEvent);
            streamEvents.remove(id);
        }
    }

    public void print() {
        for (Map.Entry<Integer, StreamEvent> entry : streamEvents.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
