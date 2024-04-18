package faang.school.godbless.BJS2_4283;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Main {
    private static final Map<Integer, StreamEvent> EVENTS = new HashMap<>();
    private static final Map<String, List<StreamEvent>> STREAMS_EVENT = new HashMap<>();

    public static void main(String[] args) {
        StreamEvent conference = new StreamEvent("Conference", "IT Conference");
        StreamEvent workShop = new StreamEvent("WorkShops", "Stream Workshop");
        StreamEvent seminar = new StreamEvent("Conference", "Bio seminar");

        addEvent(conference);
        findEventById(conference.getId());
        findStreamsEventByType(conference.getEventType());

        addEvent(workShop);
        addEvent(seminar);

        findStreamsEventByType(seminar.getEventType());

        removeEvent(seminar.getId());

        findStreamsEventByType(seminar.getEventType());
    }

    private static void addEvent(StreamEvent event) {
        validateEvent(event);
        EVENTS.putIfAbsent(event.getId(), event);
        STREAMS_EVENT.putIfAbsent(event.getEventType(), new ArrayList<>(List.of(event)));
        if (!STREAMS_EVENT.get(event.getEventType()).contains(event)) {
            STREAMS_EVENT.computeIfPresent(event.getEventType(), (type, events) -> {
                events.add(event);
                return events;
            });
        }
    }

    private static void findEventById(Integer id) {
        System.out.println(EVENTS.get(id));
    }

    private static void findStreamsEventByType(String eventType) {
        if (eventType.isBlank()) {
            throw new IllegalArgumentException("Invalid eventType data");
        }
        System.out.println(STREAMS_EVENT.get(eventType));
    }

    private static void removeEvent(Integer id) {
        StreamEvent event = EVENTS.get(id);
        validateEvent(event);
        EVENTS.remove(id);
        STREAMS_EVENT.computeIfPresent(event.getEventType(), (type, events) -> {
            events.remove(event);
            return events;
        });
    }

    private static void validateEvent(StreamEvent event) {
        if (Objects.isNull(event)) {
            throw new IllegalArgumentException("Event not found");
        }
    }
}
