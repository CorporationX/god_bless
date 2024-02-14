package Hashmap.HashMap5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StreamEvent event1 = new StreamEvent(1, "it", "confa");
        StreamEvent event2 = new StreamEvent(2, "it", "confa");
        StreamEvent event3 = new StreamEvent(3, "finance", "confa");
        Map<Integer, StreamEvent> mapEvents = new HashMap<>();
        Map<String, List<StreamEvent>> mapTypes = new HashMap<>();
        putEvent(mapEvents, mapTypes, event1);
        putEvent(mapEvents, mapTypes, event2);
        putEvent(mapEvents, mapTypes, event3);
        System.out.println(mapEvents);
        System.out.println(mapTypes);
        StreamEvent event = getEvent(mapEvents, 2);
        System.out.println(event);
        List<StreamEvent> list = getListEvents(mapTypes, "it");
        System.out.println(list);
        removeEvent(mapEvents, mapTypes, 3);
        printAllEvents(mapEvents);
    }

    public static void putEvent(Map<Integer, StreamEvent> mapEvents, Map<String, List<StreamEvent>> mapTypes, StreamEvent event) {
        mapEvents.put(event.getId(), event);
        String type = event.getType();
        if (mapTypes.containsKey(type)) {
            List<StreamEvent> streamEvents = mapTypes.get(type);
            streamEvents.add(event);
            mapTypes.put(type, streamEvents);
        } else {
            List<StreamEvent> streamEvents = new ArrayList<>();
            streamEvents.add(event);
            mapTypes.put(type, streamEvents);
        }
    }

    public static StreamEvent getEvent(Map<Integer, StreamEvent> mapEvents, int id) {
        return mapEvents.get(id);
    }

    public static List<StreamEvent> getListEvents(Map<String, List<StreamEvent>> mapTypes, String type) {
        return mapTypes.get(type);
    }

    public static void removeEvent(Map<Integer, StreamEvent> mapEvents, Map<String, List<StreamEvent>> mapTypes, int id) {
        StreamEvent streamEvent = mapEvents.get(id);
        mapEvents.remove(id);
        List<StreamEvent> listEvents = mapTypes.get(streamEvent.getType());
        if (listEvents.size() == 1 && listEvents.get(0).equals(streamEvent)) {
            mapEvents.remove(streamEvent.getType());
        } else {
            listEvents.remove(streamEvent);
            mapTypes.put(streamEvent.getType(), listEvents);
        }
    }

    public static void printAllEvents(Map<Integer, StreamEvent> map) {
        for (Map.Entry<Integer, StreamEvent> entry : map.entrySet()) {
            Integer key = entry.getKey();
            String type = entry.getValue().getType();
            String data = entry.getValue().getData();
            System.out.println(key + " " + type + " " + data);
        }
    }
}
