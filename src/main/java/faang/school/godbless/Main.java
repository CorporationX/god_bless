package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final Map<Integer, StreamEvent> STREAM_ID_EVENT_MAP = new HashMap<>();
    private static final Map<String, List<StreamEvent>>  STREAM_TYPE_LIST_MAP = new HashMap<>();

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
        if (STREAM_ID_EVENT_MAP.containsKey(streamEvent.getId())) {
            return;
        }
        STREAM_ID_EVENT_MAP.put(streamEvent.getId(), streamEvent);
        STREAM_TYPE_LIST_MAP.computeIfAbsent(streamEvent.getEventType(), k -> new ArrayList<>()).add(streamEvent);
    }

    public static StreamEvent getStreamEventById(int id) {
        if (STREAM_ID_EVENT_MAP.containsKey(id)) {
            return STREAM_ID_EVENT_MAP.get(id);
        }
        return null;
    }

    public static List<StreamEvent> getStreamEventsByType(String eventType) {
        if (STREAM_TYPE_LIST_MAP.containsKey(eventType)) {
            return STREAM_TYPE_LIST_MAP.get(eventType);
        }
        return null;
    }

    public static void deleteStreamEventById(int id) {
        STREAM_ID_EVENT_MAP.remove(id);
        List<String> keysToDelete = new ArrayList<>();
        for (Map.Entry<String, List<StreamEvent>> entry : STREAM_TYPE_LIST_MAP.entrySet()) {
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
            STREAM_TYPE_LIST_MAP.remove(key);
            System.out.println("Удален тип события " + key);
        }
    }

    public static void printAllStreamEvents() {
        for (Map.Entry<Integer, StreamEvent> entry : STREAM_ID_EVENT_MAP.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
