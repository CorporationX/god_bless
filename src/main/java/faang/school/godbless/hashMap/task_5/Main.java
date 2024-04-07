package faang.school.godbless.hashMap.task_5;

import faang.school.godbless.hashMap.task_5.model.StreamEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<Integer, StreamEvent> idEvents = new HashMap<>();
    private static Map<String, List<StreamEvent>> typeEvents = new HashMap<>();
    private static Map<StreamEvent, Integer> eventIndicesStorage = new HashMap<>();

    public static void main(String[] args) {
        StreamEvent firstEvent = new StreamEvent(1, "type 1", "data 1");
        StreamEvent secondEvent = new StreamEvent(2, "type 2", "data 2");
        StreamEvent thirdEvent = new StreamEvent(3, "type 1", "data 4");
        add(firstEvent.getId(), firstEvent);
        add(secondEvent.getId(), secondEvent);
        add(thirdEvent.getId(), thirdEvent);
        System.out.println("События до удаления: ");
        printAll();
        System.out.println("Результат поиска события по id = " + secondEvent.getId());
        System.out.println(findById(secondEvent.getId()));
        System.out.println();
        System.out.println("Результат поиска событий по типу = " + firstEvent.getEventType());
        System.out.println(findByType(firstEvent.getEventType()));
        System.out.println();
        removeById(2);
        printAll();
        eventIndicesStorage.forEach((key, value) -> System.out.println(key + " : " + value));
    }

    private static void add(int id, StreamEvent event) {
        idEvents.put(id, event);
        List<StreamEvent> events = typeEvents.computeIfAbsent(event.getEventType(), k -> new ArrayList<>());
        events.add(event);
        eventIndicesStorage.put(event, events.size() - 1);
    }

    private static StreamEvent findById(int id) {
        return idEvents.get(id);
    }

    private static List<StreamEvent> findByType(String type) {
        return typeEvents.getOrDefault(type, new ArrayList<>());
    }

    private static void removeById(int id) {
        StreamEvent removingEvent = idEvents.remove(id);
        if (removingEvent != null) {
            List<StreamEvent> currentEvents = typeEvents.get(removingEvent.getEventType());
            if (currentEvents != null) {
                int indexOfRemovingEvent = eventIndicesStorage.get(removingEvent);
                currentEvents.remove(indexOfRemovingEvent);
                changeIndexesAfterRemoving(removingEvent);
            }
        }
    }

    private static void changeIndexesAfterRemoving(StreamEvent removingEvent) {
        int removedIndex = eventIndicesStorage.remove(removingEvent);
        eventIndicesStorage.forEach((event, eventIndex) -> {
            if (event.getEventType().equals(removingEvent.getEventType())) {
                if (removedIndex < eventIndex) {
                    eventIndicesStorage.put(event, eventIndex - 1);
                }
            }
        });
    }

    private static void printAll() {
        typeEvents.forEach(((typeEvent, events) -> {
            System.out.println(typeEvent + ": ");
            events.forEach(System.out::println);
        }));
        System.out.println();
    }
}