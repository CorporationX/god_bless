package tasks.bjs2_33307;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EventController {
    private Random random;
    private Map<Integer, StreamEvent> events;
    private Map<EventType, List<StreamEvent>> eventsGroupedByEventType;

    public EventController(int eventCountGenerate) {
        random = new Random();
        events = new HashMap<>();
        eventsGroupedByEventType = new HashMap<>();
        generateRandomEvents(eventCountGenerate);
    }

    public void generateRandomEvents(int count) {
        System.out.println("Сгенерировать " + count + " записей");

        for (int i = 0; i < count; i++) {
            EventType eventType = Stream
                    .of(EventType.values())
                    .collect(Collectors.toList())
                    .get(randomInt(EventType.values().length));

            addEvent(eventType);
        }
    }

    public String generateData(EventType eventType) {
        return switch (eventType) {
            case ADD_POST -> String.format("{accountId: %d, post: Какой то пост}", randomInt());
            case DELETE_POST -> String.format("{accountId: %d, postId: %d}", randomInt(), randomInt());
            case LIKE_POST -> String.format("{accountId: %d, postId: %d}", randomInt(), randomInt());
            case DISLIKE_POST -> String.format("{accountId: %d, postId: %d}", randomInt(), randomInt());
            case SHARE_POST -> String.format("{accountId: %d, postId: %d}", randomInt(), randomInt());
            case ADD_FRIEND -> String.format("{accountId: %d, userId: %d}", randomInt(), randomInt());
            case REMOVE_FRIEND -> String.format("{accountId: %d, userId: %d}", randomInt(), randomInt());
            case BLOCK_USER -> String.format("{accountId: %d, userId: %d}", randomInt(), randomInt());
            case UNBLOCK_USER -> String.format("{accountId: %d, userId: %d}", randomInt(), randomInt());
            case ADD_COMMENT ->
                    String.format("{accountId: %d, userId: %d, comment: Какой-то коммент}", randomInt(), randomInt());
            case DELETE_COMMENT ->
                    String.format("{accountId: %d, userId: %d, commentId: %d}", randomInt(), randomInt(), randomInt());
            case ADD_IMAGE -> String.format("{userId: %d, byte: %d}", randomInt(), randomInt());
        };
    }

    public void addEvent(EventType eventType) {
        System.out.println("Добавить события. Тип события : " + eventType);
        StreamEvent streamEvent = new StreamEvent(eventType, generateData(eventType));
        events.putIfAbsent(streamEvent.getId(), streamEvent);
        eventsGroupedByEventType.computeIfAbsent(eventType, k -> new ArrayList<>()).add(streamEvent);
        System.out.println("Добавлено событие. id : " + streamEvent.getId() + "\n");
    }

    public void removeEvent(int id) {
        System.out.println("Удалить события по id : " + id);
        StreamEvent event = getStreamEventById(id);

        if (event == null) {
            System.out.println("Нет события по id : " + id + "\n");
            return;
        }

        events.remove(id);
        eventsGroupedByEventType
                .values()
                .forEach(list -> list.removeIf(value -> value.equals(event)));
        System.out.println("Удалено событие по id : " + id + "\n");
    }

    public void showEvents() {
        System.out.println("Показать все события : ");
        showEvents(events.values().stream().toList());
    }

    public void showEventById(int id) {
        System.out.println("Показать события по id : " + id);
        StreamEvent event = getStreamEventById(id);

        if (event == null)
            System.out.println("Нету события по id : " + id + "\n");
        else
            System.out.println(event.getInformation() + "\n");
    }

    public void showEventsByType(EventType eventType) {
        System.out.println("Показать все события по типу : " + eventType);
        showEvents(eventsGroupedByEventType.get(eventType));
    }

    public void showEventsGroupedByEventType() {
        System.out.println("Показать все события сгруппированные по всем типам");
        for (Map.Entry<EventType, List<StreamEvent>> entry : eventsGroupedByEventType.entrySet()) {
            System.out.println("Тип события : " + entry.getKey());
            showEvents(entry.getValue());
        }

        System.out.println();
    }

    public StreamEvent getStreamEventById(int id) {
        return getValueByPredicate(events, p -> p.getKey() == id);
    }

    public List<StreamEvent> getStreamEventsByEventType(EventType eventType) {
        return getValueByPredicate(eventsGroupedByEventType, p -> p.getKey() == eventType);
    }

    private void showEvents(List<StreamEvent> events) {
        if (events == null) {
            System.out.println("Список событий пуст!" + "\n");
            return;
        }

        for (StreamEvent event : events) {
            System.out.println(event.getInformation());
        }

        System.out.println();
    }

    private int randomInt() {
        return randomInt(Integer.MAX_VALUE);
    }

    private int randomInt(int max) {
        return random.nextInt((max));
    }

    private <K, V> V getValueByPredicate(Map<K, V> map, Predicate<Map.Entry<K, V>> predicate) {
        return map.entrySet()
                .stream()
                .filter(predicate)
                .findFirst()
                .map(Map.Entry::getValue)
                .orElse(null);
    }
}
