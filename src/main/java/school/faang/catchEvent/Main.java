package school.faang.catchEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
   private static final Map<Integer,StreamEvent> EVENT = new HashMap<>();
   private static final Map<String, List<StreamEvent>> EVENT_TYPE = new HashMap<>();

    public static void main(String[] args) {
        StreamEvent streamEvent = new StreamEvent(1, "event", "data");
        StreamEvent streamEvent2 = new StreamEvent(2, "event2", "data2");
        StreamEvent streamEvent3 = new StreamEvent(3, "event3", "data3");

        addEvent(streamEvent);
        addEvent(streamEvent2);
        addEvent(streamEvent3);

//        printAllEvents();
//
//        removeEventById(2);

        printAllEvents();


    }

 public static void addEvent(StreamEvent streamEvent) {
     EVENT.put(streamEvent.getId(), streamEvent);
     EVENT_TYPE.computeIfAbsent(streamEvent.getEventType(), k -> new ArrayList<>()).add(streamEvent);
 }
    public static StreamEvent getEventById(int id) {
        return EVENT.get(id);
    }

    public static List<StreamEvent> getEventsByType(String eventType) {
       return  EVENT_TYPE.getOrDefault(eventType, new ArrayList<>());
    }

    public static void removeEventById(int id) {
        EVENT.remove(id);
    }

    public static void printAllEvents() {
        for (StreamEvent event : EVENT.values()) {
            System.out.println("ID: " + event.getId() + ", Type: " + event.getEventType() + ", Data: " + event.getData());
        }
    }
}
