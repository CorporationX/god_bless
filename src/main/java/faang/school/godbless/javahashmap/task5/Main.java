package faang.school.godbless.javahashmap.task5;

import java.util.*;

public class Main {

    private static final Map<Integer, StreamEvent> intEventMap = new HashMap<>();
    private static final Map<String, List<StreamEvent>> strEventsMap = new HashMap<>();

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
        if (strEventsMap.containsKey(streamEvent.getEventType())) {
            strEventsMap.get(streamEvent.getEventType()).add(streamEvent);
        } else {
            strEventsMap.put(streamEvent.getEventType(), new ArrayList<>(Arrays.asList(streamEvent)));
        }
        return intEventMap.put(streamEvent.getId(), streamEvent);
    }

    public static StreamEvent findStreamEventById(Integer id) {
        if (intEventMap.containsKey(id)) {
            return intEventMap.get(id);
        }
        return null;
    }

    public static List<StreamEvent> findStreamEventsByType(String eventType) {
        if (strEventsMap.containsKey(eventType)) {
            return strEventsMap.get(eventType);
        }
        return null;
    }

    public static StreamEvent removeStreamEventById(Integer id) {
        if (intEventMap.containsKey(id)) {
            StreamEvent streamEvent = intEventMap.get(id);
            List<StreamEvent> streamEvents = strEventsMap.get(streamEvent.getEventType());
            Iterator<StreamEvent> iterator = streamEvents.iterator();
            while (iterator.hasNext()) {
                StreamEvent currentEvent = iterator.next();
                if (currentEvent.equals(streamEvent)) {
                    iterator.remove();
                    break;
                }
            }
            return intEventMap.remove(id);
        }
        return null;
    }

    public static void printAllStreamEvents() {
        for (Map.Entry<Integer, StreamEvent> entry : intEventMap.entrySet()) {
            System.out.println("ID: " + entry.getKey() + " " + entry.getValue());
        }
    }

    public static void printAllStreamEventByType() {
        for (Map.Entry<String, List<StreamEvent>> entry : strEventsMap.entrySet()) {
            System.out.println("Type " + entry.getKey());
            entry.getValue().forEach(System.out::println);
        }
    }
}
