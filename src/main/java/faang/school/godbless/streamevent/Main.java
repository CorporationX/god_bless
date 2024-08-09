package faang.school.godbless.streamevent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StreamEventService streamEventService = new StreamEventService();
        Map<Integer, StreamEvent> eventsMap = new HashMap<>();
        Map<String, List<StreamEvent>> eventsTypeMap = new HashMap<>();

        streamEventService.addEvent(eventsMap, eventsTypeMap, new StreamEvent(1, "Add", "Add Message"));
        streamEventService.addEvent(eventsMap, eventsTypeMap, new StreamEvent(2, "Update", "Update Message"));
        streamEventService.addEvent(eventsMap, eventsTypeMap, new StreamEvent(3, "Delete", "Delete Message"));
        streamEventService.addEvent(eventsMap, eventsTypeMap, new StreamEvent(4, "Add", "Add Message2"));
        streamEventService.addEvent(eventsMap, eventsTypeMap, new StreamEvent(5, "Update", "Update Message2"));

        streamEventService.eventsInfo(eventsMap);
        System.out.println();

        System.out.println(streamEventService.findEventById(eventsMap, 1));
        System.out.println(streamEventService.findEventById(eventsMap, 5) + "\n");

        System.out.println(streamEventService.findEventsByType(eventsTypeMap, "Update"));
        System.out.println(streamEventService.findEventsByType(eventsTypeMap, "Delete") + "\n");

        streamEventService.findEventById(eventsMap, 100);
        streamEventService.findEventsByType(eventsTypeMap, "InvalidType");

        streamEventService.removeEvent(eventsMap, eventsTypeMap, 3);
        streamEventService.removeEvent(eventsMap, eventsTypeMap, 4);
        streamEventService.removeEvent(eventsMap, eventsTypeMap, 4);

        streamEventService.eventsInfo(eventsMap);
    }
}
