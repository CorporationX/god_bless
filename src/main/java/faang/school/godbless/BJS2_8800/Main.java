package faang.school.godbless.BJS2_8800;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    static Map<Integer, StreamEvent> eventsByID = new HashMap<>();
    static Map<String, List<StreamEvent>> eventsByName = new HashMap<>();

    public static void main(String[] args) {
        StreamEvent streamEvent_1 = new StreamEvent(6, "test", "module testing");
        StreamEvent streamEvent_2 = new StreamEvent(9, "error", "system error");
        StreamEvent streamEvent_3 = new StreamEvent(53, "error", "program error");
        StreamEvent streamEvent_4 = new StreamEvent(24, "build", "success");
        StreamEvent streamEvent_5 = new StreamEvent(16, "review", "success");

        addStreamEvent(streamEvent_1);
        addStreamEvent(streamEvent_2);
        addStreamEvent(streamEvent_3);
        addStreamEvent(streamEvent_4);
        addStreamEvent(streamEvent_5);

        System.out.println(eventsByID);
        System.out.println("****************************");
        System.out.println(eventsByName);
        System.out.println("*****************************");

        printStreamEvents();

        System.out.println("поиск по id: " + findEventByID(16));
        System.out.println("поиск по id: " + findEventByID(17));
        System.out.println("поиск по типу события: " + findEventByType("error"));

        deleteEventByID(9);
        deleteEventByID(24);

        System.out.println(eventsByID);
        System.out.println("****************************");
        System.out.println(eventsByName);
        System.out.println("*****************************");

        printStreamEvents();
    }

    public static void addStreamEvent(StreamEvent event) {
        if (event != null) {
            eventsByID.put(event.getId(), event);

            List<StreamEvent> refreshingListEvent = eventsByName.getOrDefault(event.getEventType(), new ArrayList<>());
            refreshingListEvent.add(event);
            eventsByName.put(event.getEventType(), refreshingListEvent);
        }
    }

    public static StreamEvent findEventByID(int id) {
        return eventsByID.getOrDefault(id, new StreamEvent(999, "error", "this ID does not exist"));
    }

    public static List<StreamEvent> findEventByType(String type) {
        if (type != null) {
            return eventsByName.getOrDefault(type, new ArrayList<>());
        } else {
        return List.of();
        }
    }

    public static void deleteEventByID(int id) {
        if (eventsByID.containsKey(id)) {
            StreamEvent deletedEvent = eventsByID.remove(id);
            eventsByName.entrySet().stream()
                    .filter(node -> node.getValue().contains(deletedEvent))
                    .forEach(node -> node.getValue().remove(deletedEvent));
        }
    }

    public static void printStreamEvents() {
        eventsByID.entrySet()
                .forEach(System.out::println);
    }

}
