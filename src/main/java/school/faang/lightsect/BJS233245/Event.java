package school.faang.lightsect.BJS233245;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Event {
    static final Map<Integer, StreamEvent> STREAM_EVENT = new HashMap<>();
    static final Map<String, List<StreamEvent>> LIST_OF_EVENT_WITH_TYPE = new HashMap<>();

    void addEvent(StreamEvent newEvent) {
        STREAM_EVENT.put(newEvent.getId(), newEvent);
        LIST_OF_EVENT_WITH_TYPE.computeIfAbsent(newEvent.getEventType(), key -> new ArrayList<>()).add(newEvent);
    }

    StreamEvent getEventById(int id) {
        return STREAM_EVENT.get(id);
    }

    List<StreamEvent> searchStreamEvenByType(String type) {
        return LIST_OF_EVENT_WITH_TYPE.get(type);
    }

    void deleteStreamById(int id) {
        StreamEvent event = STREAM_EVENT.remove(id);
        if (event != null) {
            LIST_OF_EVENT_WITH_TYPE.get(event.getEventType()).removeIf(e -> e.getId() == id);
        }

        STREAM_EVENT.remove(id);
    }

    void printAllEvents() {
        STREAM_EVENT.forEach((key, value) -> System.out.printf("id: %d, type: %s, data: %s\n",
                key, value.getEventType(), value.getData()));
    }

}
