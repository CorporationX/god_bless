package school.faang;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class StreamEventService {
    public static void addStreamEvent(StreamEvent streamEvent,
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

    public static void searchStreamEventById(int id, Map<Integer, StreamEvent> idStreamEventMap) {
        StreamEvent streamEvent = idStreamEventMap.get(id);
        System.out.println(streamEvent);
    }

    public static void searchStreamEventsByType(String eventType, Map<String, List<StreamEvent>> eventStreamsMap) {
        List<StreamEvent> streamEventList = eventStreamsMap.get(eventType);
        System.out.println(streamEventList.toString());
    }

    public static void removeById(int id, Map<Integer, StreamEvent> idStreamEventMap,
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

    public static void viewAllStreamEvents(Map<String, List<StreamEvent>> eventStreamsMap) {
        for (Map.Entry<String, List<StreamEvent>> pair : eventStreamsMap.entrySet()) {
            System.out.println("Group " + pair.getKey() + ": " + pair.getValue().toString());
        }
    }
}
