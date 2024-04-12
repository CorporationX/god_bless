package faang.school.godbless.catch_events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, StreamEvent> keepMapById = new HashMap<>();
        Map<String, List<StreamEvent>> keepMapByString = new HashMap<>();
        StreamEvent streamEvent1 = new StreamEvent(1, "Sleep", "12/01/2007");
        StreamEvent streamEvent2 = new StreamEvent(2, "Watch", "1/07/2009");
        StreamEvent streamEvent3 = new StreamEvent(3, "Touch", "16/10/2005");
        addStreamEvent(streamEvent1, keepMapById, keepMapByString);
        addStreamEvent(streamEvent2, keepMapById, keepMapByString);
        addStreamEvent(streamEvent3, keepMapById, keepMapByString);
        System.out.println("===========>>>>>>>>>>");
        System.out.println(findStreamEventById(2, keepMapById));
        System.out.println("===========>>>>>>>>>>");
        List<StreamEvent> watchEvents = findStreamEventsByType("Watch", keepMapByString);
        System.out.println("События типа 'Watch':");
        for (StreamEvent event : watchEvents) {
            System.out.println(event);
        }
        System.out.println("===========>>>>>>>>>>");
        deleteStreamEventById(1, keepMapById, keepMapByString);
        System.out.println("===========>>>>>>>>>>");
        displayAllEvents(keepMapById);
    }

    private static void addStreamEvent(StreamEvent event, Map<Integer,
            StreamEvent> keepMapById, Map<String, List<StreamEvent>> keepMapByString) {
        keepMapById.put(event.getId(), event);
        System.out.println("Event " + event + " Добавлен в Map keepMapById");
        List<StreamEvent> eventList = keepMapByString.get(event.getEventType());
        if (eventList == null) {
            eventList = new ArrayList<>();
            keepMapByString.put(event.getEventType(), eventList);
            System.out.println("Event " + event + " Добавлен в Map keepMapByString");
        }
        eventList.add(event);
    }

    private static StreamEvent findStreamEventById(int id, Map<Integer, StreamEvent> keepMapById) {
        return keepMapById.get(id);
    }

    private static List<StreamEvent> findStreamEventsByType(String eventType, Map<String, List<StreamEvent>> keepMapByString) {
        List<StreamEvent> events = keepMapByString.getOrDefault(eventType, new ArrayList<>());
        return events;
    }

    private static void deleteStreamEventById(int id, Map<Integer, StreamEvent> keepMapById, Map<String,
            List<StreamEvent>> keepMapByString) {
        StreamEvent event = keepMapById.get(id);
        if (event != null) {
            keepMapById.remove(id);
            System.out.println("Event " + event + " удалён");
            String eventType = event.getEventType();
            if (eventType != null) {
                List<StreamEvent> eventIdList = keepMapByString.get(eventType);
                if (eventIdList != null) {
                    eventIdList.remove(Integer.valueOf(id));
                    System.out.println("Событие " + id + " удалено из списка " + eventType);
                    if (eventIdList.isEmpty()) {
                        keepMapByString.remove(eventType);
                        System.out.println("Список событий " + eventType + " пустой и был удалён");
                    }
                }
            }
        }
    }

    private static void displayAllEvents(Map<Integer, StreamEvent> keepMapById) {
        System.out.println("Информация о всех событиях:");
        for (Map.Entry<Integer, StreamEvent> entry : keepMapById.entrySet()) {
            int eventId = entry.getKey();
            StreamEvent event = entry.getValue();
            System.out.println("ID события: " + eventId);
            System.out.println("Тип события: " + event.getEventType());
            System.out.println("Данные события: " + event.getData());
            System.out.println();
        }
    }
}

