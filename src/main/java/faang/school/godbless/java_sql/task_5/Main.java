package faang.school.godbless.java_sql.task_5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    static ArrayList<StreamEvent> streamEvents = ProvideStreamEvents.provideStreamEvents();
    static HashMap<Integer, StreamEvent> streamEventsById =
            StreamEventUtils.getStreamEventsById(streamEvents);
    static HashMap<String, List<StreamEvent>> streamEventsGroupedByEventTypes =
            StreamEventUtils.getStreamEventsGroupedByEventTypes(streamEvents);

    public static void main(String[] args) {
        var streamEvent = new StreamEvent(6, ProvideStreamEvents.EVENT_TYPES[0], "Data 6");
        addStreamEvent(streamEvent);
        System.out.println(getStreamEventById(streamEvent.id()));
        System.out.println("-----------------------");
        printStreamEvents();
        System.out.println("-----------------------");
        deleteStreamEvent(streamEvent);
        printStreamEvents();
        System.out.println("-----------------------");
        System.out.println(getStreamEventsByEventType(ProvideStreamEvents.EVENT_TYPES[0]));
        System.out.println("-----------------------");

    }

    static void updateData() {
        streamEventsById = StreamEventUtils.getStreamEventsById(streamEvents);
        streamEventsGroupedByEventTypes =
                StreamEventUtils.getStreamEventsGroupedByEventTypes(streamEvents);
    }

    static void addStreamEvent(StreamEvent streamEvent) {
        streamEvents.add(streamEvent);
        updateData();
    }

    static void deleteStreamEvent(StreamEvent streamEvent) {
        streamEvents.remove(streamEvent);
        updateData();
    }

    static StreamEvent getStreamEventById(int id) {
        return streamEventsById.get(id);
    }

    static List<StreamEvent> getStreamEventsByEventType(String eventType) {
        return streamEventsGroupedByEventTypes.get(eventType);
    }

    static void printStreamEvents() {
        StreamEventUtils.printStreamEvents(streamEventsGroupedByEventTypes);
    }
}
