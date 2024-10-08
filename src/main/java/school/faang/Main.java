package school.faang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<Integer, StreamEvent> idEventMap = new HashMap<>();
    private static Map<String, List<StreamEvent>> eventTypeMap = new HashMap<>();

    public static void main(String[] args) {
        StreamEvent firstEvent = new StreamEvent(1, "something", "speech");
        StreamEvent secondEvent = new StreamEvent(51, "burn", "thinking");
        StreamEvent thirdEvent = new StreamEvent(18, "burn", "thinking");

        List<StreamEvent> eventsBurn = new ArrayList(Arrays.asList(secondEvent, secondEvent));
        List<StreamEvent> eventsSomething = new ArrayList(Arrays.asList(firstEvent));

        eventTypeMap.put("burn", eventsBurn);
        eventTypeMap.put("something", eventsSomething);

        idEventMap.put(1, firstEvent);
        idEventMap.put(51, secondEvent);
        idEventMap.put(18, thirdEvent);

        addNewEvent(new StreamEvent(12, "basic end-to-end mode", "Speech"));

        eventSearchById(51);

        eventsSearchByEventType("burn");

        deleteEventByID(18);

        allStreamEvents();
    }

    public static void addNewEvent(StreamEvent newEvent) {
        List<StreamEvent> events;
        if (eventTypeMap.get(newEvent.getEventType()) == null) {
            events = new ArrayList<>();
        } else {
            events = eventTypeMap.get(newEvent.getEventType());
        }
        events.add(newEvent);
        eventTypeMap.put(newEvent.getEventType(), events);
        idEventMap.put(newEvent.getId(), newEvent);
    }

    public static void eventSearchById(int idSearch) {
        System.out.println("Событие найденное по ID = " + idSearch + " : " + idEventMap.get(idSearch));
    }

    public static void eventsSearchByEventType(String eventTypeSearch) {
        System.out.println("Список событий найденных по типу " + eventTypeSearch + " : " + idEventMap.get(eventTypeSearch));
    }

    public static void deleteEventByID(int id) {
        if (idEventMap.get(id) != null) {
            String eventTypeForId = idEventMap.get(id).getEventType();
            List<StreamEvent> listToDelete = eventTypeMap.get(eventTypeForId);
            int index = listToDelete.indexOf(idEventMap.get(id));

            if (index != -1) {
                if (listToDelete.size() == 1) {
                    listToDelete = null;
                } else {
                    listToDelete.remove(index);
                }
                idEventMap.remove(id);
            }
        }
    }

    public static void allStreamEvents() {
        for (Map.Entry<Integer, StreamEvent> entry : idEventMap.entrySet()) {
            System.out.println("ID события: " + entry.getKey() + " Событие: " + entry.getValue());
        }
        for (Map.Entry<String, List<StreamEvent>> entry : eventTypeMap.entrySet()) {
            System.out.println("Тип события: " + entry.getKey() + "  Список таких событий: " + entry.getValue());
        }
    }
}