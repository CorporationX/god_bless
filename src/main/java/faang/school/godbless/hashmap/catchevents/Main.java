package faang.school.godbless.hashmap.catchevents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import static java.util.Optional.ofNullable;

public class Main {
    private final Map<Integer, StreamEvent> eventsIdMap = new HashMap<>();
    private final Map<String, List<StreamEvent>> eventsTypeMap = new HashMap<>();

    public void addEvent(StreamEvent event) {
        var eventId = event.id();
        eventsIdMap.put(eventId, event);

        var eventType = event.eventType();
        eventsTypeMap
                .computeIfAbsent(eventType, k -> new ArrayList<>()).add(event);
    }

    public StreamEvent getEventByEventId(Integer eventId) {
        return ofNullable(eventsIdMap.get(eventId))
                .orElseThrow(() -> new NoSuchElementException("No such event with eventId: " + eventId));
    }

    public List<StreamEvent> getListEventsByEventType(String eventType) {
        return ofNullable(eventsTypeMap.get(eventType))
                .orElseThrow(() -> new NoSuchElementException("No such event with type: " + eventType));
    }

    public void deleteEventById(Integer eventId) {
        var event = eventsIdMap.remove(eventId);

        if (event != null) {
            eventsTypeMap.computeIfPresent(event.eventType(), (k, v) -> {
                v.removeIf(ev -> ev.equals(event));
                return v.isEmpty() ? null : v;
            });
        }
    }

    public void printEvent() {
        for (Map.Entry<Integer, StreamEvent> entry : eventsIdMap.entrySet()) {
            var id = entry.getKey();
            var event = entry.getValue();
            System.out.println("ID: " + id + ", Type: " + event.eventType() + ", Data: " + event.data());
        }
    }
}
