package faang.school.godbless.catching_events;

import java.util.*;

public class Main {
    private static final Map<Integer, StreamEvent> EVENT = new HashMap<>();
    private static final Map<String, List<StreamEvent>> LIST_EVENT = new HashMap<>();



    public static void main(String[] args) {
        StreamEvent streamEvent1 = new StreamEvent(1, "Press", "The enter button is pressed");
        StreamEvent streamEvent2 = new StreamEvent(2, "Click", "Left mouse click");
        StreamEvent streamEvent3 = new StreamEvent(3, "Scroll", "The mouse wheel is scrolled down");
        StreamEvent streamEvent4 = new StreamEvent(4, "Press", "The F10 button is pressed");
        StreamEvent streamEvent5 = new StreamEvent(5, "Click", "Right mouse click");

        System.out.println(EVENT);
        System.out.println(LIST_EVENT);

        System.out.println("---------------------------------------");

        addStreamEvent(streamEvent1);
        addStreamEvent(streamEvent2);
        addStreamEvent(streamEvent3);
        addStreamEvent(streamEvent4);
        addStreamEvent(streamEvent5);

        System.out.println(getListStreamEventByEventType("Click7"));

        System.out.println("---------------------------------------");

        System.out.println(EVENT);
        System.out.println(LIST_EVENT);
    }

    public static void addStreamEvent(StreamEvent streamEvent) {
        EVENT.put(streamEvent.getId(), streamEvent);
        LIST_EVENT.computeIfAbsent(streamEvent.getEventType(), eventType -> new ArrayList<>()).add(streamEvent);

    }

    public static StreamEvent getStreamEventById(int id) {
        if (!EVENT.containsKey(id)) {
            throw new IllegalArgumentException("There is no such flow event.");
        }
       return EVENT.get(id);
    }

    public static List<StreamEvent> getListStreamEventByEventType(String eventType) {
        if (!LIST_EVENT.containsKey(eventType)) {
            throw new IllegalArgumentException("There is no such list of stream events.");
        }
        return LIST_EVENT.get(eventType);
    }

    public static void removeStreamEventById(int id) {

    }
}
