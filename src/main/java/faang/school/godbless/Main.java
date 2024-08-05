package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static Map<Integer, StreamEvent> streamIdEventsMap = new HashMap<>();
    private static Map<String, List<StreamEvent>> streamTypeListMap = new HashMap<>();

    public static void main(String[] args) {
        StreamEvent event1 = new StreamEvent(1, "type1", "data1");
        StreamEvent event2 = new StreamEvent(2, "type1", "data2");
        StreamEvent event3 = new StreamEvent(3, "type2", "data3");

        addNewStreamEvent(event1);
        addNewStreamEvent(event2);
        addNewStreamEvent(event3);

        printAllStreamEvents();

        System.out.println(getStreamEventById(1));

        System.out.println(getStreamEventsByType("type1"));

        deleteStreamEventById(2);

        printAllStreamEvents();

        deleteStreamEventById(1);

        printAllStreamEvents();
    }

    public static void addNewStreamEvent(StreamEvent streamEvent) {
        if (streamIdEventsMap.containsKey(streamEvent.getId())) {
            return;
        }
        streamIdEventsMap.put(streamEvent.getId(), streamEvent);
        streamTypeListMap.computeIfAbsent(streamEvent.getEventType(), k -> new ArrayList<>()).add(streamEvent);
    }

    public static StreamEvent getStreamEventById(int id) {
        if (streamIdEventsMap.containsKey(id)) {
            return streamIdEventsMap.get(id);
        }
        return null;
    }

    public static List<StreamEvent> getStreamEventsByType(String eventType) {
        if (streamTypeListMap.containsKey(eventType)) {
            return streamTypeListMap.get(eventType);
        }
        return null;
    }

    public static void deleteStreamEventById(int id) {
        streamIdEventsMap.remove(id);
        List<String> keysToDelete = new ArrayList<>();
        for (Map.Entry<String, List<StreamEvent>> entry : streamTypeListMap.entrySet()) {
            String eventType = entry.getKey();
            List<StreamEvent> eventList = entry.getValue();

            eventList.removeIf(event -> {
                boolean remove = event.getId() == id;
                if (remove) {
                    System.out.println("Событие с номером " + id + " типа " + eventType + " удалено из потока");
                }
                return remove;
            });
            if (eventList.isEmpty()) {
                keysToDelete.add(eventType);
            }
        }
        for (String key : keysToDelete) {
            streamTypeListMap.remove(key);
            System.out.println("Удален тип события " + key);
        }
    }

    public static void printAllStreamEvents() {
        for (Map.Entry<Integer, StreamEvent> entry : streamIdEventsMap.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
