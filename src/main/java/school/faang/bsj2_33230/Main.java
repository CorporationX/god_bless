package school.faang.bsj2_33230;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static final Map<Integer, StreamEvent> STREAM_EVENTS_BY_ID = new HashMap<>();
    static final Map<String, List<StreamEvent>> STREAM_EVENTS_BY_TYPE = new HashMap<>();
    static int id = 0;

    static StreamEvent addStreamEvent(String eventType, String data) {
        StreamEvent streamEvent = new StreamEvent(id, eventType, data);
        STREAM_EVENTS_BY_ID.put(id, streamEvent);
        STREAM_EVENTS_BY_TYPE.computeIfAbsent(eventType, key -> new ArrayList<>()).add(streamEvent);
        id++;
        return streamEvent;
    }

    static StreamEvent searchStreamEventById(int id) {
        return STREAM_EVENTS_BY_ID.get(id);
    }

    static List<StreamEvent> searchStreamEventsByType(String eventType) {
        return STREAM_EVENTS_BY_TYPE.get(eventType);
    }

    static void deleteStreamEventById(int id) {
        StreamEvent targetStreamEvent = STREAM_EVENTS_BY_ID.remove(id);
        String targetType = targetStreamEvent.getEventType();
        STREAM_EVENTS_BY_TYPE.get(targetType).remove(targetStreamEvent);
    }

    static void printAllStreamEvents() {
        for (var entry : STREAM_EVENTS_BY_ID.entrySet()) {
            int id = entry.getValue().getId();
            String eventType = entry.getValue().getEventType();
            String eventData = entry.getValue().getData();
            System.out.printf("Событие № %d, тип события - '%s', данные события - '%s'.\n", id, eventType, eventData);
        }
    }
}
