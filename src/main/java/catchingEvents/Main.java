package catchingEvents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final Map<Integer, StreamEvent> STREAM_EVENT_MAP = new HashMap<>();
    private static final Map<String, List<StreamEvent>> STREAM_EVENTS_BY_TYPE = new HashMap<>();

    public static void main(String[] args) {
        StreamEvent event1 = new StreamEvent(1, "Del", "Something");
        StreamEvent event2 = new StreamEvent(2, "Del", "Something");
        StreamEvent event3 = new StreamEvent(3, "Copy", "Something");
        StreamEvent event4 = new StreamEvent(4, "Copy", "Something");

        addEvent(event1);
        addEvent(event2);
        addEvent(event3);
        addEvent(event4);
        printAllInfoAboutEvents();

        System.out.println(findEventById(2));

        System.out.println(findListOfStreamEventsByType("Copy"));

        deleteEvent(event2);
        printAllInfoAboutEvents();
        deleteEvent(event2);

    }

    private static void updateStreamEventMap(StreamEvent event) {
        STREAM_EVENT_MAP.put(event.getId(), event);
    }

    private static void updateListOfStreamEvents(StreamEvent event) {
        List<StreamEvent> tmp;
        String key = event.getEventType();
        if (!STREAM_EVENTS_BY_TYPE.containsKey(key)) {
            STREAM_EVENTS_BY_TYPE.put(key, new ArrayList<>());
        }
        tmp = STREAM_EVENTS_BY_TYPE.get(key);
        tmp.add(event);
        STREAM_EVENTS_BY_TYPE.put(key, tmp);
    }

    public static void addEvent(StreamEvent event) {
        updateStreamEventMap(event);
        updateListOfStreamEvents(event);
    }

    public static StreamEvent findEventById(Integer id) {
        return STREAM_EVENT_MAP.get(id);
    }

    public static List<StreamEvent> findListOfStreamEventsByType(String type) {
        return STREAM_EVENTS_BY_TYPE.get(type);
    }

    public static void deleteEvent(StreamEvent event) {
        List<StreamEvent> tmp;
        String key = event.getEventType();

        STREAM_EVENT_MAP.remove(event.getId());

        tmp = STREAM_EVENTS_BY_TYPE.get(key);
        tmp.remove(event);
        STREAM_EVENTS_BY_TYPE.put(key, tmp);
    }

    public static void printAllInfoAboutEvents() {
        for (Map.Entry<Integer, StreamEvent> entry : STREAM_EVENT_MAP.entrySet()) {
            System.out.println("\nID: " + entry.getValue().getId() +
                    "\nEvent type: " + entry.getValue().getEventType() +
                    "\nData: " + entry.getValue().getData());
        }
    }
}
