package catchingEvents;


/**
 * ВОПРОС
 *
 * Плохо ли что методы для добавления, печати и т.д я реализовала в этом классе?
 * Или нужно было отдельный класс для работы с потоками создать?
 */

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Getter
@EqualsAndHashCode
@ToString
public class StreamEvent {

    private int id;
    private String eventType;
    private String data;

    public StreamEvent(int id, String eventType, String data) {
        checkStreamEvent(id, eventType, data);
        this.id = id;
        this.eventType = eventType;
        this.data = data;
    }

    public void checkStreamEvent(Integer id, String eventType, String data) {
        if (id < 0) {
            throw new IllegalArgumentException("Id мень нуля");
        }
        if (eventType.isEmpty() || eventType.isBlank()) {
            throw new IllegalArgumentException("Не указан тип события");
        }
        if (data.isEmpty() || data.isBlank()) {
            throw new IllegalArgumentException("Не указаны данные события");
        }
    }

    public static int sum(int a, int b) {
        return a + b;
    }

    public static void addStreamEvent(Map<Integer, StreamEvent> streamEventMap,
                                      Map<String, List<StreamEvent>> specificStreamMap, StreamEvent newEvent) {
        streamEventMap.put(newEvent.getId(), newEvent);
        List<StreamEvent> eventList = specificStreamMap.computeIfAbsent(newEvent.getEventType(), eventType -> new ArrayList<>());
        eventList.add(newEvent);
    }

    public static StreamEvent findStreamEvent(Integer id, Map<Integer, StreamEvent> streamEventMap) {
        return streamEventMap.get(id);
    }

    public static void removeStreamEvent(Integer id, Map<Integer, StreamEvent> streamEventMap,
                                         Map<String, List<StreamEvent>> specificStreamMap) {
        String typeToRemove = streamEventMap.get(id).getEventType();
        streamEventMap.remove(id);

        List<StreamEvent> eventList = specificStreamMap.get(typeToRemove);
        List<StreamEvent> eventsToRemove = new ArrayList<>();

        for (StreamEvent streamEvent : eventList) {
            if (id.equals(streamEvent.getId())) {
                eventsToRemove.add(streamEvent);
            }
        }

        for (StreamEvent eventRe : eventsToRemove) {
            eventList.remove(eventRe);
        }

    }

    public static List<StreamEvent> findStreamEventList(String eventType, Map<String, List<StreamEvent>> specificStreamEventMap) {
        return specificStreamEventMap.get(eventType);
    }

    public static void printAllStreamEventMap(Map<Integer, StreamEvent> streamEventMap) {

        System.out.println("------");
        for (Map.Entry<Integer, StreamEvent> entry : streamEventMap.entrySet()) {
            StreamEvent streamEvent = entry.getValue();
            System.out.println("ID:" + entry.getKey() + "\t\tтипы событий:" + streamEvent.getEventType()
                    + "\t\tданные событий:" + streamEvent.getData());
        }
        System.out.println("------");
    }

    public static void printSpecificEventMap(Map<String, List<StreamEvent>> specificStreamMap) {
        System.out.println("------");
        for (Map.Entry<String, List<StreamEvent>> entry : specificStreamMap.entrySet()) {
            System.out.println("Ключ:" + entry.getKey() + "\t\tСписок: " + entry.getValue());
        }
        System.out.println("------");
    }
}
