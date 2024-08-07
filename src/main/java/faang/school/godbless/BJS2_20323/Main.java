package faang.school.godbless.BJS2_20323;

import lombok.Getter;

import java.util.*;

@Getter
public class Main {
    private final Map<Integer, StreamEvent> eventsById = new HashMap<>();

    private final Map<String, List<StreamEvent>> eventsByTypes = new HashMap<>();

    public void addStreamEvent(StreamEvent streamEvent) {
        addStreamEventById(streamEvent);
        addStreamEventByType(streamEvent);
    }

    private void addStreamEventById(StreamEvent streamEvent) {
        eventsById.put(streamEvent.getId(), streamEvent);
    }

    private void addStreamEventByType(StreamEvent streamEvent) {
        String type = streamEvent.getEventType();
        if (!eventsByTypes.containsKey(type)) {
            eventsByTypes.put(type, new ArrayList<>(List.of(streamEvent)));
        } else {
            eventsByTypes.get(type).add(streamEvent);
        }
    }

    public StreamEvent getStreamEventById(Integer id) {
        return eventsById.get(id);
    }

    public List<StreamEvent> getStreamEventsByType(String type) {
        return eventsByTypes.get(type);
    }

    public boolean deleteStreamEvent(Integer id) {
        StreamEvent event = deleteStreamEventById(id);
        if (event != null) {
            return deleteStreamEventFromEventsByType(event);
        }
        return false;
    }

    private StreamEvent deleteStreamEventById(Integer id) {
        return eventsById.remove(id);
    }

    private boolean deleteStreamEventFromEventsByType(StreamEvent streamEvent) {
        List<StreamEvent> events = eventsByTypes.get(streamEvent.getEventType());
        if (events != null) {
            return events.remove(streamEvent);
        }
        return false;
    }

    public void printEvents() {
        for(Map.Entry<Integer, StreamEvent> event: eventsById.entrySet()) {
            System.out.println(event);
        }
    }
}
