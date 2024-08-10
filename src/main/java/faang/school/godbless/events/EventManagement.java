package faang.school.godbless.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManagement {
    private Map<Integer, StreamEvent> eventsById = new HashMap<>();
    private Map<String, List<StreamEvent>> eventsByType = new HashMap<>();

    public void addEvent(StreamEvent event) {
        eventsById.put(event.getId(), event);
        eventsByType.computeIfAbsent(event.getEventType(), k -> new ArrayList<StreamEvent>()).add(event);
    }

    public StreamEvent searchById(int id) {
        return eventsById.get(id);
    }

    public List<StreamEvent> searchByType(String type) {
        return eventsByType.get(type);
    }

    public void removeEvent(int id) {
        StreamEvent deleted = eventsById.remove(id);
        eventsByType.get(deleted.getEventType()).remove(deleted);
        if (eventsByType.get(deleted.getEventType()).isEmpty()) {
            eventsByType.remove(deleted.getEventType());
        }
    }

    public String getAllStreamsReport() {
        StringBuilder report = new StringBuilder();
        for (var entry : eventsById.entrySet()) {
            report.append(entry.getKey()).append(":").append(entry.getValue().getEventType()).append(",")
                    .append(entry.getValue().getData()).append("\n");
        }
        return report.toString();
    }
}
