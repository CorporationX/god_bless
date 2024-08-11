package faang.school.godbless.BJS2_20482;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    @Getter
    private static Map<Integer, StreamEvent> streamEventMap = new HashMap<>();
    @Getter
    private static Map<String, List<StreamEvent>> eventListMap = new HashMap<>();

    public static void main(String[] args) {
    }

    public static void addStreamEventAndRenewMaps(StreamEvent streamEvent, Map<Integer, StreamEvent> streamEventMap,
                                                  Map<String, List<StreamEvent>> stringListMap) {
        streamEventMap.put(streamEvent.getId(), streamEvent);
        stringListMap.computeIfAbsent(streamEvent.getEventType(), k -> new ArrayList<>()).add(streamEvent);
    }

    public static StreamEvent getStreamEventById(int id, Map<Integer, StreamEvent> streamEventMap) {
        return streamEventMap.get(id);
    }

    public static List<StreamEvent> getStreamEventsByEventType(String eventType,
                                                               Map<String, List<StreamEvent>> eventListMap) {
        return eventListMap.get(eventType);
    }

    public static void deleteStreamEventById(int id, Map<Integer, StreamEvent> streamEventMap,
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
