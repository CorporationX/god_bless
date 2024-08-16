package faang.school.godbless.Maps.BJS2_20507;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static Map<Integer, StreamEvent> streamEventMap = new HashMap<>();
    private static Map<String, List<StreamEvent>> eventGroupByTipe = new HashMap<>();
    private static Map<Integer, Integer> indexById = new HashMap<>();

    public static void main(String[] args) {
        List<StreamEvent> streamEventList = new ArrayList<>();
        StreamEvent streamEventGet = new StreamEvent("get");
        StreamEvent streamEventPut = new StreamEvent("put");
        StreamEvent streamEventSecondGet = new StreamEvent("get");
        StreamEvent streamEventSecondPut = new StreamEvent("put");
        streamEventList.add(streamEventGet);
        streamEventList.add(streamEventPut);
        streamEventList.add(streamEventSecondGet);
        streamEventList.add(streamEventSecondPut);

        for (StreamEvent se : streamEventList) {
            addStreamEvent(se);
        }

        System.out.println(eventGroupByTipe);

        removeStreamEvent(streamEventSecondGet.getId());

        System.out.println(eventGroupByTipe);
        printAllStreamEvents();
    }

    public static void addStreamEvent(StreamEvent event) {
        streamEventMap.put(event.getId(), event);

        eventGroupByTipe.computeIfAbsent(event.getEventType(), k -> new ArrayList<>());
        eventGroupByTipe.get(event.getEventType()).add(event);
        indexById.put(event.getId(), eventGroupByTipe.get(event.getEventType()).indexOf(event));
    }

    public static void removeStreamEvent(int id) {
        findGroupByType(findByID(id).getEventType()).remove((int) indexById.get(id));
        streamEventMap.remove(id);
    }

    public static StreamEvent findByID(int id) {
        return streamEventMap.get(id);
    }

    public static List<StreamEvent> findGroupByType(String type) {
        return eventGroupByTipe.get(type);

    }

    public static void printAllStreamEvents() {
        for (Map.Entry<Integer, StreamEvent> entry : streamEventMap.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
