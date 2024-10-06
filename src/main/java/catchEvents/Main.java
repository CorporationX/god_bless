package catchEvents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<Integer, StreamEvent> EVENTS = new HashMap<>();
    private static final Map<String, List<StreamEvent>> EVENTS_BY_TYPE = new HashMap<>();

    public static void main(String[] args) {

        addEvent("event1", "data1");
        addEvent("event2", "data2");
        addEvent("event1", "data3");
        addEvent("event3", "data4");
        addEvent("event3", "data5");
        System.out.println("События: ");
        printAllStreamEvents();

        System.out.println("\nВывод событий по типу событий: ");
        EVENTS_BY_TYPE.forEach((k,v) -> System.out.println("тип события: " + k + ", события: " + v.toString()));

        System.out.println("\nВывод события id: 2");
        System.out.println(findEventByID(2).toString());

        System.out.println("\nПосле удаление события id: 5");
        removeEvent(5);
        printAllStreamEvents();

        System.out.println("\nПоиск события по типу события event3");
        System.out.println(findEventsByType("event3").toString());
    }

    public static void addEvent(String eventType, String data) {
        StreamEvent event = new StreamEvent(eventType, data);
        EVENTS.putIfAbsent(event.getId(), event);
        EVENTS_BY_TYPE.computeIfAbsent(eventType, k -> new ArrayList<>()).add(event);
    }

    public static StreamEvent findEventByID(int id) {
        return EVENTS.get(id);
    }

    public static List<StreamEvent> findEventsByType(String eventType) {
        return EVENTS_BY_TYPE.get(eventType);
    }

    public static void removeEvent(Integer id) {
        StreamEvent event = EVENTS.remove(id);
        EVENTS_BY_TYPE.get(event.getEventType()).remove(event);
    }

    public static void printAllStreamEvents(){
        for(Map.Entry<Integer, StreamEvent> entry : EVENTS.entrySet()) {
            System.out.println(
                    "ID: " + entry.getKey() +
                    ", тип события: " + entry.getValue().getEventType() +
                    ", данные: " + entry.getValue().getData());
        }
    }

}
