package faang.school.godbless.catcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static faang.school.godbless.catcher.Main.streamEventIdMap;
import static faang.school.godbless.catcher.Main.streamEventTypeMap;

public class StreamEventService {

    public static void addStreamEventAndUpdateMaps(StreamEvent streamEvent) {
        streamEventIdMap.put(streamEvent.getId(), streamEvent);

        List<StreamEvent> streamEventList = streamEventTypeMap.get(streamEvent.getEventType());
        if (streamEventList == null) {
            streamEventList = new ArrayList<>();
        }
        streamEventList.add(streamEvent);
        if (!streamEventTypeMap.containsKey(streamEvent.getEventType())) {
            streamEventTypeMap.put(streamEvent.getEventType(), streamEventList);
        }
    }

    public static StreamEvent findStreamEventById(int id) {
        return streamEventIdMap.get(id);
    }

    public static List<StreamEvent> findStreamEventByEventType(String eventType) {
        return streamEventTypeMap.get(eventType);
    }

    public static void removeStreamEventAndUpdateMaps(int id) {
        streamEventIdMap.remove(id);

        String streamEventForDelete = streamEventTypeMap.entrySet().stream()
                .filter(e -> e.getValue().stream().anyMatch(s -> s.getId() == id))
                .findFirst().map(Map.Entry::getKey).orElse(null);

        streamEventTypeMap.remove(streamEventForDelete);
    }

    public static void printStreamEventById() {
        streamEventIdMap.forEach((k, v) -> {
            System.out.println("Id = " + k);
            System.out.println("StreamEvent =" + v);
        });
    }

    public static void printStreamEventByEventType() {
        streamEventTypeMap.forEach((k, v) -> {
            System.out.println("Event type = " + k);
            System.out.println("StreamEvents = " + v);
        });
    }
}
