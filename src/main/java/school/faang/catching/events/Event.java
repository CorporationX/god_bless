package school.faang.catching.events;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
public class Event {
    private Map<Integer, StreamEvent> eventIds = new HashMap<>();
    private Map<String, List<StreamEvent>> eventByType = new HashMap<>();

    public void add(int id, String type) {
        StreamEvent event = new StreamEvent(id, type);
        eventIds.put(event.getId(), event);
        if (!eventByType.containsKey(event.getType())) { eventByType.put(event.getType(), new ArrayList<>()); }
        eventByType.get(event.getType()).add(event);
    }

    public String searchById(int eventId) {
        return eventIds.get(eventId) == null
                ? "Event with the following ID doesn't exist"
                : eventIds.get(eventId).toString();
    }

    public String searchByType(String eventType) {
        return eventByType.get(eventType) == null
                ? "Event with the following type doesn't exist"
                : eventByType.get(eventType).toString();
    }

    public void delete(int eventId) {
        String type = eventIds.get(eventId).getType();
        List<StreamEvent> events = eventByType.get(type);
        Iterator<StreamEvent> iterator = events.iterator();

        while (iterator.hasNext()) {
            StreamEvent event = iterator.next();
            if (event.getId() == eventId) {
                iterator.remove();
                break;
            }
        }

        eventIds.remove(eventId);
    }

    public void printAll() {
        for (StreamEvent event : eventIds.values()) {
            System.out.println(event);
        }
    }
}
