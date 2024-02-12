package faang.school.godbless.CatchingEvents;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<Integer, StreamEvent> STREAM_EVENTS_ID = new HashMap<>();
    private static final Map<String, List<StreamEvent>> STREAM_EVENTS_TYPE = new HashMap<>();

    public static void main(String[] args) {
        addEvent(new StreamEvent(1,"Boo", new Date()));
        addEvent(new StreamEvent(2,"Too", new Date()));
        addEvent(new StreamEvent(3,"Boo", new Date()));
        addEvent(new StreamEvent(4,"Too", new Date()));
        removeEvent(1);
        printAll();

    }

    public static void addEvent(StreamEvent event) {
        STREAM_EVENTS_ID.put(event.getId(), event);
        STREAM_EVENTS_TYPE.computeIfAbsent(event.getEventType(), k -> new ArrayList<>()).add(event);
    }

    public static void removeEvent(int id) {
        StreamEvent event = STREAM_EVENTS_ID.get(id);
        STREAM_EVENTS_ID.remove(id);
        STREAM_EVENTS_TYPE.remove(event.getEventType());
    }
    public static void printAll() {
        STREAM_EVENTS_ID.forEach((id, event) -> System.out.println(event.toString()));
        System.out.println("");
        STREAM_EVENTS_TYPE.forEach((type, event) -> System.out.println(event.toString()));
    }
}
