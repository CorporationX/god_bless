package faang.school.godbless.CatchingEvents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static Map<Integer, StreamEvent> streamEventMap = new HashMap<>();
    public static Map<String, List<StreamEvent>> stringListMap = new HashMap<>();

    public static void main(String[] args) {
        addEvent(1, "Концерт", "10.12");
        addEvent(2, "Концерт", "17.12");
        addEvent(3, "Лекция", "12.12");
        addEvent(4, "Лекция", "15.12");
        addEvent(5, "Спектакль", "27.12");
        printInfo();
        System.out.println(searchById(3) + " - поиск по id");
        System.out.println(searchByEventType("Концерт") + " - поиск по типу");

        deleteEvent(1);
        printInfo();

    }

    public static void addEvent(int id, String eventType, String data) {
        StreamEvent streamEvent = new StreamEvent(id, eventType, data);
        streamEventMap.put(id, streamEvent);
        if (!stringListMap.containsKey(eventType)) {
            stringListMap.put(eventType, new ArrayList<>());
        }
        stringListMap.get(eventType).add(streamEvent);
    }

    public static StreamEvent searchById(int id) {
        return streamEventMap.get(id);
    }

    public static List<StreamEvent> searchByEventType(String eventType) {
        return stringListMap.get(eventType);
    }

    public static void deleteEvent(int id) {
        StreamEvent delEvent = streamEventMap.remove(id);
        stringListMap.get(delEvent.getEventType()).remove(delEvent);
    }

    public static void printInfo() {
        System.out.println("События первого потока:");
        for (Map.Entry<Integer, StreamEvent> entry : streamEventMap.entrySet()) {
            System.out.println(entry.getValue());
        }
        System.out.println("События второго потока:");
        for (Map.Entry<String, List<StreamEvent>> entry : stringListMap.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
