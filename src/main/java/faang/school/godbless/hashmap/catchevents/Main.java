package faang.school.godbless.hashmap.catchevents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<Integer, StreamEvent> streamEventMap;
    private static Map<String, List<StreamEvent>> streamEventListByType;
    public static void main(String[] args) {
        streamEventMap = new HashMap<>();
        streamEventListByType = new HashMap<>();

        int testId1 = 1;
        String testType1 = "тип1";
        add(new StreamEvent(testId1, testType1, "инфо1"));

        int testId2 = 2;
        String testType2 = testType1;
        add(new StreamEvent(testId2, testType2, "инфо2"));

        System.out.println(get(testId1));
        System.out.println(getStreamEventsByType(testType1));

        printAllEventsInfo();

        deleteById(testId1);
        System.out.println(get(testId1));
        System.out.println(getStreamEventsByType(testType1));

    }

    static void add(StreamEvent streamEvent) {
        if (streamEvent == null) {
            throw new IllegalArgumentException();
        }

        int id = streamEvent.getId();
        if (streamEventMap.containsKey(id)) {
            throw new IllegalStateException();
        }

        streamEventMap.put(id, streamEvent);
        streamEventListByType.computeIfAbsent(streamEvent.getEventType(), key -> new ArrayList<>())
                .add(streamEvent);
    }

    static StreamEvent get(int id) {
        return streamEventMap.get(id);
    }

    static List<StreamEvent> getStreamEventsByType(String eventType) {
        return streamEventListByType.get(eventType);
    }

    static void deleteById(int id) {
        // Удаляем из основной мапы
        StreamEvent deleted = streamEventMap.remove(id);

        // Удаляем из мапы тип-список, удаляем сам список(если он пуст) чтобы не хранить на него ссылку
        String deletedEventType = deleted.getEventType();
        List<StreamEvent> sameTypeEvents = streamEventListByType.get(deletedEventType);
        sameTypeEvents.remove(deleted); //Удаление за O(n)
        if (sameTypeEvents.isEmpty()) {
            streamEventListByType.remove(deletedEventType);
        }
    }

    static void printAllEventsInfo() {
        System.out.println("Вывод всех событий:");
        if (streamEventMap.isEmpty()) {
            System.out.println("--событий нет--");
        }

        streamEventMap.entrySet()
                .forEach(System.out::println);
    }
}
