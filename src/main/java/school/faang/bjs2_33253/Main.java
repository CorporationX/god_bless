package school.faang.bjs2_33253;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);
    private static Map<Integer, StreamEvent> map1 = new HashMap<>();
    private static Map<String, List<StreamEvent>> map2 = new HashMap<>();

    private Main() {
    }

    public static void main(String[] args) {
        StreamEvent streamEvent1 = new StreamEvent(1, "ERROR", "У пользователя возникла ошибка");
        StreamEvent streamEvent2 = new StreamEvent(2, "INFO", "Отправка данных в бд");
        StreamEvent streamEvent3 = new StreamEvent(3, "WARNING", "Предупреждение о том, что память заканчивается");
        StreamEvent streamEvent4 = new StreamEvent(4, "ERROR", "Закончилась память");

        addStreamEvent(streamEvent1);
        addStreamEvent(streamEvent2);
        addStreamEvent(streamEvent3);
        addStreamEvent(streamEvent4);

        StreamEvent streamEvent5 = searchStreamEventById(5);
        System.out.println(streamEvent5);

        List <StreamEvent> streamEvents = searchStreamEventByType("ERROR");
        System.out.println(streamEvents);

        deleteStreamEventById(2);
        deleteStreamEventById(5);
    }
    public static void addStreamEvent(StreamEvent streamEvent) {
       map1.putIfAbsent(streamEvent.getId(), streamEvent);
       LOG.info("Событие добавлено в мапу 1");

       map2.putIfAbsent(streamEvent.getEventType(), new ArrayList<>());
       map2.get(streamEvent.getEventType()).add(streamEvent);
        LOG.info("Событие добавлено в мапу 2");
    }

    public static StreamEvent searchStreamEventById(int id) {
        if (map1.containsKey(id)) {
            LOG.info("Возвращаю событие с id " + id);
            return map1.get(id);
        } else {
            LOG.error("События с id " + id + " не существует");
            return null;
        }
    }

    public static List<StreamEvent> searchStreamEventByType(String eventType) {
        if (map2.containsKey(eventType)) {
            LOG.info("Возвращаю события с типом " + eventType);
            return map2.get(eventType);
        } else {
            LOG.error("Событий с типом " + eventType + " не найдено");
            return null;
        }
    }

    public static void deleteStreamEventById(int id) {
        if (!map1.containsKey(id)) {
            LOG.error("События c id " + id + " не существует");
        } else {
            StreamEvent streamEventToDelete = map1.get(id);
            map1.remove(id);
            map2.remove(streamEventToDelete.getEventType());
            LOG.info("Событие с id " + id +  " удалено");
        }
    }
}
