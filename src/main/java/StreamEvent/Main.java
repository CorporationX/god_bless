package StreamEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<Integer, StreamEvent> EVENT_ALL = new HashMap<>();
    private static final Map<String, List<StreamEvent>> EVENT_TO_TYPE = new HashMap<>();


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

        getMaps(EVENT_ALL,EVENT_TO_TYPE);
        System.out.println("");

        removeEvent(4);

        getMaps(EVENT_ALL,EVENT_TO_TYPE);

    }

    public static void addMapEvent(StreamEvent streamEvent) {
        EVENT_ALL.put(streamEvent.getId(), streamEvent);
        EVENT_TO_TYPE.computeIfAbsent(streamEvent.getEventType(), k -> new ArrayList<>()).add(streamEvent);
    }

    public static void findEvent(int id) {
        EVENT_ALL.get(id);
    }

    public static void findToEventType(String eventType) {
        EVENT_TO_TYPE.get(eventType);
    }

    public static void removeEvent(Integer id) {
        StreamEvent streamEvent = EVENT_ALL.remove(id);
        EVENT_TO_TYPE.computeIfAbsent(streamEvent.getEventType(), k -> new ArrayList<>()).remove(streamEvent);

    }

    public static void getMaps(Map<Integer, StreamEvent> maps,Map<String, List<StreamEvent>> map2) {
        for (Map.Entry<Integer, StreamEvent> map : maps.entrySet()) {
            System.out.println("Id № " + map.getKey() + "  содержит следующий поток: " + map.getValue());
        }
        for (Map.Entry<String, List<StreamEvent>> map1 : map2.entrySet()) {
            System.out.println("Тип события " + map1.getKey() + "  имеет следующее содержание " + map1.getValue());
        }
    }
}
