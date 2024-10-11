package school.faang.catchEvents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final HashMap<Integer, StreamEvent> EVENTS = new HashMap<>();
    private static final HashMap<String, List<StreamEvent>> SIMILAR_EVENTS = new HashMap<>();

    public static void addNewStreamEvent(StreamEvent streamEvent) {
        EVENTS.put(streamEvent.getId(), streamEvent);
        SIMILAR_EVENTS.computeIfAbsent(streamEvent.getEventType(), key -> new ArrayList<>()).add(streamEvent);
    }

    public static void findEventById(Integer id) {
        if (EVENTS.containsKey(id)) {
            System.out.println(EVENTS.get(id));
        } else {
            throw new IllegalArgumentException("Event not found");
        }
    }

    public static void findEventsListByType(String eventType) {
        if (SIMILAR_EVENTS.containsKey(eventType)) {
            System.out.println(SIMILAR_EVENTS.get(eventType));
        } else {
            throw new IllegalArgumentException("Not found");
        }
    }

    public static void deleteEventsById(Integer id) {
        if (EVENTS.containsKey(id)) {
            StreamEvent event = EVENTS.get(id);
            EVENTS.remove(id);
            List<StreamEvent> streamEvents = SIMILAR_EVENTS.get(event.getEventType());
            streamEvents.remove(event);
            if (streamEvents.isEmpty()) {
                SIMILAR_EVENTS.remove(event.getEventType());
            }
        }
    }

    public static void printInfo() {
        for (Map.Entry<Integer, StreamEvent> entry : EVENTS.entrySet()) {
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


        findEventById(2);
        System.out.println();
        findEventsListByType("game");
        System.out.println();
        printInfo();
        System.out.println();
        deleteEventsById(1);
        printInfo();

    }
}
