package school.faang;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static school.faang.StreamEventService.addStreamEvent;
import static school.faang.StreamEventService.removeById;
import static school.faang.StreamEventService.searchStreamEventById;
import static school.faang.StreamEventService.searchStreamEventsByType;
import static school.faang.StreamEventService.viewAllStreamEvents;

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
        viewAllStreamEvents(eventStreamsMap);
        removeById(2, idStreamEventMap, eventStreamsMap);
        searchStreamEventById(3, idStreamEventMap);
        searchStreamEventsByType("stream1", eventStreamsMap);
        viewAllStreamEvents(eventStreamsMap);
    }

}
