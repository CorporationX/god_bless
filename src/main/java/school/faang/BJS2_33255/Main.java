package school.faang.BJS2_33255;

import java.util.*;

public class Main {
    private static final Map<Integer, StreamEvent> EVENT_BY_ID = new HashMap<>();
    private static final Map<String, List<StreamEvent>> EVENT_BY_TYPE = new HashMap<>();

    public static void addNewEvent(StreamEvent streamEvent) {
        EVENT_BY_ID.put(streamEvent.getId(), streamEvent);
        EVENT_BY_TYPE.computeIfAbsent(streamEvent.getEventType(), k -> new ArrayList<>()).add(streamEvent);
    }

    public static StreamEvent getEventById(int id) {
        return EVENT_BY_ID.get(id);
    }

    public static List<StreamEvent> getEventsListByEventType(String eventType) {
        return EVENT_BY_TYPE.get(eventType);
    }

    public static void deleteEventById(int id) {
        StreamEvent streamEvent = getEventById(id);

        EVENT_BY_ID.remove(id);
        EVENT_BY_TYPE.remove(streamEvent.getEventType());
    }

    public static void printEvent() {
        for (Map.Entry<Integer, StreamEvent> entry : EVENT_BY_ID.entrySet()) {
            System.out.println("ID: " + entry.getKey() + "  event type : " + entry.getValue().getEventType()
                    + "  data: " + entry.getValue().getData());
        }
    }

    public static void printEvent(StreamEvent streamEvent) {
        System.out.println("ID: " + streamEvent.getId() + "  streamEvent type : " + streamEvent.getEventType()
                + "  data: " + streamEvent.getData());
    }

    public static void printEvent(List<StreamEvent> streamEvents) {
        for (StreamEvent streamEvent : streamEvents) {
            System.out.println("ID: " + streamEvent.getId() + "  streamEvent type : " + streamEvent.getEventType()
                    + "  data: " + streamEvent.getData());
        }
    }

    public static void main(String[] args) {
        StreamEvent event1 = new StreamEvent(1, "TypeA", "Data Type A Event 1");
        StreamEvent event2 = new StreamEvent(2, "TypeB", "Data Type A Event 2");
        StreamEvent event3 = new StreamEvent(3, "TypeA", "Data Type A Event 3");
        StreamEvent event4 = new StreamEvent(4, "TypeB", "Data Type A Event 4");

        //добавляем события
        addNewEvent(event1);
        addNewEvent(event2);
        addNewEvent(event3);
        addNewEvent(event4);

        //выводим список всех событий
        printEvent();

        //находим событие по id
        System.out.println();
        printEvent(getEventById(3));

        //находим события по типу
        System.out.println();
        printEvent(getEventsListByEventType("TypeA"));

        //удаляем событие
        deleteEventById(3);

        //выводим список оставшихся событий
        System.out.println();
        printEvent();
    }
}
