package school.faang.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<Integer, StreamEvent> listEvents = new HashMap<>();
    private static final Map<String, List<StreamEvent >> typesOfEvents = new HashMap<>();

    public static void main(String[] args) {
        StreamEvent streamEvent = new StreamEvent(1, "ErrorsArgs", "Error in arguments");
        StreamEvent streamEventTwo = new StreamEvent(2, "ErrorsArgs", "Error in arguments and git");
        addEvent(streamEvent);
        addEvent(streamEventTwo);
        removeEventInLists(2);
        showTypesOfEvents();
    }

    public static void addEvent(StreamEvent streamEvent) {
        int id = streamEvent.id();
        String eventType = streamEvent.eventType();
        listEvents.put(id, streamEvent);
        typesOfEvents.computeIfAbsent(eventType, k -> new ArrayList<>()).add(streamEvent);
    }

    public static StreamEvent searchEventInListEvents(StreamEvent event) {
        int id = event.id();
        return listEvents.get(id);
    }

    public static List<StreamEvent> searchEventInTypesOfEvents(StreamEvent event) {
        String type = event.eventType();
        return typesOfEvents.get(type);
    }

    public static void removeEventInLists(int id) {
        StreamEvent event = listEvents.remove(id);
        for (List<StreamEvent> entry : typesOfEvents.values()) {
            entry.remove(event);
        }
    }

    public static void showTypesOfEvents() {
        for (Map.Entry<String, List<StreamEvent>> entry : typesOfEvents.entrySet()) {
            List<StreamEvent> events = entry.getValue();
            for (StreamEvent streamEvent : events) {
                System.out.println("ID события: " + streamEvent.id() + "\nтип события: "
                    + streamEvent.eventType() + "\nданные события: " + streamEvent.data());
            }
        }
    }
}
