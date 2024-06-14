package faang.school.godbless.catching.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventService {

    private static Map<Integer, StreamEvent> eventById = new HashMap<>();
    private static Map<String, List<StreamEvent>> eventByType = new HashMap<>();

    public static void addEvent(StreamEvent event) {
        eventById.put(event.getId(), event);
        eventByType.computeIfAbsent(event.getEventType(), k -> new ArrayList<>()).add(event);
    }


    public static StreamEvent findEventById(int id) {
        return eventById.getOrDefault(id, null);
    }

    public static List<StreamEvent> findEventsByType(String eventType) {
        return eventByType.getOrDefault(eventType, null);
    }

    /*
    Я не могу вызвать removeIf, как я понял у Map это не работает.
    Я могу сделать что-то типа такого Set<Integer> set =  eventById.keySet();
    И потом вызвать уже removeIf. По другому сама IDEA не дает
    */
    public static void removeEventById(int id) {
        if(id != 0 && !eventById.containsKey(id)) {
            eventById.remove(id);
        }
        else {
            System.err.println("Error!");
        }
    }

    public static void printAllEvents() {
        for (Map.Entry<Integer, StreamEvent> entry : eventById.entrySet()) {
            System.out.println(entry.toString());
        }
    }

}
