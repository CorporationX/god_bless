package StreamEventPak;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<Integer, StreamEvent> eventById = new HashMap<>();
    private static Map<String, List<StreamEvent>> eventByType = new HashMap<>();

    public static void main(String[] args) {
        addEvent(new StreamEvent(1, "info", "Process run"));
        addEvent(new StreamEvent(2, "error", "Process falled"));
        addEvent(new StreamEvent(3, "info", "Process exit"));
        addEvent(new StreamEvent(4, "debug", "Test"));
        findEventId(4);
        findEventType("info");
        printStreamEvent();
        removeEvent(3);
        System.out.println();
        printStreamEvent();

    }

    public static void addEvent(StreamEvent streamEvent) {
        eventById.put(streamEvent.getId(), streamEvent);
        eventByType.computeIfAbsent(streamEvent.getEventType(), key->new ArrayList<>()).add(streamEvent);
    }

    public static void findEventId(int id) {
        if (eventById.containsKey(id)) {
            StreamEvent event = eventById.get(id);
            System.out.println("Stream event with id " + id + event);
        } else {
            System.out.println("Stream event with id " + id + " not found");
        }
    }

    public static void findEventType(String type) {
        if (eventByType.containsKey(type)) {
            ArrayList eventList = (ArrayList) eventByType.get(type);
            System.out.println("List event with type " + type + " " + eventList);
        } else {
            System.out.println("List event with type " + type + " not found");
        }
    }

    public static void removeEvent(int id) {
        if (eventById.containsKey(id)) {
            StreamEvent event = eventById.get(id);
            eventById.remove(id);
            List<StreamEvent> eventList = eventByType.get(event.getEventType());
            eventList.remove(event);
            if (eventList.isEmpty()) {
                eventByType.remove(event.getEventType());
            }
        }
    }

    private static void printStreamEvent() {
        for (Map.Entry<Integer, StreamEvent> entry : eventById.entrySet()) {
            String value = entry.getValue().toString();
            System.out.println("StreamEvent: " + value);
        }
    }
}
