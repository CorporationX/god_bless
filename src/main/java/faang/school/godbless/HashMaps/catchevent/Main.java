package faang.school.godbless.HashMaps.catchevent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<Integer, StreamEvent> events = new HashMap<>();
    private static final Map<String, List<StreamEvent>> eventTypeGroup = new HashMap<>();

    public static void main(String[] args) {
        addStreamEvent(new StreamEvent(1, "Сообщение", "Привет"));
        addStreamEvent(new StreamEvent(2, "Сообщение", "Пока"));
        addStreamEvent(new StreamEvent(3, "Уведомление", "Пора просыпаться"));
        addStreamEvent(new StreamEvent(4, "Уведомление", "Выполнен PR"));

        showStreamEvents();
        System.out.println(getStreamEvent(1));
        System.out.println(getStreamEvents("Сообщение"));
        removeStreamEvent(2);
        showStreamEvents();

    }

    public static void addStreamEvent(StreamEvent event) {
        events.put(event.id(), event);
        if (!eventTypeGroup.containsKey(event.eventType())) {
            eventTypeGroup.put(event.eventType(), new ArrayList<>(List.of(event)));
        } else {
            eventTypeGroup.get(event.eventType()).add(event);
        }
    }

    public static StreamEvent getStreamEvent(int id) {
        return events.get(id);
    }

    public static List<StreamEvent> getStreamEvents(String eventType) {
        return eventTypeGroup.get(eventType);
    }

    public static void removeStreamEvent(int id) {
        StreamEvent streamEvent = events.remove(id);
        List<StreamEvent> events =  eventTypeGroup.get(streamEvent.eventType());
        events.remove(streamEvent);
    }

    public static void showStreamEvents() {
        System.out.println("Вывод информации о событиях");
        for (Map.Entry<Integer, StreamEvent> event : events.entrySet()) {
            System.out.println("id=" + event.getValue().id() + ", eventType=" + event.getValue().eventType() +
                   ", Data=" + event.getValue().data());
        }
    }

}
