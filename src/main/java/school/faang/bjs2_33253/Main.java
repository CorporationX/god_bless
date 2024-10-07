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

    private Main() {
    }

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

        List <StreamEvent> streamEvents = searchStreamEventByType("ERROR");
        System.out.println(streamEvents);

        deleteStreamEventById(2);

        System.out.println(SORTED_EVENTS_BY_ID);
        System.out.println(SORTED_EVENTS_BY_TYPE);

    }
    public static void addStreamEvent(StreamEvent streamEvent) {
       SORTED_EVENTS_BY_ID.putIfAbsent(streamEvent.getId(), streamEvent);
       log.info("Событие c id " + streamEvent.getId() +  " добавлено в мапу 1");

       SORTED_EVENTS_BY_TYPE.putIfAbsent(streamEvent.getEventType(), new ArrayList<>());
       SORTED_EVENTS_BY_TYPE.get(streamEvent.getEventType()).add(streamEvent);
        log.info("Событие c id " + streamEvent.getId() +  " добавлено в мапу 2");
    }

    public static StreamEvent searchStreamEventById(int id) {
        if (SORTED_EVENTS_BY_ID.containsKey(id)) {
            log.info("Возвращаю событие с id " + id);
            return SORTED_EVENTS_BY_ID.get(id);
        } else {
            log.error("События с id " + id + " не существует");
            return null;
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
        if (!SORTED_EVENTS_BY_ID.containsKey(id)) {
            log.error("События c id " + id + " не существует в мапе");
        } else {
            SORTED_EVENTS_BY_ID.remove(id);
            log.info("Событие с id " + id + " удалено из памы 1");

            for (Map.Entry<String, List<StreamEvent>> event : SORTED_EVENTS_BY_TYPE.entrySet()) {
                for (StreamEvent streamEvent : event.getValue()) {
                   if (streamEvent.getId() == id) {
                       event.getValue().remove(streamEvent);
                       log.info("События с id " + id + " удалено из памы 2");
                   }
                }
            }
        }
    }
}
