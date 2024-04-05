package faang.school.godbless.javaHashMap.cathcingEvents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventsManager {
    private final Map<Integer, StreamEvent> eventsById;
    private final Map<String, List<StreamEvent>> eventsByType;

    public EventsManager() {
        eventsByType = new HashMap<>();
        eventsById = new HashMap<>();
    }

    public StreamEvent addNewEvent(int id, String eventType, String data) {
        StreamEvent newEvent = new StreamEvent(id, eventType, data);

        eventsById.put(id, newEvent);

        List<StreamEvent> eventList = eventsByType.computeIfAbsent(eventType, key -> new ArrayList<>());

        if(eventList.contains(newEvent)) {
            return newEvent;
        }

        eventList.add(newEvent);
        return newEvent;
    }

    public StreamEvent getEventById(int id) {
        return eventsById.get(id);
    }

    public List<StreamEvent> getStreamEventsByType(String eventType) {
        return eventsByType.get(eventType);
    }

    public void removeEvent(int id) {
        StreamEvent removedEvent = eventsById.remove(id);
        eventsByType.get(removedEvent.getEventType()).remove(removedEvent);
    }

    public void printAllEventsInfo() {
        if(eventsById.isEmpty()) {
            System.out.println("Events base is empty.");
        }

        eventsById.entrySet().forEach(System.out::println);
    }
}
