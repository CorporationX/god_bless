package cathing.events;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class StreamEvent {
    private int id;
    private String eventType;
    private String data;

    public static void getEventById(Map<Integer, StreamEvent> map, int id) {
        if (map.containsKey(id)) {
            map.get(id);
        } else {
            throw new IllegalArgumentException("Событие не найдено");
        }
    }

    @Override
    public String toString() {
        return "ID События: " + id +
                ", Тип: " + eventType +
                ", Данные: " + data;
    }

    public static void addEvent(Map<Integer, StreamEvent> map, Map<String, List<StreamEvent>> map2, StreamEvent streamEvent) {
        map.put(streamEvent.getId(), streamEvent);
        map2.computeIfAbsent(streamEvent.getEventType(), event -> new ArrayList<>()).add(streamEvent);
    }

    public static void printEvent(Map<Integer, StreamEvent> map) {
        for (Map.Entry<Integer, StreamEvent> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public static void searchById(Map<Integer, StreamEvent> map, int id) {
        for (Map.Entry<Integer, StreamEvent> entry : map.entrySet()) {
            if (entry.getKey() == id) {
                System.out.println("\n" + "Ваше событие найденно: " + "\n" + entry.getValue());
            }
        }
    }

    public static void searchEventList(Map<String, List<StreamEvent>> map, String eventType) {
        if (map.containsKey(eventType)) {
            System.out.println("\n" + "Ваше событие найденно: " + "\n" + map.get(eventType));
        }
    }

    public static void removeEvent(Map<Integer, StreamEvent> map, Map<String, List<StreamEvent>> map2, int id) {
        System.out.println("\n" + "Данное событие удалено!" + "\n" + map.get(id));
        map2.get((map.get(id).getEventType())).remove(map.get(id));
        map.remove(id);
    }
}