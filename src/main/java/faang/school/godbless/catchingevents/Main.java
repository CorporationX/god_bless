package faang.school.godbless.catchingevents;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final Map<Integer, StreamEvent> ID_STREAM_EVENT = new HashMap<>();
    private static final Map<String, List<StreamEvent>> STREAM_EVENT_GROUPING_TYPE = new HashMap<>();
    private static final Map<StreamEvent, Integer> STREAM_EVENT_INDEXES = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("addStreamEvent");
        addStreamEvent(new StreamEvent("meetUp", "Finance"));
        addStreamEvent(new StreamEvent("meetUp", "Balance"));
        addStreamEvent(new StreamEvent("daily", "Java Core"));
        addStreamEvent(new StreamEvent("daily", "HashMap"));

        printAllStreamEvent();
        System.out.println("-------------------------");
        System.out.println();

        System.out.println("getById 3");
        System.out.println(getStreamEventById(3));
        System.out.println("-------------------------");
        System.out.println();

        System.out.println("get by type daily");
        getListOfStreamEventByType("daily").forEach(System.out::println);
        System.out.println("-------------------------");
        System.out.println();

        System.out.println("test delete by ID 2");
        deleteStreamEventById(2);
        printAllStreamEvent();
        System.out.println("test STREAM_EVENT_GROUPING_TYPE after delete");
        STREAM_EVENT_GROUPING_TYPE.values().stream().flatMap(Collection::stream).forEach(System.out::println);

    }

    public static void addStreamEvent(StreamEvent streamEvent) {
        ID_STREAM_EVENT.put(streamEvent.getId(), streamEvent);
        STREAM_EVENT_GROUPING_TYPE.computeIfAbsent(streamEvent.getEventType(), key -> new ArrayList<>())
                .add(streamEvent);

        STREAM_EVENT_INDEXES.put(streamEvent, STREAM_EVENT_GROUPING_TYPE.get(streamEvent.getEventType()).size() - 1);
    }

    public static StreamEvent getStreamEventById(int id) {
        return ID_STREAM_EVENT.get(id);
    }

    public static List<StreamEvent> getListOfStreamEventByType(String type) {
        return STREAM_EVENT_GROUPING_TYPE.get(type);
    }

    public static void deleteStreamEventById(int id) {
        StreamEvent streamEvent = ID_STREAM_EVENT.get(id);
        ID_STREAM_EVENT.remove(streamEvent.getId());
        STREAM_EVENT_GROUPING_TYPE.get(streamEvent.getEventType()).remove((int) STREAM_EVENT_INDEXES.get(streamEvent));
    }

    public static void printAllStreamEvent() {
        ID_STREAM_EVENT.values().forEach(System.out::println);
    }
}
