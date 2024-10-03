package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<Integer, StreamEvent> streamEvents = new HashMap<>();
    private static Map<String, List<StreamEvent>> groupStreamEvent = new HashMap<>();

    public static void main(String[] args) {
        StreamEvent firstEvent = new StreamEvent(1, "sport", "train");
        StreamEvent secondEvent = new StreamEvent(2, "study", "learn");
        StreamEvent thirdEvent = new StreamEvent(3, "chill", "chilling");

        addEvent(firstEvent);
        addEvent(secondEvent);
        addEvent(thirdEvent);

        deleteeEvent(secondEvent);

        System.out.println(getEventById(1));
        System.out.println(getEventsByEventType("chill"));

        printAllEvents();
    }

    public static void addEvent(StreamEvent event) {
        streamEvents.put(event.getId(), event);
        groupStreamEvent.computeIfAbsent(event.getEventType(), k -> new ArrayList<>()).add(event);
    }

    public static StreamEvent getEventById(int id) {
        return streamEvents.get(id);
    }

    public static List<StreamEvent> getEventsByEventType(String eventType) {
        return groupStreamEvent.get(eventType);
    }

    public static void deleteeEvent(StreamEvent event) {
        streamEvents.remove(event.getId());
        if (groupStreamEvent.containsKey(event.getEventType())) {
            groupStreamEvent.remove(event.getEventType()).remove(event);
        }
    }

    public static void printAllEvents() {
        for(Map.Entry<Integer, StreamEvent> entry : streamEvents.entrySet()) {
            StreamEvent event = entry.getValue();
            System.out.println("Тип события: " + event.getEventType() +
                    " id события: " + event.getId() + " данные события: " + event.getData());
        }
    }
}
