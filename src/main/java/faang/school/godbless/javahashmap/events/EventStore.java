package faang.school.godbless.javahashmap.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EventStore {

    private final Map<Integer, StreamEvent> eventsById = new HashMap<>();
    private final Map<String, List<StreamEvent>> eventsByType = new HashMap<>();

    public void addOrUpdateEvent(StreamEvent event) {
        int id = event.getId();
        StreamEvent oldEvent = eventsById.put(id, event);

        if (oldEvent != null) {
            eventsByType.get(oldEvent.getEventType()).remove(oldEvent);
        }

        eventsByType.computeIfAbsent(event.getEventType(), eventType -> new ArrayList<>()).add(event);
    }

    public StreamEvent findEventById(int id) {
        return eventsById.get(id);
    }

    public List<StreamEvent> findEventsByType(String eventType) {
        return eventsByType.getOrDefault(eventType, List.of());
    }

    public void deleteEventById(int id) {
        eventsById.remove(id);
        eventsByType.values().forEach(list -> list.removeIf(event -> event.getId() == id));
    }

    public void printAllEvents() {
        eventsById.entrySet().forEach(entry ->
                System.out.println("ID: " + entry.getKey() + ", Type: " + entry.getValue().getEventType()
                        + ", Data: " + entry.getValue().getData()));
    }

    public Map<Integer, StreamEvent> getDeepCopyOfAllEventsGroupById() {
        Map<Integer, StreamEvent> eventsByIdToReturn = new HashMap<>();
        eventsById.forEach((id, event) -> eventsByIdToReturn.put(id,
                new StreamEvent(event.getId(), event.getEventType(), event.getData())));
        return eventsByIdToReturn;
    }

    public Map<String, List<StreamEvent>> getDeepCopyOfAllEventsGroupByType() {
        Map<String, List<StreamEvent>> eventsByTypeToReturn = new HashMap<>();
        eventsByType.forEach((type, events) -> eventsByTypeToReturn.put(type,
                events.stream().map(event -> new StreamEvent(event.getId(), event.getEventType(), event.getData()))
                        .collect(Collectors.toList())));
        return eventsByTypeToReturn;
    }
}
