package faang.school.godbless.catchingEvents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    static HashMap<Integer, StreamEvent> mapStreamEvents = new HashMap<>();
    static HashMap<String, List<StreamEvent>> mapListsStreamEvents = new HashMap<>();
    public static void main(String[] args) {
        addNewStreamEvent(new StreamEvent(1, "быстрый", "111"));
        addNewStreamEvent(new StreamEvent(2, "быстрый", "222"));
        addNewStreamEvent(new StreamEvent(3, "медленный", "333"));
        addNewStreamEvent(new StreamEvent(4, "быстрый", "444"));
        addNewStreamEvent(new StreamEvent(5, "средний", "555"));
        addNewStreamEvent(new StreamEvent(6, "средний", "666"));
        addNewStreamEvent(new StreamEvent(7, "средний", "777"));
        addNewStreamEvent(new StreamEvent(8, "медленный", "888"));
        System.out.println(getAllStreamEvents());

        removeStreamEventById(1);
        removeStreamEventById(2);
        System.out.println(getAllStreamEvents());

        System.out.println(getStreamEventById(3));

        System.out.println(getStreamEventByEventType("средний"));
    }

    public static void addNewStreamEvent(StreamEvent streamEvent) {
        mapStreamEvents.put(streamEvent.getId(), streamEvent);
        mapListsStreamEvents.putIfAbsent(streamEvent.getEventType(), new ArrayList<>());
        mapListsStreamEvents.get(streamEvent.getEventType()).add(streamEvent);
    }

    public static StreamEvent getStreamEventById(Integer id) {
        return mapStreamEvents.get(id);
    }

    public static List<StreamEvent> getStreamEventByEventType(String eventType) {
        return mapListsStreamEvents.get(eventType);
    }

    public static void removeStreamEventById(Integer id) {
        StreamEvent streamEvent = mapStreamEvents.get(id);
        mapListsStreamEvents.get(streamEvent.getEventType()).remove(streamEvent);
        mapStreamEvents.remove(id);
    }

    public static Set<Map.Entry<Integer, StreamEvent>> getAllStreamEvents() {
        return mapStreamEvents.entrySet();
    }
}
