package school.faang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, StreamEvent> idEventMap = new HashMap<>();
        Map<String, List<StreamEvent>> eventTypeMap = new HashMap<>();

        StreamEvent firstEvent = new StreamEvent(1, "something", "speech");
        StreamEvent secondEvent = new StreamEvent(51, "burn", "thinking");
        StreamEvent thirdEvent = new StreamEvent(18, "burn", "thinking");

        List<StreamEvent> eventsBurn = new ArrayList(Arrays.asList(secondEvent,secondEvent));
        List<StreamEvent> eventsSomething = new ArrayList(Arrays.asList(firstEvent));



        eventTypeMap.put("burn", eventsBurn);
        eventTypeMap.put("something", eventsSomething);

        idEventMap.put(1, firstEvent);
        idEventMap.put(51, secondEvent);
        idEventMap.put(18, thirdEvent);

        addNewEvent(idEventMap, eventTypeMap);

        eventSearchById(idEventMap, 51);

        eventsSearchByEventType(eventTypeMap, "burn");

        deleteEventByID(idEventMap, eventTypeMap, 18);

        allStreamEvents(idEventMap, eventTypeMap);
    }

    public static void addNewEvent(Map<Integer, StreamEvent> map, Map<String, List<StreamEvent>> map2) {
        int newId = 12;
        String newEventType = "basic end-to-end mode";
        String newData = "Speech";

        StreamEvent newEvent = new StreamEvent(newId, newEventType, newData);
        List<StreamEvent> events;

        if (map2.get(newEventType) == null) {
            events = new ArrayList<>();
        } else {
            events = map2.get(newEventType);
        }
        events.add(newEvent);
        map2.put(newEventType, events);
        map.put(newId, newEvent);
    }

    public static void eventSearchById(Map<Integer, StreamEvent> map, int idSearch) {
        System.out.println("Событие найденное по ID = " + idSearch + " : " + map.get(idSearch));
    }

    public static void eventsSearchByEventType(Map<String, List<StreamEvent>> map, String eventTypeSearch) {
        System.out.println("Список событий найденных по типу " + eventTypeSearch + " : " + map.get(eventTypeSearch));
    }

    public static void deleteEventByID(Map<Integer, StreamEvent> map, Map<String, List<StreamEvent>> map2, int id) {
        if (map.get(id) != null) {
            //Поиск типа события для удаления
            String eventTypeForId = map.get(id).getEventType();

            List<StreamEvent> listToDelete = map2.get(eventTypeForId);
            int index = listToDelete.indexOf(map.get(id));

            if (index != -1) {
                listToDelete.remove(index);
            }
            map2.put(eventTypeForId, listToDelete);
            map.remove(id);
        }
    }


    public static void allStreamEvents(Map<Integer, StreamEvent> map, Map<String, List<StreamEvent>> map2) {
        for (Map.Entry<Integer, StreamEvent> entry : map.entrySet()) {
            System.out.println("ID события: " + entry.getKey() + " Событие: " + entry.getValue());
        }

        for (Map.Entry<String, List<StreamEvent>> entry : map2.entrySet()) {
            System.out.println("Тип события: " + entry.getKey() + "  Список таких событий: " + entry.getValue());
        }
    }
}