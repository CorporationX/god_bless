package school.faang.bjs2_33205_streamCatch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<Integer, StreamEvent> idEventMap = new HashMap<>();
    private static Map<String, List<StreamEvent>> typeGroupMap = new HashMap<>();

    public static void main(String[] args) {
        addEvent(new StreamEvent(1, "Message", "Message sent"));
        addEvent(new StreamEvent(2, "Message", "Message delivered"));
        addEvent(new StreamEvent(3, "Request", "Incoming request"));
        addEvent(new StreamEvent(4, "Error", "Port is closed"));
        addEvent(new StreamEvent(5, "Log", "Log created"));

        displayEvents();
        System.out.println(typeGroupMap);

        System.out.println(searchEventById(3));

        System.out.println(searchEventsByType("Message"));

        removeEvent(5);
        System.out.println(idEventMap);
        System.out.println(typeGroupMap);
        displayEvents();
    }

    private static void addEvent(StreamEvent streamEvent) {
        idEventMap.put(streamEvent.getId(), streamEvent);
        typeGroupMap.computeIfAbsent(streamEvent.getEventType(), k -> new ArrayList<>()).add(streamEvent);
    }

    private static StreamEvent searchEventById(int id) {
        return idEventMap.get(id);
    }

    private static List<StreamEvent> searchEventsByType(String type) {
        return typeGroupMap.get(type);
    }

    private static void removeEvent(int id) {
        if (idEventMap.containsKey(id)) {
            StreamEvent event = idEventMap.remove(id);
            typeGroupMap.remove(event.getEventType());
        } else {
            throw new IllegalArgumentException("No such id");
        }
    }

    private static void displayEvents() {
        for (Map.Entry<Integer, StreamEvent> entry : idEventMap.entrySet()) {
            int id = entry.getKey();
            String type = entry.getValue().getEventType();
            String data = entry.getValue().getData();
            System.out.printf("id: %d\t Type: %s\t Data: %s\n", id, type, data);
        }
    }
}
