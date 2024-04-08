package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, StreamEvent> mapId = new HashMap<>();
        HashMap<String, List<StreamEvent>> mapString = new HashMap<>();
        StreamEvent streamEvent1 = new StreamEvent(1, "Sleep", "12/01/2007");
        StreamEvent streamEvent2 = new StreamEvent(2, "Watch", "1/07/2009");
        StreamEvent streamEvent3 = new StreamEvent(3, "Touch", "16/10/2005");
        addStreamEvent(streamEvent1, mapId, mapString);
        addStreamEvent(streamEvent2, mapId, mapString);
        addStreamEvent(streamEvent3, mapId, mapString);
        System.out.println("===========>>>>>>>>>>");
        System.out.println(findStreamEventById(2, mapId));
        System.out.println("===========>>>>>>>>>>");
        System.out.println(findStreamEventsByType("Sleep", mapId));
        System.out.println("===========>>>>>>>>>>");
        deleteStreamEventById(1, mapId, mapString);
        System.out.println("===========>>>>>>>>>>");
        displayAllEvents(mapId);
    }
    private static void addStreamEvent(StreamEvent event, HashMap<Integer,
            StreamEvent> mapId, HashMap<String, List<StreamEvent>> mapString) {
        mapId.put(event.getId(), event);
        System.out.println("Event " + event + " Добавлен в Map mapId");
        List<StreamEvent> eventList = mapString.get(event.getEventType());
        if (eventList == null) {
            eventList = new ArrayList<>();
            mapString.put(event.getEventType(), eventList);
            System.out.println("Event " + event + " Добавлен в Map mapString");
        }
        eventList.add(event);
    }
    private static StreamEvent findStreamEventById(int id, Map<Integer, StreamEvent> mapId) {
        return mapId.get(id);
    }
    private static List<StreamEvent> findStreamEventsByType(String eventType, Map<Integer, StreamEvent> mapId) {
        List<StreamEvent> events = new ArrayList<>();
        for (StreamEvent event : mapId.values()) {
            if (event.getEventType().equals(eventType)) {
                events.add(event);
            }
        }
        return events;
    }
    private static void deleteStreamEventById(int id, Map<Integer, StreamEvent> mapId, Map<String, List<StreamEvent>> mapType) {
        StreamEvent event = mapId.get(id);
        if (event != null) {
            mapId.remove(id);
            System.out.println("Event " + event + " удалён");
            String eventType = event.getEventType();
            if (eventType != null) {
                List<StreamEvent> eventIdList = mapType.get(eventType);
                if (eventIdList != null) {
                    eventIdList.remove(Integer.valueOf(id));
                    System.out.println("Событие " + id + " удалено из списка " + eventType);
                    if (eventIdList.isEmpty()) {
                        mapType.remove(eventType);
                        System.out.println("Список событий " + eventType + " пустой и был удалён");
                    }
                }
            }
        }
    }
    private static void displayAllEvents(Map<Integer, StreamEvent> mapId) {
        System.out.println("Информация о всех событиях:");
        for (Map.Entry<Integer, StreamEvent> entry : mapId.entrySet()) {
            int eventId = entry.getKey();
            StreamEvent event = entry.getValue();
            System.out.println("ID события: " + eventId);
            System.out.println("Тип события: " + event.getEventType());
            System.out.println("Данные события: " + event.getData());
            System.out.println();
        }
    }
}

