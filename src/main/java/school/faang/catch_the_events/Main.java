package school.faang.catch_the_events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final Map<Integer, StreamEvent> STREAM_EVENTS = new HashMap<>();
    public static final Map<String, ArrayList<StreamEvent>> EVENT_TYPES = new HashMap<>();

    public static void main(String[] args) {
        StreamEvent post = new StreamEvent("Post Events", "Creating a post");
        StreamEvent like = new StreamEvent("Likes Events", "The post got a like");
        StreamEvent comment = new StreamEvent("Comments Events", "The post received a comment");
        StreamEvent popComment = new StreamEvent("Comments Events", "The post received a popular comment");

        addNewEvent(post);
        addNewEvent(like);
        addNewEvent(comment);
        addNewEvent(popComment);

        printAllEvents();
        System.out.println("---------------");

        System.out.println(getEventById(2));
        System.out.println("---------------");

        List<StreamEvent> eventsByType = getEventListByType("Comments Events");
        for (var event : eventsByType) {
            System.out.println(event);
        }
        System.out.println("---------------");

        removeEventById(1);
        for (var entry : STREAM_EVENTS.entrySet()) {
            System.out.println("Event ID: " + entry.getKey() + " " + entry.getValue());
        }
        for (var entry : EVENT_TYPES.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static void addNewEvent(StreamEvent event) {
        STREAM_EVENTS.put(event.getId(), event);
        EVENT_TYPES.computeIfAbsent(event.getEventType(), eventType -> new ArrayList<>()).add(event);
    }

    public static StreamEvent getEventById(Integer id) {
        return STREAM_EVENTS.get(id);
    }

    public static ArrayList<StreamEvent> getEventListByType(String eventType) {
        ArrayList<StreamEvent> streamsByType = EVENT_TYPES.get(eventType);
        return streamsByType;
    }

    public static void removeEventById(Integer id) {
        StreamEvent eventForDelete = STREAM_EVENTS.get(id);
        String eventTypeForDelete = eventForDelete.getEventType();
        if (eventTypeForDelete != null) {
            EVENT_TYPES.remove(eventTypeForDelete);
            STREAM_EVENTS.remove(id);
        }
    }

    public static void printAllEvents() {
        for (var entry : STREAM_EVENTS.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
