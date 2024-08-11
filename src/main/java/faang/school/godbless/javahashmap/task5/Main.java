package faang.school.godbless.javahashmap.task5;

import java.util.*;

public class Main {

    private static final Map<Integer, StreamEvent> INT_EVENT_MAP = new HashMap<>();
    private static final Map<String, List<StreamEvent>> STR_EVENTS_MAP = new HashMap<>();

    public static void main(String[] args) {
        addStreamEvent(new StreamEvent(1, "Review", "vJxOtzUiiAI"));
        addStreamEvent(new StreamEvent(2, "Updated", "q2wizly"));
        addStreamEvent(new StreamEvent(3, "Checkout", "HRtajGWDMa4"));
        addStreamEvent(new StreamEvent(4, "Review", "d6C0K39x"));
        addStreamEvent(new StreamEvent(5, "Checkout", "0MVBLdqy"));
        addStreamEvent(new StreamEvent(6, "Updated", "WFi91s8OhL"));
        addStreamEvent(new StreamEvent(7, "Review", "YBANDu90lu"));
        addStreamEvent(new StreamEvent(8, "Checkout", "TqfM9wIPVi"));
        addStreamEvent(new StreamEvent(9, "Updated", "8SSWVoUGjF"));
        addStreamEvent(new StreamEvent(10, "Checkout", "ekeuF5V"));

        printAllStreamEvents();
        System.out.println();
        printAllStreamEventByType();
        System.out.println();

        System.out.println(findStreamEventById(9));
        System.out.println();

        System.out.println(findStreamEventsByType("Review"));
        System.out.println();

        removeStreamEventById(10);
        removeStreamEventById(9);
        removeStreamEventById(8);
        removeStreamEventById(7);
        removeStreamEventById(5);
        printAllStreamEventByType();
        System.out.println();
        printAllStreamEvents();
    }

    public static StreamEvent addStreamEvent(StreamEvent streamEvent) {
        if (STR_EVENTS_MAP.containsKey(streamEvent.getEventType())) {
            STR_EVENTS_MAP.get(streamEvent.getEventType()).add(streamEvent);
        } else {
            STR_EVENTS_MAP.put(streamEvent.getEventType(), new ArrayList<>(Arrays.asList(streamEvent)));
        }
        return INT_EVENT_MAP.put(streamEvent.getId(), streamEvent);
    }

    public static StreamEvent findStreamEventById(Integer id) {
        return INT_EVENT_MAP.get(id);
    }

    public static List<StreamEvent> findStreamEventsByType(String eventType) {
        return STR_EVENTS_MAP.get(eventType);
    }

    public static StreamEvent removeStreamEventById(Integer id) {
        StreamEvent streamEvent = INT_EVENT_MAP.get(id);
        List<StreamEvent> streamEvents = STR_EVENTS_MAP.get(streamEvent.getEventType());
        Iterator<StreamEvent> iterator = streamEvents.iterator();
        while (iterator.hasNext()) {
            StreamEvent currentEvent = iterator.next();
            if (currentEvent.equals(streamEvent)) {
                iterator.remove();
                break;
            }
        }
        return INT_EVENT_MAP.remove(id);
    }

    public static void printAllStreamEvents() {
        for (Map.Entry<Integer, StreamEvent> entry : INT_EVENT_MAP.entrySet()) {
            System.out.println("ID: " + entry.getKey() + " " + entry.getValue());
        }
    }

    public static void printAllStreamEventByType() {
        for (Map.Entry<String, List<StreamEvent>> entry : STR_EVENTS_MAP.entrySet()) {
            System.out.println("Type " + entry.getKey());
            entry.getValue().forEach(System.out::println);
        }
    }
}
