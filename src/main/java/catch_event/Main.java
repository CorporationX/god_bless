package catch_event;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    @Getter
    private static final Map<Integer, StreamEvent> streamEvents = new HashMap<>();
    @Getter
    private static final Map<String, List<StreamEvent>> eventsByUser = new HashMap<>();

    public static void main(String[] args) {;
        addNewEvent(new StreamEvent(1, "user.created", "John"));
        addNewEvent(new StreamEvent(2, "user.created", "Kate"));
        addNewEvent(new StreamEvent(3, "user.login", "Kate"));

        System.out.println(streamEvents);
        System.out.println(eventsByUser);

        searchEventByID(1);

        searchEventsByType("user.login");

        removeEventByID(2);

        System.out.println(streamEvents);
        System.out.println(eventsByUser);

        printAllInfo();
    }

    public static void addNewEvent(StreamEvent streamEvent) {
        streamEvents.put(streamEvent.getId(), streamEvent);
        eventsByUser.computeIfAbsent(streamEvent.getEventType(), k -> new ArrayList<>()).add(streamEvent);
    }

    public static void searchEventByID(int id) {
        System.out.println(streamEvents.get(id));
    }

    public static void searchEventsByType(String eventType) {
        System.out.println(eventsByUser.get(eventType));
    }

    public static void removeEventByID(int id) {
        streamEvents.remove(id);
        eventsByUser.values().forEach(list -> list.removeIf(event -> event.getId() == id));
    }

    public static void printAllInfo() {
        for (Map.Entry<Integer, StreamEvent> entry : streamEvents.entrySet()) {
            System.out.println("ID: " + entry.getKey() + ", type: " + entry.getValue().getEventType() + ", data: " + entry.getValue().getData());
        }
    }
}
