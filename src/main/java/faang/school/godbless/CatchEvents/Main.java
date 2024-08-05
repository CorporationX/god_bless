package faang.school.godbless.CatchEvents;

import java.lang.ref.PhantomReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static int LAST_ID = 1;
    private static final Map<Integer, StreamEvent> EVENT_BY_ID = new HashMap<>();
    private static final Map<String, List<StreamEvent>> EVENTS_BY_TYPE = new HashMap<>();

    public static void main(String[] args) {
        addNewEvent(new StreamEvent(LAST_ID,"dota", "pudge"));
        addNewEvent(new StreamEvent(LAST_ID,"dota", "kunkka"));
        addNewEvent(new StreamEvent(LAST_ID,"cs", "ak47"));
        addNewEvent(new StreamEvent(LAST_ID,"blackjack", "21"));

        printAllEventsInfo();

        System.out.println();

        deleteEventById(3);

        System.out.println();

        printAllEventsInfo();

        System.out.println();

        System.out.println(findEventById(1));

        System.out.println();

        findEventsByType("dota").forEach( streamEvent -> System.out.println(streamEvent.toString()));
    }

    private static void addNewEvent(StreamEvent event) {
        EVENT_BY_ID.put(LAST_ID++, event);
        EVENTS_BY_TYPE.putIfAbsent(event.getEventType(), new ArrayList<>());
        EVENTS_BY_TYPE.get(event.getEventType()).add(event);
    }

    private static void deleteEventById(int id) {
        StreamEvent event = EVENT_BY_ID.get(id);
        EVENT_BY_ID.remove(id);
        EVENTS_BY_TYPE.get(event.getEventType()).remove(event);
    }

    private static StreamEvent findEventById(int id) {
        StreamEvent event = EVENT_BY_ID.get(id);
        return EVENT_BY_ID.get(id);
    }

    private static List<StreamEvent> findEventsByType(String type) {
        return EVENTS_BY_TYPE.get(type);
    }

    private static void printAllEventsInfo() {
        EVENT_BY_ID.forEach( (id, event) -> System.out.println(id + " " + event.toString()));
    }
}
