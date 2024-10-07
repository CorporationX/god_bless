package school.BJS2_33257;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final Map<Integer, StreamEvent> mapWithIdOfEvent = new HashMap<>();
    private static final Map<String, List<StreamEvent>> mapWithTypeOfEventt = new HashMap<>();


    public static void main(String[] args) {
        StreamEvent streamEvent_1 = new StreamEvent(1, "Обращение", "Обратились 10 человек");
        StreamEvent streamEvent_2 = new StreamEvent(2, "Обращение", "Обратились 5 человек");
        StreamEvent streamEvent_3 = new StreamEvent(3, "Обращение", "Обратились 7 человек");
        StreamEvent streamEvent_4 = new StreamEvent(4, "Жалоба", "Пожаловались 9 человек");
        StreamEvent streamEvent_5 = new StreamEvent(5, "Жалоба", "Пожаловались 100 человек");
        StreamEvent streamEvent_6 = new StreamEvent(6, "Благодарность", "Поблагодарили 4 человeка");
        addEvent(streamEvent_1);
        addEvent(streamEvent_2);
        addEvent(streamEvent_3);
        addEvent(streamEvent_4);
        addEvent(streamEvent_5);
        addEvent(streamEvent_6);
        printStreamEvent();
        System.out.println("----------------------------------");
        System.out.println(getStreamEventWithID(5));
        System.out.println("----------------------------------");
        System.out.println(Arrays.asList(getStreamEventWithEventType("Обращение")));
        System.out.println("----------------------------------");
        removeStreamEvent(6);
        printStreamEvent();
    }

    private static void addEvent(StreamEvent streamEvent) {
        mapWithIdOfEvent.put(streamEvent.getId(), streamEvent);
        mapWithTypeOfEventt.computeIfAbsent(streamEvent.getType(), k -> new ArrayList<>()).add(streamEvent);
    }

    private static StreamEvent getStreamEventWithID(Integer id) {
        return mapWithIdOfEvent.get(id);
    }

    private static List<StreamEvent> getStreamEventWithEventType(String eventType) {
        return mapWithTypeOfEventt.get(eventType);
    }

    private static void removeStreamEvent(Integer id) {
        StreamEvent event = mapWithIdOfEvent.remove(id);
        String type = event.getType();
        List<StreamEvent> events = mapWithTypeOfEventt.get(type);
        events.remove(event);
        if (mapWithTypeOfEventt.get(type) == null) {
            mapWithTypeOfEventt.remove(type);
        }
    }

    private static void printStreamEvent() {
        for (Map.Entry<Integer, StreamEvent> entry : mapWithIdOfEvent.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

}