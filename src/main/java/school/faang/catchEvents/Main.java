package school.faang.catchEvents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final HashMap<Integer, StreamEvent> eventsById = new HashMap<>();
    private static final HashMap<String, List<StreamEvent>> eventsByType = new HashMap<>();

    public static void addNewStreamEvent(StreamEvent streamEvent) {
        eventsById.put(streamEvent.getId(), streamEvent);
        eventsByType.computeIfAbsent(streamEvent.getEventType(), key -> new ArrayList<>()).add(streamEvent);
    }

    public static void findEventById(Integer id) {
        if (eventsById.containsKey(id)) {
            System.out.println(eventsById.get(id));
        } else {
            System.out.println("Event not found");
        }
    }

    public static void findEventsListByType(String eventType) {
        if (eventsByType.containsKey(eventType)) {
            System.out.println(eventsByType.get(eventType));
        } else {
            System.out.println("Not found");
        }
    }

    public static void deleteEventsById(Integer id) {
        if (eventsById.containsKey(id)) {
            StreamEvent event = eventsById.get(id);
            eventsById.remove(id);
            List<StreamEvent> streamEvents = eventsByType.get(event.getEventType());
            streamEvents.remove(event);
            if (streamEvents.isEmpty()) {
                eventsByType.remove(event.getEventType());
            }
        }
    }

    public static void printInfo() {
        for (Map.Entry<Integer, StreamEvent> entry : eventsById.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public static void main(String[] args) {
        StreamEvent streamEvent1 = new StreamEvent(1, "dancing", "Lol");
        StreamEvent streamEvent2 = new StreamEvent(2, "chess", "Lol");
        StreamEvent streamEvent3 = new StreamEvent(3, "game", "Lol");
        StreamEvent streamEvent4 = new StreamEvent(4, "trolling", "Lol");

        addNewStreamEvent(streamEvent1);
        addNewStreamEvent(streamEvent2);
        addNewStreamEvent(streamEvent3);
        addNewStreamEvent(streamEvent4);
        System.out.println();

        findEventById(2);
        findEventsListByType("game");
        printInfo();

        System.out.println();
        deleteEventsById(1);
        printInfo();

    }
}
