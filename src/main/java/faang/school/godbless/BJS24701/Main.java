package faang.school.godbless.BJS24701;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, StreamEvent> eventById = new HashMap<>();
        Map<String, List<StreamEvent>> eventsByType = new HashMap<>();

        // Добавление нового события потока и обновление обоих HashMap
        StreamEvent event1 = new StreamEvent(1, "type1", "data1");
        StreamEvent.addEvent(event1, eventById, eventsByType);

        // Поиск события потока по его ID
        int eventIdToFind = 1;
        StreamEvent foundEvent = StreamEvent.findEventById(eventIdToFind, eventById);
        if (foundEvent != null) {
            System.out.println("Найдено событие с ID " + eventIdToFind + ": " + foundEvent);
        } else {
            System.out.println("Событие с ID " + eventIdToFind + " не найдено.");
        }

        // Поиск списка событий потока по типу события
        String eventTypeToFind = "type1";
        List<StreamEvent> eventsOfType = StreamEvent.findEventsByType(eventTypeToFind, eventsByType);
        if (!eventsOfType.isEmpty()) {
            System.out.println("События с типом " + eventTypeToFind + ":");
            eventsOfType.forEach(System.out::println);
        } else {
            System.out.println("Не найдено событий с типом " + eventTypeToFind);
        }

        // Удаление события потока по его ID и обновление обоих HashMap
        StreamEvent.removeEventById(eventIdToFind, eventById, eventsByType);

        System.out.println("\nВсе события потока:");
        StreamEvent.printAllEvents(eventById);
    }
}
