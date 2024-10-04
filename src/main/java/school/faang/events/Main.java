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
        int id = streamEvent.getId();
        String eventType = streamEvent.getEventType();
        listEvents.put(id, streamEvent);
        typesOfEvents.computeIfAbsent(eventType, k -> new ArrayList<>()).add(streamEvent);
    }
    public static StreamEvent searchEventInListEvents(StreamEvent event) {
        int id = event.getId();
        return listEvents.get(id);
    }
    public static List<StreamEvent> searchEventInTypesOfEvents(StreamEvent event) {
        String type = event.getEventType();
        return typesOfEvents.get(type);
    }
    public static void removeEventInLists(int id) {
        StreamEvent event = listEvents.remove(id);
        for (Map.Entry<String, List<StreamEvent>> entry : typesOfEvents.entrySet()) {
            List<StreamEvent> streamEvents = entry.getValue();
            streamEvents.removeIf(streamEvent -> streamEvent.equals(event));
        }
    }
    public static void showTypesOfEvents() {
        for (Map.Entry<String, List<StreamEvent>> entry : typesOfEvents.entrySet()) {
            List<StreamEvent> events = entry.getValue();
            for (StreamEvent streamEvent : events) {
                System.out.println("ID события: " + streamEvent.getId() + "\nтип события: "
                    + streamEvent.getEventType() + "\nданные события: " + streamEvent.getData());
            }
        }
    }
}
