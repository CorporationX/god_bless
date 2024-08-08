package faang.school.godbless.task.event.catching;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class EventManager {
    private final Map<Integer, StreamEvent> idStreamEventCache;
    private final Map<String, List<StreamEvent>> typeStreamEventCache;

    public void addNewStreamEvent(StreamEvent streamEvent) {
        idStreamEventCache.put(streamEvent.id(), streamEvent);
        typeStreamEventCache.computeIfAbsent(streamEvent.eventType(),
                key -> new ArrayList<>()).add(streamEvent);
    }

    public StreamEvent findStreamEventById(int id) {
        return idStreamEventCache.get(id);
    }

    public List<StreamEvent> findStreamEventByEventType(String eventType) {
        return typeStreamEventCache.get(eventType);
    }

    public void deleteStreamEventById(int id) {
        StreamEvent streamEvent = idStreamEventCache.remove(id);
        List<StreamEvent> streamEventsList = typeStreamEventCache.get(streamEvent.eventType());
        streamEventsList.remove(streamEvent);
    }
}
