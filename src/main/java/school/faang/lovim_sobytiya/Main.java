package school.faang.lovim_sobytiya;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<Integer, StreamEvent> ID_EVENT = new HashMap<>();
    private static final Map<String, List<StreamEvent>> EVENTS_GROUPED_BY_TYPE = new HashMap<>();

    public static void main(String[] args) {
        addStreamEvent(new StreamEvent(1, "meeting", "1-hour-long"));
        addStreamEvent(new StreamEvent(2, "meeting", "3-hour-long"));
        addStreamEvent(new StreamEvent(3, "working", "1-hour-long"));
        printAllStreamEvents();
        lookUpStreamEventById(2);
        lookUpStreamEventsListByType("meeting");
        removeStreamEventById(2);
        printAllStreamEvents();
    }

    public static void addStreamEvent(StreamEvent streamEvent) {
        ID_EVENT.put(streamEvent.getId(), streamEvent);
        EVENTS_GROUPED_BY_TYPE
                .computeIfAbsent(streamEvent.getEventType(), k -> new ArrayList<>())
                .add(streamEvent);
    }

    public static void lookUpStreamEventById(int id) {
        StreamEvent lookedUpStreamEvent = ID_EVENT.get(id);
        System.out.println("Stream event with id: " + id + " is " + lookedUpStreamEvent);
    }

    public static void lookUpStreamEventsListByType(String type) {
        List<StreamEvent> lookedUpListOfStreamEvents = EVENTS_GROUPED_BY_TYPE.get(type);
        System.out.println("Events with type " + type + " are: " + lookedUpListOfStreamEvents);
    }

    public static void removeStreamEventById(int id) {
        StreamEvent eventToRemove = ID_EVENT.remove(id);
        if (eventToRemove != null) {
            String eventType = eventToRemove.getEventType();
            List<StreamEvent> eventList = EVENTS_GROUPED_BY_TYPE.get(eventType);
            eventList.remove(eventToRemove);
            if (eventList.isEmpty()) {
                EVENTS_GROUPED_BY_TYPE.remove(eventType);
            }
        } else {
            System.out.println("No event found with id: " + id);
        }
        System.out.println("The event with id: " + id + " was deleted");
    }

    public static void printAllStreamEvents() {
        System.out.println("List of all the events: ");
        for (Map.Entry<Integer, StreamEvent> event : ID_EVENT.entrySet()) {
            System.out.println(event.getKey() + ":" + event.getValue());
        }
        System.out.println("Here is how EVENTS_GROUP_BY_TYPE looks like:");
        for (Map.Entry<String, List<StreamEvent>> event : EVENTS_GROUPED_BY_TYPE.entrySet()) {
            System.out.println(event.getKey() + ":" + event.getValue());
        }
    }
}