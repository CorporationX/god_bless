package faang.school.godbless.java_hashmap.catch_event;

import java.util.*;

public class Main {

    private static Map<Integer, StreamEvent> eventMap = new HashMap<>();

    private static Map<EventType, List<StreamEvent>> eventTypeListMap = new HashMap<>();


    static {

        StreamEvent event1 = new StreamEvent(EventType.USER_LOGIN, "User login....");
        StreamEvent event2 = new StreamEvent(EventType.USER_LOGIN, "User login....");
        StreamEvent event3 = new StreamEvent(EventType.USER_LOGIN, "User login....");
        StreamEvent event4 = new StreamEvent(EventType.USER_LOGIN, "User login....");
        StreamEvent event5 = new StreamEvent(EventType.USER_LOGOUT, "User logout....");
        StreamEvent event6 = new StreamEvent(EventType.USER_LOGOUT, "User logout....");
        StreamEvent event7 = new StreamEvent(EventType.USER_LOGOUT, "User logout....");
        StreamEvent event8 = new StreamEvent(EventType.USER_LOGOUT, "User logout....");
        StreamEvent event9 = new StreamEvent(EventType.USER_REGIS, "User regis....");
        StreamEvent event10 = new StreamEvent(EventType.USER_REGIS, "User regis....");
        StreamEvent event11 = new StreamEvent(EventType.USER_REGIS, "User regis....");
        StreamEvent event12 = new StreamEvent(EventType.USER_REGIS, "User regis....");
        StreamEvent event13 = new StreamEvent(EventType.USER_PAYMENT, "User payment ....");
        StreamEvent event14 = new StreamEvent(EventType.USER_PAYMENT, "User payment ....");
        StreamEvent event15 = new StreamEvent(EventType.USER_PAYMENT, "User payment ....");
        StreamEvent event16 = new StreamEvent(EventType.USER_PAYMENT, "User payment ....");

        eventMap.put(event1.getId(), event1);
        eventMap.put(event2.getId(), event2);
        eventMap.put(event3.getId(), event3);
        eventMap.put(event4.getId(), event4);
        eventMap.put(event5.getId(), event5);
        eventMap.put(event6.getId(), event6);
        eventMap.put(event7.getId(), event7);
        eventMap.put(event8.getId(), event8);
        eventMap.put(event9.getId(), event9);
        eventMap.put(event10.getId(), event10);
        eventMap.put(event11.getId(), event11);
        eventMap.put(event12.getId(), event12);
        eventMap.put(event13.getId(), event13);
        eventMap.put(event14.getId(), event14);
        eventMap.put(event15.getId(), event15);
        eventMap.put(event16.getId(), event16);

        List<StreamEvent> userLogin = new ArrayList<>(List.of(event1, event2, event3, event4));
        List<StreamEvent> userLogout = new ArrayList<>(List.of(event5, event6, event7, event8));
        List<StreamEvent> userRegis = new ArrayList<>(List.of(event9, event10, event11, event12));
        List<StreamEvent> dataUpdate = new ArrayList<>(List.of(event13, event14, event15, event16));


        eventTypeListMap.put(EventType.USER_LOGIN, userLogin);
        eventTypeListMap.put(EventType.USER_LOGOUT, userLogout);
        eventTypeListMap.put(EventType.USER_REGIS, userRegis);
        eventTypeListMap.put(EventType.USER_PAYMENT, dataUpdate);

    }

    public static void main(String[] args) {
        addStreamEvent(new StreamEvent(EventType.USER_PAYMENT, "User payment...."));
        getStreamEvent(323);
        deleteStreamEvent(3);
        printAll();
    }


    static void addStreamEvent(StreamEvent streamEvent) {
        if (streamEvent == null) throw new IllegalArgumentException("args is null");
        if (eventMap.put(streamEvent.getId(), streamEvent) == null && eventTypeListMap.get(streamEvent.getEventType()).add(streamEvent)) {
            System.out.println("Success add new Event");
        } else {
            System.out.println("Error......");
        }
    }

    static StreamEvent getStreamEvent(int id) {
        if (id < 0) throw new IllegalArgumentException("args is null");
        StreamEvent streamEvent = eventMap.get(id);
        if (streamEvent == null) {
            throw new StreamEventException("StreamEvent not found");
        }
        return streamEvent;
    }


    static List<StreamEvent> getStreamEventList(EventType eventType) {
        if (eventType == null) throw new IllegalArgumentException("args is null");

        List<StreamEvent> streamEventList = eventTypeListMap.get(eventType);

        if (streamEventList == null) {
            throw new StreamEventException("StreamEventList not found");
        }
        return streamEventList;
    }


    static void deleteStreamEvent(int id) {
        if (id < 0) throw new IllegalArgumentException("args is null");
        StreamEvent streamEvent = eventMap.remove(id);
        if (streamEvent == null) {
            System.out.println("not found");
        } else {
            eventTypeListMap.get(streamEvent.getEventType()).remove(streamEvent);
            System.out.println("Successfully delete");
        }
    }

    static void printAll() {
        for (Map.Entry<Integer, StreamEvent> entry : eventMap.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

}
