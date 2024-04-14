package faang.school.godbless.JavaHashMap.task5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {
    private static final Map<Integer, StreamEvent> ID_EVENT = new HashMap<>();
    private static final Map<String, List<StreamEvent>> LIST_EVENT = new HashMap<>();

    public static void main(String[] args) {
        StreamEvent streamOne = new StreamEvent(1212, "Type one", "Data one");
        StreamEvent streamTwo = new StreamEvent(1111, "Type two", "Data two");
        StreamEvent streamThree = new StreamEvent(2121, "Type three", "Data three");

        addStreamEvent(streamOne);
        addStreamEvent(streamTwo);
        addStreamEvent(streamThree);
        printAllStreamEvents();
        removeEventById(2121);
        printAllStreamEvents();
        System.out.println(findEventById(1111));
        System.out.println(findEventByType("Type one"));

    }

    public static void addStreamEvent(StreamEvent event) {
        ID_EVENT.put(event.getId(), event);
        LIST_EVENT.computeIfAbsent(event.getEventType(), k -> new ArrayList<>()).add(event);
    }

    public static StreamEvent findEventById(int id) {
        return ID_EVENT.get(id);
    }

    public static List<StreamEvent> findEventByType(String eventType) {
        return LIST_EVENT.getOrDefault(eventType, new ArrayList<>());
    }

    public static void removeEventById(int id) {
        StreamEvent event = ID_EVENT.remove(id);
        if (event != null) {
            List<StreamEvent> eventsType = LIST_EVENT.get(event.getEventType());
            if (eventsType != null) {
                eventsType.remove(event);
            }
        }
    }

    public static void printAllStreamEvents() {
        System.out.println("Все события потока : ");
        for (Map.Entry<Integer, StreamEvent> entry : ID_EVENT.entrySet()) {
            StreamEvent event = entry.getValue();
            System.out.println("ID - " + event.getId() + " Тип события - " + event.getEventType() + " Данные события - " + event.getData());
        }
    }
}
