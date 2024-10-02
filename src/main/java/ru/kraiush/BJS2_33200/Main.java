package ru.kraiush.BJS2_33200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<Integer, StreamEvent> STREAM_EVENTS = new HashMap<>();
    private static final Map<String, List<StreamEvent>> GROUPED_STREAM_EVENTS_BY_EVENT_TYPE = new HashMap<>();

    private static void addStreamEvent(StreamEvent streamEvent) {
        STREAM_EVENTS.put(streamEvent.getId(), streamEvent);
        GROUPED_STREAM_EVENTS_BY_EVENT_TYPE.computeIfAbsent(streamEvent.getEventType(), k -> new ArrayList<>()).add(streamEvent);
    }

    public static StreamEvent findStreamEventById(int id) {
        return STREAM_EVENTS.get(id);
    }

    public static void deleteStreamEventById(int id) {
        StreamEvent streamEvent = STREAM_EVENTS.remove(id);
        GROUPED_STREAM_EVENTS_BY_EVENT_TYPE.get(streamEvent.getEventType()).remove(streamEvent);
    }

    public static void getAllStreamEventsInfo() {
        for (Map.Entry<Integer, StreamEvent> entry: STREAM_EVENTS.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public static void main(String[] args) {
        StreamEvent streamEvent1 = new StreamEvent(1, "USER_LOGIN", "User 123 has logged in");
        StreamEvent streamEvent2 = new StreamEvent(2, "USER_LOGOUT", "User 123 has logged out");
        StreamEvent streamEvent3 = new StreamEvent(3, "DATA_UPDATE", "Data item 456 updated");
        StreamEvent streamEvent4 = new StreamEvent(4, "USER_LOGIN", "User 321 has logged in");
        StreamEvent streamEvent5 = new StreamEvent(5, "USER_LOGOUT", "User 321 has logged out");
        StreamEvent streamEvent6 = new StreamEvent(6, "USER_LOGIN", "User 234 has logged in");
        StreamEvent streamEvent7 = new StreamEvent(7, "USER_LOGOUT", "User 234 has logged out");
        StreamEvent streamEvent8 = new StreamEvent(8, "DATA_UPDATE", "Data item 567 updated");

        addStreamEvent(streamEvent1);
        addStreamEvent(streamEvent2);
        addStreamEvent(streamEvent3);
        addStreamEvent(streamEvent4);
        addStreamEvent(streamEvent5);
        addStreamEvent(streamEvent6);
        addStreamEvent(streamEvent7);
        addStreamEvent(streamEvent8);

        System.out.println(findStreamEventById(4));

        deleteStreamEventById(5);

        getAllStreamEventsInfo();
    }
}
