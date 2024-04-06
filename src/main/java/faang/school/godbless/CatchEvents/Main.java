package faang.school.godbless.CatchEvents;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<Integer, StreamEvent> EVENT_ID = new HashMap<>();
    private static final Map<String, List<StreamEvent>> EVENT_TYPE = new HashMap<>();
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

    }

    public void add(StreamEvent event) {
        try {
            EVENT_ID.put(event.getId(), event);

            List<StreamEvent> eventList = EVENT_TYPE.getOrDefault(event.getEventType(), new ArrayList<>());
            eventList.add(event);
            EVENT_TYPE.put(event.getEventType(), eventList);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: null");
        }
    }

    public void getById(int id) {
        for (Map.Entry<Integer, StreamEvent> entry : EVENT_ID.entrySet()) {
            StreamEvent event = entry.getValue();
            System.out.println("Event with ID: " + event.getId() + ", with type: \"" + event.getEventType() + "\" is " + event.getData());
        }
    }

    public void getByType(String eventType) {
        for (Map.Entry<String, List<StreamEvent>> entry : EVENT_TYPE.entrySet()) {
            List<StreamEvent> events = entry.getValue();
            for (StreamEvent event : events) {
                if (event.getEventType().equals(eventType)) {
                    System.out.println("Event with ID: " + event.getId() + ", with type: \"" + event.getEventType() + "\" is " + event.getData());
                }
            }
        }
    }

    public void deleteById(int id) {
        try {
            Iterator<Map.Entry<Integer, StreamEvent>> idIterator = EVENT_ID.entrySet().iterator();
            while (idIterator.hasNext()) {
                Map.Entry<Integer, StreamEvent> entry = idIterator.next();
                StreamEvent event = entry.getValue();
                if (event.getId() == id) {
                    String keyEventType = event.getEventType();
                    idIterator.remove();

                    Iterator<Map.Entry<String, List<StreamEvent>>> eventTypeIterator = EVENT_TYPE.entrySet().iterator();
                    while (eventTypeIterator.hasNext()) {
                        Map.Entry<String, List<StreamEvent>> entryy = eventTypeIterator.next();
                        List<StreamEvent> eventList = entryy.getValue();
                        for (StreamEvent eventTypeToDelete : eventList) {
                            if (eventTypeToDelete.equals(keyEventType)) {
                                eventTypeIterator.remove();
                            }
                        }
                    }
                }
            }

        } catch (NullPointerException e) {
            System.err.println("Error: Null");
        }
    }
}
