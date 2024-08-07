package faang.school.godbless.BJS2_20385;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<StreamEvent> list = new ArrayList<>();
        list.add(new StreamEvent(1, "A", "Test1"));
        list.add(new StreamEvent(2, "A", "Test2"));
        list.add(new StreamEvent(3, "B", "Test3"));
        list.add(new StreamEvent(4, "B", "Test4"));
        list.add(new StreamEvent(5, "C", "Test5"));

        Map<Integer, StreamEvent> mapIdKey = createMapIdKey(list);
        Map<String, List<StreamEvent>> mapTypeKey = createMapTypeKey(list);

        StreamEvent streamEvent6 = new StreamEvent(6, "B", "Test6");
        streamEvent6.addStreamEvent(mapIdKey, mapTypeKey);

        System.out.println(mapIdKey);
        System.out.println();
        System.out.println(mapTypeKey);
        System.out.println();

        Optional<StreamEvent> streamEvent7 = StreamEvent.getStreamEventById(mapIdKey, 1);
        streamEvent7.ifPresent(System.out::println);
        System.out.println();

        Optional<List<StreamEvent>> streamEvents1 = StreamEvent.getListOfStreamEventByType(mapTypeKey, "B");
        streamEvents1.ifPresent(System.out::println);
        System.out.println();

        list.get(4).removeStreamEventById(mapIdKey, mapTypeKey);

        System.out.println(mapIdKey);
        System.out.println();
        System.out.println(mapTypeKey);
        System.out.println();

        StreamEvent.printAllStreamEvents(mapIdKey);
    }

    public static Map<Integer, StreamEvent> createMapIdKey(List<StreamEvent> streamEvents) {
        Map<Integer, StreamEvent> mapIdKey = new HashMap<>();

        for (StreamEvent event : streamEvents) {
            mapIdKey.put(event.getId(), event);
        }

        return mapIdKey;
    }

    public static Map<String, List<StreamEvent>> createMapTypeKey(List<StreamEvent> streamEvents) {
        Map<String, List<StreamEvent>> mapTypeKey = new HashMap<>();

        for (StreamEvent event : streamEvents) {
            List<StreamEvent> currentStreamEvents = mapTypeKey.getOrDefault(event.getType(), new ArrayList<>());
            currentStreamEvents.add(event);
            mapTypeKey.put(event.getType(), currentStreamEvents);
        }

        return mapTypeKey;
    }
}
