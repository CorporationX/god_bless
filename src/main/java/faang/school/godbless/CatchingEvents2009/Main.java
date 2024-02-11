package faang.school.godbless.CatchingEvents2009;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class Main {

    static Map<Integer, StreamEvent> eventMap = new HashMap<>();
    static Map<String, List<StreamEvent>> groupedEvents = new HashMap<>();
    static int id = 1;

    public static void main(String[] args) {
        addEvent(Events.EVENT_1, Events.EVENTTYPE_1);
        addEvent(Events.EVENT_2, Events.EVENTTYPE_1);
        addEvent(Events.EVENT_3, Events.EVENTTYPE_2);

        System.out.println("TEST 1: Added 3 event to both maps. Check if they grouped");
        System.out.println(eventMap.toString());
        System.out.println(groupedEvents.toString());
        removeEventById(2);

        System.out.println("TEST 2: Removed event with id=2");
        System.out.println(eventMap.toString());
        System.out.println(groupedEvents.toString());
        addEvent(Events.EVENT_5, Events.EVENTTYPE_3);
        addEvent(Events.EVENT_6, Events.EVENTTYPE_3);

        System.out.println("TEST 3: Added 2 events with eventtype 3. Check if they grouped");
        System.out.println(eventMap.toString());
        System.out.println(groupedEvents.toString());

        System.out.println("TEST 4: Test printAllEventsInfo method");
        printAllEventsInfo();

        System.out.println("TEST 5: Test findEventById method (id=4)");
        try {
            System.out.println(findEventById(4).toString());
        } catch (NoSuchElementException exception) {
            System.out.println(exception.getMessage());
        }

        System.out.println("TEST 6: Test findEventsByType method (type3)");
        try {
            System.out.println(findEventsByType(Events.EVENTTYPE_3).toString());
        } catch (NoSuchElementException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void addEvent(String event, String eventType) {
        eventMap.put(id, new StreamEvent(id, eventType, event));
        if (!(groupedEvents.containsKey(eventType))) {
            groupedEvents.put(eventType, new ArrayList<>());
        }
        groupedEvents.get(eventType).add(new StreamEvent(id, eventType, event));
        id++;
    }

    public static void removeEventById(int id) {
        String eventType = eventMap.get(id).getEventType();
        eventMap.remove(id);
        List<StreamEvent> eventList = groupedEvents.get(eventType);
        for (int i = 0; i < eventList.size(); i++) {
            if (eventList.get(i).getId() == id) {
                eventList.remove(i);
                break;
            }
        }
    }

    public static StreamEvent findEventById(int id) {
        if (eventMap.get(id) != null) {
            return eventMap.get(id);
        } else {
            throw new NoSuchElementException("There's no event with id " + id);
        }
    }

    public static List<StreamEvent> findEventsByType(String eventType) {
        if (groupedEvents.get(eventType) != null) {
            return groupedEvents.get(eventType);
        } else {
            throw new NoSuchElementException("There's no event type " + eventType);
        }
    }

    public static void printAllEventsInfo() {
        int count = 1;
        for (var entry : eventMap.entrySet()) {
            int eventId = entry.getValue().getId();
            String eventType = entry.getValue().getEventType();
            String event = entry.getValue().getData();
            System.out.printf("Event %d: id: %d, EventType: %s, Event: %s%n",
                    count,
                    eventId,
                    eventType,
                    event);
            count++;
        }
    }
}
