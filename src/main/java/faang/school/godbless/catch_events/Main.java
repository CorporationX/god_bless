package faang.school.godbless.catch_events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final Map<Integer, StreamEvent> STREAM_EVENT_MAP = new HashMap<>();
    private static final Map<String, List<StreamEvent>> STREAM_LIST_EVENT_MAP = new HashMap<>();

    public static void main(String[] args) {
        addNewEvent(new StreamEvent("message", "information"));
        addNewEvent(new StreamEvent("message", "new info"));
        addNewEvent(new StreamEvent("call", "quickly"));

        System.out.println(findById(2));

        System.out.println();

        System.out.println(findAllByEventType("message"));

        System.out.println();

        deleteById(1);

        printInfoAboutAllStreamEvent();
    }

    public static void addNewEvent(StreamEvent event) {
        STREAM_EVENT_MAP.put(event.getId(), event);
        if (!STREAM_LIST_EVENT_MAP.containsKey(event.getEventType())) {
            STREAM_LIST_EVENT_MAP.put(event.getEventType(), new ArrayList<>());
        }
        STREAM_LIST_EVENT_MAP.get(event.getEventType()).add(event);
    }

    public static StreamEvent findById(int id) {
        return STREAM_EVENT_MAP.get(id);
    }

    public static List<StreamEvent> findAllByEventType(String eventType) {
        return STREAM_LIST_EVENT_MAP.get(eventType);
    }

    public static void deleteById(int id) {
        StreamEvent removedStreamEvent = STREAM_EVENT_MAP.remove(id);
        List<StreamEvent> streamEventList = STREAM_LIST_EVENT_MAP.get(removedStreamEvent.getEventType());
        for (int i = 0; i < streamEventList.size(); i++) {
            if (streamEventList.get(i).equals(removedStreamEvent)) {
                streamEventList.remove(i);
                break;
            }
        }
    }

    public static void printInfoAboutAllStreamEvent() {
        STREAM_EVENT_MAP.forEach((k, v) -> System.out.println(v));
    }
}