package faang.school.godbless.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static HashMap<Integer, StreamEvent> eventsById = new HashMap<>();
    public static HashMap<String, List<StreamEvent>> eventsByType = new HashMap<>();

    public static void main(String[] args) {
    }

    public static void addEvent(StreamEvent event){
        eventsById.put(event.getID(), event);

        if (eventsByType.containsKey(event.getEventType())){
            eventsByType.get(event.getEventType()).add(event);
        }
        else {
            eventsByType.put(event.getEventType(), new ArrayList<>(List.of(event)));
        }
    }

    public static StreamEvent getEventById(int id) {
        return eventsById.get(id);
    }

    public static List<StreamEvent> getEventsByType(String eventType) {
        return eventsByType.get(eventType);
    }

    public static void removeEvent(int id) {
        StreamEvent event = eventsById.remove(id);
        if (event != null) {
            List<StreamEvent> events = eventsByType.get(event.getEventType());
            if (events != null) {
                events.remove(event);
                if (events.isEmpty()) {
                    eventsByType.remove(event.getEventType());
                }
            }
        }
    }

    public static void printAllEvents() {
        for (Map.Entry<Integer, StreamEvent> entry : eventsById.entrySet()) {
            System.out.println(entry.getValue());
        }
    }


}
