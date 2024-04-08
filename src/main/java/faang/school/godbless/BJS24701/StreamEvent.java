package faang.school.godbless.BJS24701;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class StreamEvent {
    private int id;
    private String eventType;
    private String data;

    public static void addEvent(StreamEvent event, Map<Integer, StreamEvent> eventById, Map<String, List<StreamEvent>> eventsByType) {
        eventById.put(event.getId(), event);
        eventsByType.computeIfAbsent(event.getEventType(), k -> new ArrayList<>()).add(event);
    }

    // Метод для поиска события потока по его ID
    public static StreamEvent findEventById(int id, Map<Integer, StreamEvent> eventById) {
        return eventById.get(id);
    }

    // Метод для поиска списка событий потока по типу события
    public static List<StreamEvent> findEventsByType(String eventType, Map<String, List<StreamEvent>> eventsByType) {
        return eventsByType.getOrDefault(eventType, new ArrayList<>());
    }

    // Метод для удаления события потока по его ID и обновления обоих HashMap
    public static void removeEventById(int id, Map<Integer, StreamEvent> eventById, Map<String, List<StreamEvent>> eventsByType) {
        StreamEvent eventToRemove = eventById.remove(id);
        if (eventToRemove != null) {
            eventsByType.get(eventToRemove.getEventType()).remove(eventToRemove);
        }
    }

    // Метод для вывода информации о всех событиях потока
    public static void printAllEvents(Map<Integer, StreamEvent> eventById) {
        for (Map.Entry<Integer, StreamEvent> entry : eventById.entrySet()) {
            System.out.println("Event ID: " + entry.getKey() + ", Type: " + entry.getValue().getEventType() + ", Data: " + entry.getValue().getData());
        }
    }
}
