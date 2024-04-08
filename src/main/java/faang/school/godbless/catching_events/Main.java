package faang.school.godbless.catching_events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<Integer, StreamEvent> EVENTS = new HashMap<>();
    private static final Map<String, List<StreamEvent>> SORTED_EVENTS_BY_TYPE = new HashMap<>();

    public static void main(String[] args) {
        StreamEvent streamEvent1 = new StreamEvent(1, "Press", "The enter button is pressed");
        StreamEvent streamEvent2 = new StreamEvent(2, "Click", "Left mouse click");
        StreamEvent streamEvent3 = new StreamEvent(3, "Scroll", "The mouse wheel is scrolled down");
        StreamEvent streamEvent4 = new StreamEvent(4, "Press", "The F10 button is pressed");
        StreamEvent streamEvent5 = new StreamEvent(5, "Click", "Right mouse click");

        System.out.println(EVENTS);
        System.out.println(SORTED_EVENTS_BY_TYPE);

        System.out.println("---------------------------------------");

        addStreamEvent(streamEvent1);
        addStreamEvent(streamEvent2);
        addStreamEvent(streamEvent3);
        addStreamEvent(streamEvent4);
        addStreamEvent(streamEvent5);

        printAllStreamEvent();

        System.out.println("---------------------------------------");

        System.out.println(EVENTS);
        System.out.println(SORTED_EVENTS_BY_TYPE);
    }

    public static void addStreamEvent(StreamEvent streamEvent) {
        if (EVENTS.containsKey(streamEvent.getId())) {
            throw new IllegalArgumentException("Such an event is already on the list");
        }
        EVENTS.put(streamEvent.getId(), streamEvent);
        SORTED_EVENTS_BY_TYPE.computeIfAbsent(streamEvent.getEventType(), eventType -> new ArrayList<>()).add(streamEvent);

    }

    public static StreamEvent getStreamEventById(int id) {
        if (!EVENTS.containsKey(id)) {
            throw new IllegalArgumentException("There is no such flow event.");
        }
        return EVENTS.get(id);
    }

    public static List<StreamEvent> getListStreamEventByEventType(String eventType) {
        if (!SORTED_EVENTS_BY_TYPE.containsKey(eventType)) {
            throw new IllegalArgumentException("There is no such list of stream events.");
        }
        return SORTED_EVENTS_BY_TYPE.get(eventType);
    }

    public static void removeStreamEventById(int id) {
        if (!EVENTS.containsKey(id)) {
            throw new IllegalArgumentException("There is no such flow event.");
        }
        SORTED_EVENTS_BY_TYPE.get(EVENTS.get(id).getEventType()).remove(EVENTS.get(id));
        EVENTS.remove(id);
    }

    public static void printAllStreamEvent() {
        for (Map.Entry<Integer, StreamEvent> event : EVENTS.entrySet()) {
            StreamEvent streamEvent = event.getValue();
            System.out.println(streamEvent.getId() + ", " + streamEvent.getEventType() + ", " + streamEvent.getData());
        }
    }
}