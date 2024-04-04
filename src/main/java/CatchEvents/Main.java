package CatchEvents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Main {
    private static final Map<Integer, StreamEvent> STREAM_EVENT_MAP = new HashMap<>();
    private static final Map<String, List<StreamEvent>> STRING_LIST_MAP = new HashMap<>();

    public static void main(String[] args) {
        addStreamEvent(new StreamEvent(1, "Message", "First message"));

        System.out.println(searchEventById(1));
        System.out.println();

        addStreamEvent(new StreamEvent(2, "Message", "Second message"));
        addStreamEvent(new StreamEvent(3, "Message", "First alert"));

        System.out.println(searchListOfEventsByType("Message"));
        System.out.println();

        printAllStreamEvents();
        System.out.println();

        removeStreamEventById(2);

        printAllStreamEvents();
    }

    public static void addStreamEvent(StreamEvent streamEvent) {
        STREAM_EVENT_MAP.put(streamEvent.id(), streamEvent);
        if (!STRING_LIST_MAP.containsKey(streamEvent.eventType())) {
            STRING_LIST_MAP.put(streamEvent.eventType(), new ArrayList<>());
        }
        STRING_LIST_MAP.get(streamEvent.eventType()).add(streamEvent);
    }

    public static StreamEvent searchEventById(int id) {
        return STREAM_EVENT_MAP.get(id);
    }

    public static List<StreamEvent> searchListOfEventsByType(String eventType) {
        return STRING_LIST_MAP.get(eventType);
    }

    public static void removeStreamEventById(int id) {
        StreamEvent streamEvent = STREAM_EVENT_MAP.get(id);
        STRING_LIST_MAP.remove(streamEvent.eventType());
        STREAM_EVENT_MAP.remove(id);
    }

    public static void printAllStreamEvents() {
        for (Map.Entry<Integer, StreamEvent> entry : STREAM_EVENT_MAP.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
