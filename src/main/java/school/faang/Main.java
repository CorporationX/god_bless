package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final Map<Integer, StreamEvent> eventIdWithEvent = new HashMap<>();

    private static final Map<String, List<StreamEvent>> eventTypeWithMapList = new HashMap<>();

    public static void main(String[] args) {
        addEvent(new StreamEvent("Совершена покупка", "buyer1@byer.ru"));
        addEvent(new StreamEvent("Совершена покупка", "buyer2@byer.ru"));
        addEvent(new StreamEvent("Пользователь очистил корзину", "buyer1 dropped shopping cart"));
        addEvent(new StreamEvent("Введен промокод", "buyer1 entered promocode"));
        addEvent(new StreamEvent("Карточка не принята", "buyer1 credentials invalid"));

        findEventById(2);

        findEventByType("Совершена покупка");
        findEventByType("Пользователь купил лодку");

        printAllEvents();

        removeEventById(3);

        printAllEvents();
    }

    public static void addEvent(StreamEvent event) {
        eventIdWithEvent.put(event.getId(), event);

        eventTypeWithMapList.putIfAbsent(event.getEventType(), new ArrayList<>());
        eventTypeWithMapList.get(event.getEventType()).add(event);

        System.out.println("Добавлено событие: " + event);
    }

    public static void findEventById(int id) {
        if (eventIdWithEvent.containsKey(id)) {
            System.out.println("Событие найдено: " + eventIdWithEvent.get(id));
        } else {
            System.out.println("Событие с id " + id + " не найдено.");
        }
    }

    public static void findEventByType(String eventType) {
        if (eventTypeWithMapList.containsKey(eventType)) {
            System.out.println("Тип события: " + eventType + ": " + eventTypeWithMapList.get(eventType));
        } else {
            System.out.println("Тип события: " + "'" + eventType + "'" + " не найдено.");
        }
    }

    public static void removeEventById(int id) {
        if (eventIdWithEvent.containsKey(id)) {
            StreamEvent event = eventIdWithEvent.get(id);
            eventIdWithEvent.remove(id);

            List<StreamEvent> eventsByType = eventTypeWithMapList.get(event.getEventType());
            if (eventsByType != null) {
                eventsByType.remove(event);
                if (eventsByType.isEmpty()) {
                    eventTypeWithMapList.remove(event.getEventType());
                }
            }

            System.out.println("Событие удалено: " + event);
        } else {
            System.out.println("События с ID " + id + " не существует");
        }
    }


    public static void printAllEvents() {
        System.out.println("\nВыводим все события по ID");
        for (Map.Entry<Integer, StreamEvent> entry : eventIdWithEvent.entrySet()) {
            System.out.println("ID: " + entry.getKey() + ", событие: " + entry.getValue());
        }

        System.out.println("\nВыводим события по типам");
        for (Map.Entry<String, List<StreamEvent>> entry : eventTypeWithMapList.entrySet()) {
            String eventType = entry.getKey();
            List<StreamEvent> events = entry.getValue();

            System.out.println("Тип события: " + eventType);
            for (StreamEvent event : events) {
                System.out.println(" -> Событие: " + event);
            }
        }
    }
}
