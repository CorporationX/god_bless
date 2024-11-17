package faang.school.godbless.java_sql.task_5;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class StreamEventUtils {
    static HashMap<Integer, StreamEvent> getStreamEventsById(List<StreamEvent> streamEvents) {
        HashMap<Integer, StreamEvent> streamEventsById = new HashMap<>();
        streamEvents.forEach(streamEvent -> {
            streamEventsById.put(streamEvent.id(), streamEvent);
        });
        return streamEventsById;
    }

    static HashMap<String, List<StreamEvent>> getStreamEventsGroupedByEventTypes(List<StreamEvent> streamEvents) {
        return (HashMap<String, List<StreamEvent>>) streamEvents.stream().collect(Collectors.groupingBy(StreamEvent::eventType));
    }

    static void printStreamEvents(HashMap<String, List<StreamEvent>> streamEventMap) {
        streamEventMap.values().forEach(streamEvents -> streamEvents.forEach(System.out::println));
    }
}
