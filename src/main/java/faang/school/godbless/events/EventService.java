package faang.school.godbless.events;

import lombok.NonNull;

import java.util.*;

public class EventService {
    private final Map<Integer, StreamEvent> events = new HashMap<>();
    private final Map<String, List<StreamEvent>> eventsByType = new HashMap<>();

    public void addEvent(StreamEvent event) {
        events.put(event.id(), event);
        eventsByType.computeIfAbsent(event.type(), e -> new ArrayList<>()).add(event);
    }

    public StreamEvent findEventById(@NonNull Integer id) {
        return events.get(id);
    }

    public List<StreamEvent> findEventsByType(@NonNull String type) {
        return Collections.unmodifiableList(eventsByType.getOrDefault(type, new ArrayList<>()));
    }

    public void removeEventById(@NonNull Integer id) {
        events.remove(id);
        eventsByType.values().forEach(list -> list.removeIf(event -> id.equals(event.id())));
    }

    public void printEvents() {
        var sb = new StringBuilder();
        sb.append(String.format("Events: [%n"));
        for(var event : events.values()) {
            sb.append(String.format("%s - %s - %s%n", event.id(), event.type(), event.data()));
        }
        sb.append("]");
        System.out.println(sb);
    }

}
