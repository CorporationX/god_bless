package faang.school.godbless.javahashmap.task11catch_events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<Integer, StreamEvent> mapIdEvent = new HashMap<>();
    private static Map<String, List<StreamEvent>> mapTypeEvents = new HashMap<>();

    public static void main(String... args) {
        StreamEvent event1 = new StreamEvent("Type1", "Data1");
        StreamEvent event2 = new StreamEvent("Type1", "Data2");
        StreamEvent event3 = new StreamEvent("Type3", "Data3");
        StreamEvent event4 = new StreamEvent("Type4", "Data4");

        addEvent(event1);
        addEvent(event2);
        addEvent(event3);
        addEvent(event4);

        infoEvent(1);

        infoEvents("Type1");

        removeEvents(4);

        infoAllEvents();
    }

    public static void addEvent(StreamEvent event) {
        mapIdEvent.put(event.getId(), event);
        mapTypeEvents.computeIfAbsent(event.getEventType(), x -> new ArrayList<>()).add(event);

        System.out.println("Событие " + event.getId() + " добавлено, мапы обновлены\n");
    }

    public static void infoEvent(int id) {
        System.out.println(mapIdEvent.get(id) + "\n");
    }

    public static void infoEvents(String type) {
        System.out.println(mapTypeEvents.get(type) + "\n");
    }

    public static void removeEvents(int id) {
        StreamEvent event = mapIdEvent.remove(id);
        mapTypeEvents.getOrDefault(event.getEventType(), new ArrayList<>()).remove(event);
        //Я ПРОЗРЕЛ
        //Столько задач прорешал и ни разу не пользовался этими функциями
        //Оказывается так удобно

        System.out.println("Удалено событие " + event.getId() + ", мапы обновлены\n");
    }

    public static void infoAllEvents() {
        System.out.println("--------------------------------------------------------------");

        for (Map.Entry<Integer, StreamEvent> entry : mapIdEvent.entrySet()) {
            StreamEvent event = entry.getValue();
            System.out.println("Id: " + event.getId() + ", Type: " + event.getEventType() + ", Data: " + event.getData());
        }

        System.out.println("--------------------------------------------------------------\n");
    }

}
