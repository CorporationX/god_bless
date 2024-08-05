package faang.school.godbless.task.event.catching;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EventManager {
    private Map<Integer, StreamEvent> idStreamEventCache;
    private Map<String, Map<Integer, StreamEvent>> typeStreamEventCache;

    public EventManager(Map<Integer, StreamEvent> idStreamEventCache,
                        Map<String, Map<Integer, StreamEvent>> typeStreamEventCache) {
        this.idStreamEventCache = idStreamEventCache;
        this.typeStreamEventCache = typeStreamEventCache;
    }

    public void addNewStreamEvent(StreamEvent streamEvent) {
        idStreamEventCache.put(streamEvent.id(), streamEvent);
        typeStreamEventCache.computeIfAbsent(streamEvent.eventType(),
                key -> new HashMap<>()).put(streamEvent.id(), streamEvent);
    }

    public StreamEvent findStreamEventById(int id) {
        return idStreamEventCache.get(id);
    }

    public List<StreamEvent> findStreamEventByEventType(String eventType) {
        Map<Integer, StreamEvent> integerStreamEventMap = typeStreamEventCache.get(eventType);
        return integerStreamEventMap.entrySet().stream()
                .map(Map.Entry::getValue).collect(Collectors.toList());
    }

    public void deleteStreamEventById(int id) {
        StreamEvent streamEvent = idStreamEventCache.remove(id);
        typeStreamEventCache.get(streamEvent.eventType()).remove(streamEvent.id());
    }
}
