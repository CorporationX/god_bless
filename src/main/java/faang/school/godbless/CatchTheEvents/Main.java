package faang.school.godbless.CatchTheEvents;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private Map<Integer,StreamEvent> events = new HashMap<>();
    private Map<String, List<StreamEvent>> eventsByType = new HashMap<>();

    public static void main(String[] args) {

        Main main = new Main();

        // Создаем несколько событий
        StreamEvent event1 = new StreamEvent(1, "Data for Event 1", "TypeA");
        StreamEvent event2 = new StreamEvent(2, "Data for Event 2", "TypeB");
        StreamEvent event3 = new StreamEvent(3, "Data for Event 3", "TypeA");
        StreamEvent event4 = new StreamEvent(4, "Data for Event 4", "TypeC");
        StreamEvent event5 = new StreamEvent(5, "Data for Event 5", "TypeB");

        // Добавляем события в Map
        main.putStreamEventToEventsMap(event1);
        main.putStreamEventToEventsMap(event2);
        main.putStreamEventToEventsMap(event3);
        main.putStreamEventToEventsMap(event4);
        main.putStreamEventToEventsMap(event5);

        // Выводим данные всех событий
        main.printAllEvents();
    }


    public void putStreamEventToEventsMap(@NonNull StreamEvent event){
        events.computeIfAbsent(event.getId(), key -> event);
        eventsByType.computeIfAbsent(event.getEventType(), key -> new ArrayList<>()).add(event);
    }
    public void removeStreamEventInEventsMap(@NonNull StreamEvent event){
        events.remove(event.getId());
        eventsByType.get(event.getEventType()).remove(event);
    }
    public StreamEvent getEventFromEventsMap(@NonNull int id){
        return events.get(id);
    }

    // Метод для вывода всех событий
    public void printAllEvents() {
        System.out.println("Все события по ID:");
        for (Map.Entry<Integer, StreamEvent> entry : events.entrySet()) {
            System.out.println("ID: " + entry.getKey() + ", Событие: " + entry.getValue());
        }

        System.out.println("\nВсе события по типу:");
        for (Map.Entry<String, List<StreamEvent>> entry : eventsByType.entrySet()) {
            System.out.println("Тип: " + entry.getKey() + ", События: " + entry.getValue());
        }
    }
}
