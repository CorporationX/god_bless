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

    public void deleteStreamEvent(Integer id) {
        StreamEvent event = eventsById.get(id);
        if (event != null) {
            deleteStreamEventById(id);
            deleteStreamEventFromEventsByType(event);
        }
    }

    private void deleteStreamEventById(Integer id) {
        if (eventsById.containsKey(id)) {
            eventsById.remove(id);
        } else {
            throw new NoSuchElementException("There is no Event in event_by_id storage with id = " + id);
        }
    }

    private void deleteStreamEventFromEventsByType(StreamEvent streamEvent) {
        List<StreamEvent> events = eventsByTypes.get(streamEvent.getEventType());
        if (events != null && !events.isEmpty()) {
            if (!events.remove(streamEvent)) {
                throw new NoSuchElementException("There is no Event in events_by_type storage with id = " + streamEvent.getId());
            }
        } else {
            throw new RuntimeException("List of type = " + streamEvent.getEventType() + "is empty or null");
        }
    }

    public void printEvents() {
        for(Map.Entry<Integer, StreamEvent> event: eventsById.entrySet()) {
            System.out.println(event);
        }
    }
}
