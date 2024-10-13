package school.faang.catchtheevents;

import java.util.ArrayList;

import static school.faang.catchtheevents.Main.EVENT_TYPES;
import static school.faang.catchtheevents.Main.STREAM_EVENTS;

public class StreamEventService {
    public static void addNewEvent(StreamEvent event) {
        STREAM_EVENTS.put(event.getId(), event);
        EVENT_TYPES.computeIfAbsent(event.getEventType(), eventType -> new ArrayList<>()).add(event);
    }

    public static StreamEvent getEventById(Integer id) {
        return STREAM_EVENTS.get(id);
    }

    public static ArrayList<StreamEvent> getEventListByType(String eventType) {
        ArrayList<StreamEvent> streamsByType = EVENT_TYPES.get(eventType);
        return streamsByType;
    }

    public static void removeEventById(Integer id) {
        StreamEvent eventForDelete = STREAM_EVENTS.get(id);
        String eventTypeForDelete = eventForDelete.getEventType();
        if (eventTypeForDelete != null) {
            EVENT_TYPES.remove(eventTypeForDelete);
            STREAM_EVENTS.remove(id);
        }
    }

    public static void printAllEvents() {
        for (var entry : STREAM_EVENTS.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
