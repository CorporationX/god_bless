package faang.school.godbless.BJS2_20421;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Main {
    private static Map<Integer, StreamEvent> streamEventByID = new HashMap<>();
    private static Map<String, List<StreamEvent>> streamEventGroupsByType = new HashMap<>();

    private static void addStreamEvent(StreamEvent event) {
        streamEventByID.put(event.getId(), event);
        streamEventGroupsByType.computeIfAbsent(event.getEventType(), type -> new ArrayList<>()).add(event);
    }

    private static void searchStreamEventByID(int id) {
        StreamEvent event = streamEventByID.get(id);
        if (Objects.nonNull(event)) {
            System.out.println(event);
        } else {
            System.out.println("Event not found");
        }
    }

    private static void searchGroupStreamEventByType(String type) {
        List<StreamEvent> eventGroup = streamEventGroupsByType.get(type);
        if (Objects.nonNull(eventGroup)) {
            eventGroup.forEach(System.out::println);
        } else {
            System.out.println("Event group not found");
        }
    }

    private static void removeStreamEventByID(int id) {
        StreamEvent event = streamEventByID.remove(id);
        if (Objects.nonNull(event)) {
            streamEventGroupsByType.get(event.getEventType()).remove(event);
        }
    }

    private static void viewAllStreamEvent() {
        for (Map.Entry<Integer, StreamEvent> event : streamEventByID.entrySet()) {
            System.out.println(event.getKey() + "\t\t" + event.getValue().getEventType() + "\t\t" + event.getValue().getData());
        }
    }

    private static void viewAllStreamEventGroups() {
        for (Map.Entry<String, List<StreamEvent>> event : streamEventGroupsByType.entrySet()) {
            System.out.println(event.getKey() + ":");
            event.getValue().forEach(streamEvent -> System.out.println(streamEvent.getId() + "\t\t" + streamEvent.getData()));
        }
    }

    public static void main(String[] args) {
        addStreamEvent(new StreamEvent(1, "MESSAGE", "Hello, world!"));
        addStreamEvent(new StreamEvent(2, "UPDATE", "New user joined."));
        addStreamEvent(new StreamEvent(3, "MESSAGE", "How is everyone doing?"));
        addStreamEvent(new StreamEvent(4, "UPDATE", "Server status: online."));
        addStreamEvent(new StreamEvent(5, "MESSAGE", "Nice weather today."));
        addStreamEvent(new StreamEvent(6, "UPDATE", "10 new messages received."));
        addStreamEvent(new StreamEvent(7, "MESSAGE", "Anyone up for a game?"));
        addStreamEvent(new StreamEvent(8, "UPDATE", "Total users: 25"));
        addStreamEvent(new StreamEvent(9, "MESSAGE", "Good night!"));
        addStreamEvent(new StreamEvent(10, "UPDATE", "Server will restart in 5 minutes."));
        viewAllStreamEvent();
        System.out.println();
        viewAllStreamEventGroups();
        System.out.println();

        removeStreamEventByID(5);
        removeStreamEventByID(4);
        removeStreamEventByID(10);
        viewAllStreamEvent();
        System.out.println();
        viewAllStreamEventGroups();
        System.out.println();

        searchGroupStreamEventByType("MESSAGE");
        searchGroupStreamEventByType("RESPONCE");
        searchStreamEventByID(1);
        searchStreamEventByID(5);
        System.out.println();
    }
}
