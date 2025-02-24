package school.faang.lightsect.BJS233245;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Event {
    private static final Map<Integer, StreamEvent> STREAM_EVENT_BY_ID = new HashMap<>();
    static final Map<String, List<StreamEvent>> LIST_OF_EVENT_WITH_TYPE = new HashMap<>();

    public static void addEvent(StreamEvent newEvent) {
        STREAM_EVENT_BY_ID.put(newEvent.getId(), newEvent);
        LIST_OF_EVENT_WITH_TYPE.computeIfAbsent(newEvent.getEventType(), key -> new ArrayList<>()).add(newEvent);
    }

    public static StreamEvent getEventById(int id) {
        return STREAM_EVENT_BY_ID.get(id);
    }

    public static List<StreamEvent> searchStreamEvenByType(String event) {
        return LIST_OF_EVENT_WITH_TYPE.get(event);
    }

    public static void deleteStreamById(int id) {
        StreamEvent event = STREAM_EVENT_BY_ID.remove(id);

        if (event != null) {
            String eventType = event.getEventType();
            List<StreamEvent> events = LIST_OF_EVENT_WITH_TYPE.get(eventType);

            if (events != null) {
                events.remove(event);

                if (events.isEmpty()) {
                    LIST_OF_EVENT_WITH_TYPE.remove(eventType);
                }
            }
        }
    }

    public static void printAllEvents() {
        STREAM_EVENT_BY_ID.forEach((key, value) -> System.out.printf("id: %d, type: %s, data: %s\n", key, value.getEventType(), value.getData()));
    }

}
