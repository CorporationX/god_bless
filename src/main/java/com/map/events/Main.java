package com.map.events;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static final Map<Integer, StreamEvent> STREAM_EVENT_MAP = new HashMap<>();
    private static final Map<String, List<StreamEvent>> MAP_EVENTS_BY_TYPE = new HashMap<>();

    public static void main(String[] args) {
        try {
            StreamEvent streamEvent1 = new StreamEvent(1, "pop", "spb");
            StreamEvent streamEvent2 = new StreamEvent(2, "pop", "spb");
            StreamEvent streamEvent3 = new StreamEvent(3, "rock", "Moscow");
            addEvent(streamEvent1);
            addEvent(streamEvent2);
            addEvent(streamEvent3);

        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }

        System.out.println(STREAM_EVENT_MAP);
        System.out.println(MAP_EVENTS_BY_TYPE);

        deleteEvent(1);
        System.out.println();

        System.out.println(STREAM_EVENT_MAP);
        System.out.println(MAP_EVENTS_BY_TYPE);
        System.out.println();

        System.out.println(getEventsByType("pop"));
        System.out.println();

        System.out.println(getEventById(3));
    }

    public static void addEvent(StreamEvent streamEvent) {
        if (streamEvent != null) {
            STREAM_EVENT_MAP.put(streamEvent.getId(), streamEvent);
            MAP_EVENTS_BY_TYPE.computeIfAbsent(streamEvent
                    .getEventType(), k -> new ArrayList<>()).add(streamEvent);

        }
    }
    public static StreamEvent getEventById(int id) {
        if (id > 0) {
            return STREAM_EVENT_MAP.get(id);
        }
        return null;
    }

    public static List<StreamEvent> getEventsByType(String type) {
        List<StreamEvent> streamEventList = new ArrayList<>();
        if (!type.isEmpty()) {
            streamEventList = MAP_EVENTS_BY_TYPE.entrySet()
                    .stream()
                    .filter(k -> k.getKey().equals(type))
                    .map(Map.Entry::getValue)
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());
        }
        return streamEventList;
    }

    public static void deleteEvent (int id){
        STREAM_EVENT_MAP.remove(id);
        MAP_EVENTS_BY_TYPE.values()
                .forEach(events -> events.removeIf(event -> event.getId() ==id));
    }


}
