package faang.school.godbless.BJS2_20455;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<Integer, StreamEvent> STREAM_EVENTS = new HashMap<>();
    private static final Map<String, List<StreamEvent>> GROUPED_STREAM_EVENTS = new HashMap<>();
    private static final Map<Integer, Integer> INDEXES = new HashMap<>();

    public static void main(String[] args) {
        addStreamEvent(new StreamEvent(1, "click", "User clicked on button A"));
        addStreamEvent(new StreamEvent(2, "scroll", "User scrolled down"));
        addStreamEvent(new StreamEvent(3, "hover", "User hovered over image B"));
        addStreamEvent(new StreamEvent(4, "click", "User clicked on button B"));
        System.out.println(findStreamEventById(3));
        System.out.println("Event type 'click':");
        for (StreamEvent streamEvent : findStreamEventsByEventType("click")) {
            System.out.println(streamEvent);
        }
        deleteStreamEventById(1);
        printAllStreamEvents();
    }

    private static void addStreamEvent(StreamEvent streamEvent) {
        STREAM_EVENTS.put(streamEvent.getId(), streamEvent);
        GROUPED_STREAM_EVENTS.computeIfAbsent(streamEvent.getEventType(),
                event -> new ArrayList<>()).add(streamEvent);
        int position = GROUPED_STREAM_EVENTS.get(streamEvent.getEventType()).size() - 1;
        INDEXES.put(streamEvent.getId(), position);
    }

    private static StreamEvent findStreamEventById(int id) {
        return STREAM_EVENTS.get(id);
    }

    private static List<StreamEvent> findStreamEventsByEventType(String eventType) {
        return GROUPED_STREAM_EVENTS.get(eventType);
    }

    private static void deleteStreamEventById(int id) {
        StreamEvent streamEvent = STREAM_EVENTS.remove(id);
        if (streamEvent != null) {
            List<StreamEvent> streamEvents = findStreamEventsByEventType(streamEvent.getEventType());
            if (streamEvents != null) {
                int index = INDEXES.remove(id);
                streamEvents.remove(index);
            }
        }
    }

    private static void printAllStreamEvents() {
        for (var event : STREAM_EVENTS.entrySet()) {
            StreamEvent streamEvent = event.getValue();
            System.out.println("id: " + streamEvent.getId() + ", eventType: " + streamEvent.getEventType() + ", data: "
                    + streamEvent.getData());
        }
    }
}
