package catchingEvents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final Map<Integer, StreamEvent> STREAM_EVENTS_BY_ID = new HashMap<>();
    private static final Map<String, List<StreamEvent>> STREAM_EVENTS_BY_TYPE = new HashMap<>();

    public static void main(String[] args) {
        StreamEvent event1 = new StreamEvent("Del", "Something");
        StreamEvent event2 = new StreamEvent("Del", "Something");
        StreamEvent event3 = new StreamEvent("Copy", "Something");
        StreamEvent event4 = new StreamEvent("Copy", "Something");
        StreamEvent event5 = new StreamEvent("test", "test");

        deleteEvent(event5);

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
        checkEvent(event);
        STREAM_EVENTS_BY_ID.put(event.getId(), event);
    }

    private static void updateListOfStreamEvents(StreamEvent event) {
        checkEvent(event);
        String key = event.getEventType();
        if (!STREAM_EVENTS_BY_TYPE.containsKey(key)) {
            STREAM_EVENTS_BY_TYPE.put(key, new ArrayList<>());
        }
        STREAM_EVENTS_BY_TYPE.get(key).add(event);
    }

    public static void addEvent(StreamEvent event) {
        checkEvent(event);
        updateStreamEventMap(event);
        updateListOfStreamEvents(event);
    }

    public static StreamEvent findEventById(Integer id) {
        if (STREAM_EVENTS_BY_ID.get(id) == null) {
            throw new NullPointerException("Элемент c ID = null не может существовать");
        }
        return STREAM_EVENTS_BY_ID.get(id);
    }

    public static List<StreamEvent> findListOfStreamEventsByType(String type) {
        return STREAM_EVENTS_BY_TYPE.get(type);
    }

    public static void deleteEvent(StreamEvent event) {
        checkEvent(event);
        String key = event.getEventType();
        STREAM_EVENTS_BY_ID.remove(event.getId());

        if(STREAM_EVENTS_BY_TYPE.get(key) == null) {
            throw new NullPointerException("О событии с таким типом нет данных!");
        }

        STREAM_EVENTS_BY_TYPE.get(key).removeIf(event1 -> event1.equals(event));
    }

    public static void printAllInfoAboutEvents() {
        for (Map.Entry<Integer, StreamEvent> entry : STREAM_EVENTS_BY_ID.entrySet()) {
            System.out.println(String.format("\nID: %s\nEvent type: %s\nData: %s",
                    entry.getValue().getId(), entry.getValue().getEventType(), entry.getValue().getData()));
        }
    }

    private static void checkEvent(StreamEvent event) {
        if (event == null || event.getEventType() == null) {
           throw new NullPointerException("События не существует");
        }
    }
}
