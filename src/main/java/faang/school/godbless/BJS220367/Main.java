package faang.school.godbless.BJS220367;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final Map<Integer, StreamEvent> events = new HashMap<>();
    public static final Map<String, List<StreamEvent>> streams = new HashMap<>();

    public static void main(String[] args) {
        addEvent(new StreamEvent(1, "Концерт", "Концерт Киркорова в Москве"));
        addEvent(new StreamEvent(2, "Концерт", "Концерт Баскова в Москве"));
        addEvent(new StreamEvent(3, "Опера", "Лебединое озеро"));

        allEvents();
        System.out.println(streams);

        System.out.println(getEvent(1));

        System.out.println(streamsByEventType("Концерт"));

        removeEvent(1);
        allEvents();
        System.out.println(streams);

    }

    public static void addEvent(StreamEvent event) {
        if (!events.containsKey(event.getId())) {
            events.put(event.getId(), event);
            addStream(event);
        } else {
            System.out.println("This event has already been added");
        }
    }

    public static void addStream(StreamEvent event) {
        if (!streams.containsKey(event.getEventType())) {
            List<StreamEvent> streamEvents = new ArrayList<>();
            streamEvents.add(event);
            streams.put(event.getEventType(), streamEvents);
        } else {
            streams.get(event.getEventType()).add(event);
        }
    }

    public static StreamEvent getEvent(int id) {
        return events.get(id);
    }

    public static List<StreamEvent> streamsByEventType(String eventType) {
        return streams.get(eventType);
    }

    public static void removeEvent(int id) {
        StreamEvent event = events.get(id);
        events.remove(id);
        streams.get(event.getEventType()).remove(event);
        if (streams.get(event.getEventType()).isEmpty()) {
            streams.remove(event.getEventType());
        }
    }

    public static void allEvents() {
        for (Map.Entry<Integer, StreamEvent> entry : events.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
