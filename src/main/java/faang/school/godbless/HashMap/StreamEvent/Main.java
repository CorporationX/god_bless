package src.main.java.faang.school.godbless.HashMap.StreamEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static Map<Integer, StreamEvent> map1 = new HashMap<>();
    static Map<String, List<StreamEvent>> map2 = new HashMap<>();

    public static void addEvent(Map<Integer, StreamEvent> map1, Map<String, List<StreamEvent>> map2, StreamEvent event) {
        map1.put(event.getId(), event);
        String eventType = event.getEventType();
        if (map2.containsKey(eventType)) {
            List<StreamEvent> eventList = map2.get(eventType);
            eventList.add(event);
        } else {
            List<StreamEvent> eventList = new ArrayList<>();
            eventList.add(event);
            map2.put(eventType, eventList);
        }
        System.out.println("event added");
    }

    public static StreamEvent findbyId(Map<Integer, StreamEvent> map1, int eventId) {
        return map1.get(eventId);
    }

    public static List<StreamEvent> findbyType(Map<String, List<StreamEvent>> map2, String eventType) {
        return map2.get(eventType);

    }

    public static void removeEvent(Map<Integer, StreamEvent> map1, Map<String, List<StreamEvent>> map2, int id) {
        StreamEvent removedEvent = map1.remove(id);
        if (removedEvent != null) {
            List<StreamEvent> eventsOfType = map2.get(removedEvent.getEventType());
            if (eventsOfType != null) {
                eventsOfType.remove(removedEvent);
            }
        }
        System.out.println("removed");
    }

    public static void soutEvent(Map<Integer, StreamEvent> map1) {
        for (Map.Entry<Integer, StreamEvent> entry : map1.entrySet()) {
            Integer eventId = entry.getKey();
            StreamEvent streamEvent = entry.getValue();
            System.out.println(eventId + "\n" + streamEvent.getEventType() + "\n" + streamEvent.getData());
        }
    }

    public static void main(String[] args) {
        StreamEvent event = new StreamEvent(1, "sobitee", "data");
        addEvent(map1, map2, event);
        StreamEvent findEventid = findbyId(map1, 1);
        System.out.println(findEventid);
        List<StreamEvent> eventsType = findbyType(map2, "sobitee");
        System.out.println(eventsType);
        soutEvent(map1);
        removeEvent(map1, map2, 1);
    }
}
