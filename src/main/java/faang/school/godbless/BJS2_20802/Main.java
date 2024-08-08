package faang.school.godbless.BJS2_20802;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Main {
    private Map<Integer, StreamEvent> streamEventMap = new HashMap<>();
    private Map<String, List<StreamEvent>> eventTypeMap = new HashMap<>();

    public void addStreamEvent(StreamEvent streamEvent) {
        streamEventMap.put(streamEvent.getId(), streamEvent);
        eventTypeMap.computeIfAbsent(streamEvent.getEventType(), k -> new ArrayList<>()).add(streamEvent);
    }

    public StreamEvent findStreamEvent(Integer id) {
        return streamEventMap.get(id);
    }

    public List<StreamEvent> findStreamEvents(String eventType) {
        return eventTypeMap.get(eventType);
    }

    public void removeStreamEvent(Integer id) {
        streamEventMap.remove(id);
        for (Map.Entry<String, List<StreamEvent>> entry : eventTypeMap.entrySet()) {
            entry.getValue().removeIf(streamEvent -> streamEvent.getId() == id);
        }
    }

    public void printInfoStreamEvent() {
        for (Map.Entry<Integer, StreamEvent> entryS : streamEventMap.entrySet()) {
            StreamEvent streamEvent = entryS.getValue();
            System.out.println("Айди эвента:" + streamEvent.getId() + ", тип эвента: " + streamEvent.getEventType() + ", данные событий: " + streamEvent.getData());
        }
    }
}
