package school.faang.BJS233254;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StreamEventServiceImpl implements StreamEventService {

    private final Map<Integer, StreamEvent> streamEvents = new HashMap<>();
    private final Map<String, List<StreamEvent>> streamEventsByType = new HashMap<>();

    private static Integer id = 1;

    public void addEvent(EventType eventType, String s) {
        StreamEvent streamEvent = new StreamEvent(id, eventType, s);
        streamEvents.put(id, streamEvent);
        id++;
        streamEventsByType.computeIfAbsent(eventType.toString(), i -> new ArrayList<>()).add(streamEvent);
    }

    public StreamEvent findEventById(int id) {
        return streamEvents.get(id);
    }

    public List<StreamEvent> findListByEventType(EventType type) {
        return streamEventsByType.get(type.toString());
    }

    public void deleteEvent(int id) {
        StreamEvent streamEvent = streamEvents.get(id);
        List<StreamEvent> listStream = streamEventsByType.get(streamEvent.getEvent().toString());
        listStream.removeIf(s -> s.equals(streamEvent));
        if (listStream.isEmpty()) {
            streamEventsByType.remove(streamEvent.getEvent().toString());
        }
        streamEvents.remove(id);
    }

    public void printAll() {
        for (Map.Entry<String, List<StreamEvent>> stringListEntry : streamEventsByType.entrySet()) {
            for (StreamEvent streamEvent : stringListEntry.getValue()) {
                System.out.println(streamEvent.getId() + " " + streamEvent.getEvent() + " " + streamEvent.getData());
            }
        }
    }
}
