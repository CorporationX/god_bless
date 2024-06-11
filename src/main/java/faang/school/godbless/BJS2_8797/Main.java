package faang.school.godbless.BJS2_8797;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<Integer, StreamEvent> streamEvents = new HashMap<>();
    private  static final Map<String, List<StreamEvent>> streamEventTypes = new HashMap<>();

    public static void main(String[] args) {
        addStreamEvent(1, "run", "someData1");
        addStreamEvent(2, "run", "someData2");
        addStreamEvent(3, "run", "someData3");
        addStreamEvent(4, "wait", "someData4");
        addStreamEvent(5, "wait", "someData5");
        addStreamEvent(6, "wait", "someData6");

        printInfoAboutAllStreamEvents();
        System.out.println();

        System.out.println(findStreamEvent(4));
        System.out.println();

        System.out.println(findStreamEventList("run"));
        System.out.println();

        removeStreamEvent(3);

        printInfoAboutAllStreamEvents();

    }

    public static void addStreamEvent(Integer id, String eventType, String data) {
        streamEvents.put(id, new StreamEvent(id, eventType, data));
        streamEventTypes.computeIfAbsent(eventType, (key) -> new ArrayList<>()).add(new StreamEvent(id, eventType, data));
    }

    public static StreamEvent findStreamEvent(Integer id) {

        if (!streamEvents.containsKey(id)) {
            System.out.println("Can't find stream event" + id);
            return null;
        }

        return streamEvents.get(id);
    }

    public static List<StreamEvent> findStreamEventList(String eventType) {

        if (!streamEventTypes.containsKey(eventType)) {
            System.out.println("Can't find stream event list " + eventType);
            return null;
        }

        return streamEventTypes.get(eventType);
    }

    public static void removeStreamEvent(Integer id) {

        if (!streamEvents.containsKey(id)) {
            System.out.println("Can't remove stream event list " + id);
        } else {
            // если событие есть в streamEvents, то оно точно есть в streamEventsType

            StreamEvent streamEvent = streamEvents.get(id);
            String streamEventType = streamEvent.getEventType();

            streamEvents.remove(id);
            streamEventTypes.get(streamEventType).remove(streamEvent);
        }
    }

    public static void printInfoAboutAllStreamEvents() {

        for (var streamEvent: streamEvents.entrySet()) {
            System.out.println("Id: " + streamEvent.getKey() +
                    "\nEvent type: " + streamEvent.getValue().getEventType() +
                    "\nData: " + streamEvent.getValue().getData());

            System.out.println("-".repeat(20));
        }
    }
}
