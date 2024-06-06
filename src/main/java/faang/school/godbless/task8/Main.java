package faang.school.godbless.task8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static Map<Integer, StreamEvent> eventsMap = new HashMap<>();
    public static Map<String, List<StreamEvent>> eventsListMap = new HashMap<>();

    public static void main(String[] args) {
        addNewEvent(new StreamEvent(1, "1", "1"));
        addNewEvent(new StreamEvent(2, "1", "2"));
        addNewEvent(new StreamEvent(3, "1", "3"));
        findEventById(1);
        removeEvent(2);
        printEvents();
    }

    public static void addNewEvent(StreamEvent event) {
        eventsMap.put(event.getId(), event);
        if (!eventsListMap.containsKey(event.getEventType())) {
            eventsListMap.put(event.getEventType(), new ArrayList<>(List.of(event)));
        } else eventsListMap.get(event.getEventType()).add(event);
    }

    public static StreamEvent findEventById(int id) {
        return eventsMap.get(id);
    }

    public static void removeEvent(int id) {
        eventsMap.remove(id);
        for (List<StreamEvent> eventList : eventsListMap.values()) {
            eventList.removeIf(event -> event.getId() == id);
        }
    }

    public static void printEvents() {
        for (Map.Entry<Integer, StreamEvent> e : eventsMap.entrySet()) {
            System.out.println(e.getValue());
        }
    }
}
