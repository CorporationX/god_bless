package school.faang.catchingevents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    private static final Map<Integer, StreamEvent> streamEventsById = new HashMap<>();
    private static final Map<String, List<StreamEvent>> streamEventsByEventTypes = new HashMap<>();

    public static void addStreamEvent(StreamEvent streamEvent) {
        streamEventsById.put(streamEvent.getId(), streamEvent);
        streamEventsByEventTypes.computeIfAbsent(streamEvent.getEventType(), k -> new ArrayList<>()).add(streamEvent);
    }

    public static Optional<StreamEvent> getStreamEventById(int id) {
        return Optional.ofNullable(streamEventsById.get(id));
    }

    public static List<StreamEvent> getStreamEventsByEventType(String eventType) {
        return streamEventsByEventTypes.getOrDefault(eventType, List.of());
    }

    public static void removeStreamEvent(int id) {
        StreamEvent removed = streamEventsById.remove(id);
        if (removed == null) {
            return;
        }
        streamEventsByEventTypes.computeIfPresent(
                removed.getEventType(),
                (k, v) -> {
                    v.remove(removed);
                    return v;
                }
        );
    }

    public static String getStreamEventsInfo() {
        return streamEventsById.entrySet().stream()
                .map(Object::toString)
                .collect(Collectors.joining("\n"));
    }
}
