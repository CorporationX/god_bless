package faang.school.godbless.Hashmap.CatchEvents;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<Integer, StreamEvent> EVENT_ID_MAP = new HashMap<>();
    private static final Map<String, List<StreamEvent>> EVENT_TYPE_MAP = new HashMap<>();
    private static final List<StreamEvent> EVENTS = new ArrayList<>();

    public static void main(String[] args) {
        Main app = new Main();

        StreamEvent event1 = new StreamEvent(1, "Birthdays", "Megan's birthday");
        StreamEvent event2 = new StreamEvent(2, "Birthdays", "Marty's birthday");
        StreamEvent event3 = new StreamEvent(3, "Winter holidays", "Christmas");
        StreamEvent event4 = new StreamEvent(4, "Winter holidays", "New Year");
        StreamEvent event5 = new StreamEvent(5, "Traditional holidays", "Halloween");
        StreamEvent event6 = new StreamEvent(6, "Traditional holidays", "Easter");

        EVENTS.addAll(Arrays.asList(event1, event2, event3, event4, event5, event6));

        app.add(event1);
        app.add(event2);
        app.add(event3);
        app.add(event4);
        app.add(event5);
        app.add(event6);

        app.getById(4);

        System.out.println();

        app.getByType("Traditional holidays");

        app.deleteById(5);

        System.out.println();

        app.getAll();

    }

    public void add(StreamEvent event) {
        EVENT_ID_MAP.put(event.getId(), event);

        List<StreamEvent> eventList = EVENT_TYPE_MAP.getOrDefault(event.getEventType(), new ArrayList<>());
        eventList.add(event);
        EVENT_TYPE_MAP.put(event.getEventType(), eventList);
    }

    public StreamEvent getById(int id) {
        return EVENT_ID_MAP.get(id);
    }

    public List<StreamEvent> getByType(String eventType) {
        List<StreamEvent> events = EVENT_TYPE_MAP.get(eventType);
        return events != null ? new ArrayList<>(events) : Collections.emptyList();
    }

    public void deleteById(int id) {
        EVENT_ID_MAP.entrySet().removeIf(entry -> entry.getValue().getId() == id);

        EVENT_TYPE_MAP.values().forEach(eventList -> eventList.removeIf(event -> event.getId() == id));
    }

    private List<StreamEvent> getAll() {
        List<StreamEvent> allEvents = new ArrayList<>();
        for (List<StreamEvent> events : EVENT_TYPE_MAP.values()) {
            allEvents.addAll(events);
        }
        return allEvents;
    }
}
