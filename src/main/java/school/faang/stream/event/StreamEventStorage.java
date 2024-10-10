package school.faang.stream.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StreamEventStorage {
    private Map<Integer, StreamEvent> streamEventById;
    private Map<String, List<StreamEvent>> streamEventByType;

    public StreamEventStorage() {
        this.streamEventById = new HashMap<>();
        this.streamEventByType = new HashMap<>();
    }

    public void add(StreamEvent streamEvent) {
        streamEventById.put(streamEvent.getId(), streamEvent);
        streamEventByType.computeIfAbsent(streamEvent.getEventType(),
                eventType -> new ArrayList<>()).add(streamEvent);
    }

    public StreamEvent findById(Integer id) {
        return streamEventById.get(id);
    }

    public List<StreamEvent> findByEventType(String eventType) {
        return streamEventByType.get(eventType);
    }

    public void deleteById(Integer id) {
        StreamEvent streamEvent = streamEventById.get(id);
        streamEventById.remove(id);
        List<StreamEvent> streamEvents = streamEventByType.get(streamEvent.getEventType());
        streamEvents.remove(streamEvent);
        if (streamEvents.isEmpty()) {
            streamEventByType.remove(streamEvent.getEventType());
        }
    }

    public void printAllStreamEvent() {
        for (Map.Entry<Integer, StreamEvent> entry : streamEventById.entrySet()) {
            System.out.printf("Id: %d, eventType: %s, data: %s%n",
                    entry.getKey(),
                    entry.getValue().getEventType(),
                    entry.getValue().getData());
        }
    }
}
