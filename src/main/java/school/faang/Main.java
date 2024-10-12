package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Main {

    private static Map<Integer, StreamEvent> idStreamEventMap = new HashMap<>();
    private static Map<String, List<StreamEvent>> eventStreamsMap = new HashMap<>();


    public static void main(String[] args) {
        StreamEvent streamEvent1 = new StreamEvent(1, "stream1", "boom");
        StreamEvent streamEvent2 = new StreamEvent(2, "stream1", "boom2");
        StreamEvent streamEvent3 = new StreamEvent(3, "stream2", "run");
        addStreamEvent(streamEvent1, idStreamEventMap, eventStreamsMap);
        addStreamEvent(streamEvent2, idStreamEventMap, eventStreamsMap);
        addStreamEvent(streamEvent3, idStreamEventMap, eventStreamsMap);
        removeById(2, idStreamEventMap, eventStreamsMap);
        searchStreamEventById(3, idStreamEventMap);
        searchStreamEventsByType("stream1", eventStreamsMap);
        viewAllStreamEvents(eventStreamsMap);

    }

    private static void addStreamEvent(StreamEvent streamEvent,
                                       Map<Integer, StreamEvent> idStreamEventMap,
                                       Map<String, List<StreamEvent>> eventStreamsMap) {
        idStreamEventMap.put(streamEvent.getId(), streamEvent);
        if (!eventStreamsMap.containsKey(streamEvent.getEventType())) {
            eventStreamsMap.put(streamEvent.getEventType(), new ArrayList<>());
            List<StreamEvent> streamEventList = new ArrayList<>();
            streamEventList.add(streamEvent);
            eventStreamsMap.put(streamEvent.getEventType(), streamEventList);
        } else {
            List<StreamEvent> streamEventList = eventStreamsMap.get(streamEvent.getEventType());
            streamEventList.add(streamEvent);
            eventStreamsMap.put(streamEvent.getEventType(), streamEventList);
        }

    }

    private static void searchStreamEventById(int id, Map<Integer, StreamEvent> idStreamEventMap) {
        StreamEvent streamEvent = idStreamEventMap.get(id);
        System.out.println(streamEvent);
    }

    private static void searchStreamEventsByType(String eventType, Map<String, List<StreamEvent>> eventStreamsMap) {
        List<StreamEvent> streamEventList = eventStreamsMap.get(eventType);
        System.out.println(streamEventList.toString());
    }

    private static void removeById(int id, Map<Integer, StreamEvent> idStreamEventMap,
                                   Map<String, List<StreamEvent>> eventStreamsMap) {
        idStreamEventMap.remove(id);
        for (Map.Entry<String, List<StreamEvent>> pair : eventStreamsMap.entrySet()) {
            List<StreamEvent> streamEventList = pair.getValue();
            Iterator<StreamEvent> iterator = streamEventList.iterator();

            while (iterator.hasNext()) {
                StreamEvent streamEvent = iterator.next();

                if (streamEvent.getId() == id) {
                    iterator.remove();
                }
            }
        }
    }

    private static void viewAllStreamEvents(Map<String, List<StreamEvent>> eventStreamsMap) {
        for (Map.Entry<String, List<StreamEvent>> pair : eventStreamsMap.entrySet()) {
            System.out.println("Group " + pair.getKey() + ": " + pair.getValue().toString());
        }
    }
}
