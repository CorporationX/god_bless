package faang.school.godbless.sprint_1.hashMap.task_010;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Main {
    private static final Map<Integer, StreamEvent> streamEventMap = new HashMap<>();
    private static final Map<String, List<StreamEvent>> typeEventMap = new HashMap<>();
    private static int id = 0;

    public static void main(String[] args) {
        Random random = new Random();

        // добавляю события
        for (int i = 1; i <= 20; i++) {
            addStreamEvent(new StreamEvent(++id, "type_" + random.nextInt(1, 5), "discription_" + i));
        }

        System.out.println("Список событий");
        showAllEvent();

        System.out.println();
        System.out.println("ищем событе с id=5");
        System.out.println(findEventById(5));

        System.out.println();
        System.out.println("ищем список событий с типом=2");
        findEventsByType("type_2").forEach(System.out::println);

        System.out.println();
        System.out.println("Удаляем события с id=1, 3, 5");
        deleteEventById(1);
        deleteEventById(3);
        deleteEventById(5);

        System.out.println();
        System.out.println("Список событий(после удаления)");
        showAllEvent();
    }

    private static void deleteEventById(int id) {
        streamEventMap.remove(id);
    }

    private static List<StreamEvent> findEventsByType(String type) {
        return typeEventMap.get(type);
    }


    private static void showAllEvent() {
        streamEventMap.values().forEach(System.out::println);
    }

    private static StreamEvent findEventById(int id) {
        return streamEventMap.get(id);
    }

    private static void addStreamEvent(StreamEvent event) {
        updateStreamEvetMap(event);
        updateTypeEventMap(event);
    }

    private static void updateTypeEventMap(StreamEvent event) {
        String eventType = event.eventType();
        if (typeEventMap.containsKey(eventType)) {
            typeEventMap.get(eventType).add(event);
        } else {
            typeEventMap.put(eventType, new ArrayList<>(List.of(event)));
        }
    }

    private static void updateStreamEvetMap(StreamEvent event) {
        streamEventMap.put(event.id(), event);
    }

}
