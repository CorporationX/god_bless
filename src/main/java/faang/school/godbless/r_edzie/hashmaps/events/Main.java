package faang.school.godbless.r_edzie.hashmaps.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static final Map<Integer, StreamEvent> EVENTS = new HashMap<>();
    public static final Map<String, List<StreamEvent>> EVENTS_BY_TYPE = new HashMap<>();

    public static void main(String[] args) {
        StreamEvent s1 = new StreamEvent(1, "click", "p1");
        StreamEvent s2 = new StreamEvent(2, "click", "p2");
        StreamEvent s3 = new StreamEvent(3, "hold", "p3");
        StreamEvent s4 = new StreamEvent(4, "hold", "p4");
        StreamEvent s5 = new StreamEvent(5, "hold", "p5");
        StreamEvent s6 = new StreamEvent(6, "hold", "p6");

        add(s1);
        add(s2);
        add(s3);
        add(s4);
        add(s5);
        add(s6);

        remove(s6.getId());

        System.out.println(findById(s1.getId()));

        System.out.println();

        System.out.println(s4.getEventType());

        System.out.println(findByEventType(s4.getEventType()));

        System.out.println();

        printAllEvents();
    }

    public static void add(StreamEvent streamEvent) {
        EVENTS.put(streamEvent.getId(), streamEvent);
        EVENTS_BY_TYPE.computeIfAbsent(streamEvent.getEventType(), k-> new ArrayList<>()).add(streamEvent);
    }

    public static StreamEvent findById(int id) {
        return EVENTS.get(id);
    }

    public static List<StreamEvent> findByEventType(String eventType) {
        return EVENTS_BY_TYPE.get(eventType);
    }

    public static void remove(int id) {
        StreamEvent foundEvent = EVENTS.get(id);

        EVENTS_BY_TYPE.get(foundEvent.getEventType()).remove(foundEvent);
        EVENTS.remove(id);
    }

    public static void printAllEvents() {
        for (Map.Entry<Integer, StreamEvent> entry : EVENTS.entrySet()) {
            System.out.println(entry);
        }
    }
}
