package faang.school.godbless.catching_events;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Slf4j
public class StreamEventService {
    private Map<Integer, StreamEvent> eventMap;
    private Map<String, List<StreamEvent>> eventListMap;

    public StreamEventService() {
        eventMap = new HashMap<>();
        eventListMap = new HashMap<>();
    }

    public StreamEvent findStreamEventById(int id) {
        if (!eventMap.containsKey(id)) {
            log.warn("Stream Event with this id: {} is not found", id);
            return null;
        } else {
            return eventMap.get(id);
        }
    }

    public List<StreamEvent> findStreamEventByEventType(String eventType) {
        if (!eventListMap.containsKey(eventType)) {
            log.warn("List of events with this event type: {} is not found", eventType);
            return null;
        } else {
            return eventListMap.get(eventType);
        }
    }

    public void addStreamEvent(StreamEvent streamEvent) {
        eventMap.put(streamEvent.getId(), streamEvent);

        String eventType = streamEvent.getEventType();
        eventListMap.computeIfAbsent(eventType, streamEventAsKey -> new ArrayList<>()).add(streamEvent);
    }

    public void deleteStreamEvent(int id, String eventData, String data) {
        if (!eventMap.containsKey(id)) {
            log.info("Could not find and delete StreamEvent with id: {}, eventData: {}, data: {}",
                    id, eventData, data);
        } else {
            StreamEvent streamEvent = eventMap.remove(id);
            eventListMap.get(eventData).remove(streamEvent);
        }
    }

    public void showAllStreamEvents() {
        for (Map.Entry<Integer, StreamEvent> eventEntry : eventMap.entrySet()) {
            System.out.println(eventEntry.getValue());
        }
    }
}
