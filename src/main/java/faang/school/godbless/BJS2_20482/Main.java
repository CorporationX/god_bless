package faang.school.godbless.BJS2_20482;

import lombok.Getter;

import java.util.*;

public class Main {
    @Getter
    private static Map<Integer, StreamEvent> streamEventMap = new HashMap<>();
    @Getter
    private static Map<String, List<StreamEvent>> eventListMap = new HashMap<>();

    public static void main(String[] args) {
    }

    public static void addEvent(StreamEvent streamEvent, Map<Integer, StreamEvent> streamEventMap,
                                Map<String, List<StreamEvent>> stringListMap) {
        streamEventMap.put(streamEvent.getId(), streamEvent);
        stringListMap.computeIfAbsent(streamEvent.getEventType(), k -> new ArrayList<>()).add(streamEvent);
    }

    public static StreamEvent getStreamEventById(int id, Map<Integer, StreamEvent> streamEventMap) {
        return streamEventMap.get(id);
    }

    public static List<StreamEvent> getEventByType(String eventType,
                                                   Map<String, List<StreamEvent>> eventListMap) {
        if (eventListMap.containsKey(eventType))
            return eventListMap.get(eventType);

        return Collections.emptyList();
    }

    public static void deleteEventById(int id, Map<Integer, StreamEvent> streamEventMap,
                                       Map<String, List<StreamEvent>> eventListMap) {
        var keyForEventsList = streamEventMap.get(id).getEventType();
        streamEventMap.remove(id);
        eventListMap.remove(keyForEventsList);
    }

    public static void printAllInfo(Map<Integer, StreamEvent> streamEventMap) {
        for (Map.Entry<Integer, StreamEvent> entry : streamEventMap.entrySet()) {
            System.out.println("ID: " + entry.getKey() + " Event: " + entry.getValue().getEventType());
        }
    }


}
