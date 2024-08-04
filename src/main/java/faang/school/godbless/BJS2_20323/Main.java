package faang.school.godbless.BJS2_20323;

import lombok.Getter;

import java.util.*;

@Getter
public class Main {
    private final Map<Integer, StreamEvent> eventsById = new HashMap<>();

    private final Map<String, List<StreamEvent>> eventsByTypes = new HashMap<>();

    {
        StreamEvent event1 = new StreamEvent(1, "SMS", "Списание средств: -50 р.");
        StreamEvent event2 = new StreamEvent(2, "Email", "Проверочный код: 12345.");
        StreamEvent event3 = new StreamEvent(3, "Post", "Повестка из военкомата");
        StreamEvent event4 = new StreamEvent(4, "Email", "Успешная регистрация на сервисе");
        StreamEvent event5 = new StreamEvent(5, "SMS", "Абнент 123 не в сети");
        StreamEvent event6 = new StreamEvent(6, "Post", "Письмо от приставов");

        eventsById.put(event1.getId(), event1);
        eventsById.put(event2.getId(), event2);
        eventsById.put(event3.getId(), event3);
        eventsById.put(event4.getId(), event4);
        eventsById.put(event5.getId(), event5);
        eventsById.put(event6.getId(), event6);

        eventsByTypes.put(event1.getEventType(), new ArrayList<>(Arrays.asList(event1, event5)));
        eventsByTypes.put(event2.getEventType(), new ArrayList<>(Arrays.asList(event2, event4)));
        eventsByTypes.put(event3.getEventType(), new ArrayList<>(Arrays.asList(event3, event6)));
    }

    public void addStreamEvent(StreamEvent streamEvent) {
        addStreamEventById(streamEvent);
        addStreamEventsByType(streamEvent);
    }

    public StreamEvent getStreamEventById(Integer id) {
        return eventsById.get(id);
    }

    public List<StreamEvent> getStreamEventsByType(String type) {
        return eventsByTypes.get(type);
    }

    public boolean deleteStreamEvent(Integer id) {
        StreamEvent event = deleteStreamEventById(id);
        if (event != null) {
            return deleteStreamEventByIdFromEventsByType(event);
        }
        return false;
    }

    public void printEvents() {
        for(Map.Entry<Integer, StreamEvent> event: eventsById.entrySet()) {
            System.out.println(event);
        }
    }

    private void addStreamEventById(StreamEvent streamEvent) {
        eventsById.put(streamEvent.getId(), streamEvent);
    }

    private void addStreamEventsByType(StreamEvent streamEvent) {
        eventsByTypes.merge(streamEvent.getEventType(), new ArrayList<>(List.of(streamEvent)),
                (x, y) -> {
                    x.addAll(y);
                    return x;
                }
        );
    }

    //удаление из первой мапы
    private StreamEvent deleteStreamEventById(Integer id) {
        return eventsById.remove(id);
    }

    //удаление из второй мапы
    private boolean deleteStreamEventByIdFromEventsByType(StreamEvent streamEvent) {
        List<StreamEvent> events = eventsByTypes.get(streamEvent.getEventType());
        for (StreamEvent event : events) {
            if (Objects.equals(event.getId(), streamEvent.getId())) {
                events.remove(event);
                return true;
            }
        }
        return false;
    }
}
