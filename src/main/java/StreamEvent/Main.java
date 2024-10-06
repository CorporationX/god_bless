package StreamEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final HashMap<Integer, StreamEvent> EVENT1 = new HashMap<>();
    private static final HashMap<String, List<StreamEvent>> EVENT2 = new HashMap<>();


    public static void main(String[] args) {
        StreamEvent event1 = new StreamEvent(1, "good", "Что то хорошее");
        StreamEvent event2 = new StreamEvent(4, "bad", "Что то плохое");
        StreamEvent event3 = new StreamEvent(1, "good", "Что то хорошее немного");
        StreamEvent event4 = new StreamEvent(6, "bad", "Что то плохое побольше");
        addMapEvent(event1);
        addMapEvent(event2);
        addMapEvent(event3);
        addMapEvent(event4);

        findEvent(1);

        findToEventType("good");

        removeEvent(4);
        getMaps(EVENT1,EVENT2);

    }

    public static void addMapEvent(StreamEvent streamEvent) {
        EVENT1.put(streamEvent.getId(), streamEvent);
        EVENT2.computeIfAbsent(streamEvent.getEventType(), k -> new ArrayList<>()).add(streamEvent);
    }

    public static void findEvent(Integer id) {
         EVENT1.get(id);
    }

    public static void findToEventType(String eventType) {
         EVENT2.get(eventType);
    }

    public static void removeEvent(Integer id) {
         EVENT1.remove(id);
    }

    public static void getMaps(HashMap<Integer, StreamEvent> maps,HashMap<String, List<StreamEvent>> map2) {
        for (Map.Entry<Integer, StreamEvent> map : maps.entrySet()) {
            System.out.println("Id № " + map.getKey() + "  содержит следующий поток: " + map.getValue());
        }
        for (Map.Entry<String, List<StreamEvent>> map1 : map2.entrySet()) {
            System.out.println("Тип события " + map1.getKey() + "  имеет следующее содержание " + map1.getValue());
        }
    }
}
