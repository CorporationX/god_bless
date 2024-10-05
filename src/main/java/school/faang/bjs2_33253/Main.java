package school.faang.bjs2_33253;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<Integer, StreamEvent> map1;
    private static Map<String, List<StreamEvent>> map2;

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

        StreamEvent streamEvent5 = searchStreamEventById(2);
        System.out.println(streamEvent5);

        List <StreamEvent> streamEvents = searchStreamEventByType("ERROR");
        System.out.println(streamEvents);

    }
    public static void addStreamEvent(StreamEvent streamEvent) {
       map1.putIfAbsent(streamEvent.getId(), streamEvent);

       List<StreamEvent> events = new ArrayList<>();

       map2.putIfAbsent(streamEvent.getEventType(), events);
       events.add(streamEvent);
    }

    public static StreamEvent searchStreamEventById(int id) {
        return map1.get(id);
    }

    public static List<StreamEvent> searchStreamEventByType(String eventType) {
        return map2.get(eventType);
    }

    public static void deleteStreamEventById(int id) {
        map1.remove(id);
        StreamEvent streamEventToDelete = map1.get(id);
        map2.remove(streamEventToDelete.getEventType());
    }
}
