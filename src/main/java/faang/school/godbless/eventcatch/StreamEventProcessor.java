package faang.school.godbless.eventcatch;

import java.util.*;

public class StreamEventProcessor {
    private HashMap<Integer, StreamEvent> streamById = new HashMap<>();
    private HashMap<String, List<StreamEvent>> streamsByType = new HashMap<>();

    // добавления нового события потока и обновления обоих HashMap;
    public void addNewEvent(StreamEvent streamEvent) {
        if (streamEvent == null) {
            throw new IllegalArgumentException("Событие не может быть пустым");
        }
        streamById.put(streamEvent.getId(), streamEvent);

        List<StreamEvent> list;
        if (streamsByType.containsKey(streamEvent.getEventType())) {
            list = streamsByType.get(streamEvent.getEventType());
        } else {
            list = new ArrayList<>();
        }
        list.add(streamEvent);
        streamsByType.put(streamEvent.getEventType(), list);
    }

    // поиска события потока по его ID;
    public StreamEvent findById(int id) {
        if (!streamById.containsKey(id)) {
            throw new IllegalArgumentException("События не существует");
        }
        return streamById.get(id);
    }

    // поиска списка событий потока по типу события;
    public List<StreamEvent> findByType(String type) {
        if (!streamsByType.containsKey(type)) {
            throw new IllegalArgumentException("Незарегистрированный тип события");
        }
        return streamsByType.get(type);
    }

    // удаления события потока по его ID и обновления обоих HashMap.
    public void deleteById(int id) {
        if (!streamById.containsKey(id)) {
            throw new IllegalArgumentException("События не существует");
        }

        StreamEvent event = streamById.get(id);
        List<StreamEvent> listOfEvents = streamsByType.get(event.getEventType());

        streamById.remove(id);
        listOfEvents.remove(event);
        if (listOfEvents.isEmpty()) {
            streamsByType.remove(event.getEventType());
        } else {
            streamsByType.put(event.getEventType(), listOfEvents);
        }
    }

    //Реализуйте метод для вывода информации о всех событиях потока, используя обход массива Entry внутри HashMap.
    // Выведите ID событий, типы событий и данные событий.
    public void showAllEvents() {
        Set<Map.Entry<String, List<StreamEvent>>> entrySet = streamsByType.entrySet();
        entrySet.stream()
                .map(Map.Entry::getValue)
                .forEach(System.out::println);
    }
}
