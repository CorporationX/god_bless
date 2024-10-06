package school.faang.catchtheevents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static school.faang.catchtheevents.StreamEventService.addNewEvent;
import static school.faang.catchtheevents.StreamEventService.getEventById;
import static school.faang.catchtheevents.StreamEventService.getEventListByType;
import static school.faang.catchtheevents.StreamEventService.printAllEvents;
import static school.faang.catchtheevents.StreamEventService.removeEventById;

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
}
