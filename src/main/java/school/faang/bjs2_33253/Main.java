package school.faang.bjs2_33253;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class Main {
    private static final Map<Integer, StreamEvent> SORTED_EVENTS_BY_ID = new HashMap<>();
    private static final Map<String, List<StreamEvent>> SORTED_EVENTS_BY_TYPE = new HashMap<>();

    public static void main(String[] args) {
        StreamEvent userErrorEvent = new StreamEvent(2, "ERROR", "У пользователя возникла ошибка");
        StreamEvent sendingDataEvent = new StreamEvent(2, "INFO", "Отправка данных в бд");
        StreamEvent memoryRunningOutEvent = new StreamEvent(5, "WARNING", "Предупреждение о том, что память заканчивается");
        StreamEvent memoryEndingEvent = new StreamEvent(5, "ERROR", "Закончилась память");

        addStreamEvent(userErrorEvent);
        addStreamEvent(sendingDataEvent);
        addStreamEvent(memoryRunningOutEvent);
        addStreamEvent(memoryEndingEvent);

        StreamEvent newEvent = searchStreamEventById(5);
        System.out.println(newEvent);

        List<StreamEvent> streamEvents = searchStreamEventByType("ERROR");
        System.out.println(streamEvents);

        deleteStreamEventById(2);

        System.out.println(SORTED_EVENTS_BY_ID);
        System.out.println(SORTED_EVENTS_BY_TYPE);

    }

    public static void addStreamEvent(StreamEvent streamEvent) {
        SORTED_EVENTS_BY_ID.putIfAbsent(streamEvent.getId(), streamEvent);
        log.info("Событие c id " + streamEvent.getId() + " добавлено в мапу 1");

        SORTED_EVENTS_BY_TYPE.putIfAbsent(streamEvent.getEventType(), List.of(streamEvent));
        log.info("Событие c id " + streamEvent.getId() + " добавлено в мапу 2");
    }

    public static StreamEvent searchStreamEventById(int id) {
        StreamEvent streamEvent = SORTED_EVENTS_BY_ID.get(id);
        if (streamEvent == null) {
            log.warn("События с id " + id + " не существует");
            return null;
        } else {
            log.info("Возвращаю событие с id " + id);
            return streamEvent;
        }
    }

    public static List<StreamEvent> searchStreamEventByType(String eventType) {
        if (SORTED_EVENTS_BY_TYPE.containsKey(eventType)) {
            log.info("Возвращаю события с типом " + eventType);
            return SORTED_EVENTS_BY_TYPE.get(eventType);
        } else {
            log.error("Событий с типом " + eventType + " не найдено");
            return new ArrayList<>();
        }
    }

    public static void deleteStreamEventById(int id) {
        StreamEvent streamEventToDelete = SORTED_EVENTS_BY_ID.remove(id);

        if (streamEventToDelete == null) {
            log.warn("События c id " + id + " не существует в мапе");
        } else {
            if (SORTED_EVENTS_BY_TYPE.containsKey(streamEventToDelete.getEventType())) {
                //Перебираем лист с типом указанным
                for (StreamEvent streamEvent : SORTED_EVENTS_BY_TYPE.get(streamEventToDelete.getEventType())) {
                    if (streamEvent.getId() == id) {
                        SORTED_EVENTS_BY_TYPE.get(streamEventToDelete.getEventType()).remove(streamEvent);
                    }
                }
            }
            log.info("События с id " + id + " удалены из пам");
        }
    }
}
