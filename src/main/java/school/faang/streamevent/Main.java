package school.faang.streamevent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static private Map<Integer, StreamEvent> idMap = new HashMap<>();
    static private Map<String, List<StreamEvent>> typeMap = new HashMap<>();
    public static void main(String[] args) {

        addStreamEvent(new StreamEvent(1, "Warning", "adfadfasd"));
        addStreamEvent(new StreamEvent(2, "Warning", "fdsfsdf"));
        addStreamEvent(new StreamEvent(3, "Warning", "123213"));
        addStreamEvent(new StreamEvent(4, "Info", "gfgfsg"));
        addStreamEvent(new StreamEvent(5, "Info", "weqrert"));
        addStreamEvent(new StreamEvent(6, "Info", "1454325"));

        printStreamEvents();
        removeStreamEvent(1);
        System.out.println("After remove");
        printStreamEvents();
    }

    public static void addStreamEvent(StreamEvent streamEvent) {
        idMap.put(streamEvent.getId(), streamEvent);
        typeMap.computeIfAbsent(streamEvent.getEventType(), se -> new ArrayList<>()).add(streamEvent);
    }

    public static StreamEvent findStreamEventById(int id) {
        return idMap.get(id);
    }

    public static List<StreamEvent> findStreamEventByType(String type) {
        return typeMap.get(type);
    }

    public static Boolean removeStreamEvent(int id) {
        StreamEvent streamEvent = idMap.remove(id);
        if (streamEvent != null) {
            return typeMap.get(streamEvent.getEventType()).remove(streamEvent);
        }
        return false;
    }

    public static void printStreamEvents() {
        for (Map.Entry<Integer, StreamEvent> entry : idMap.entrySet()) {
            System.out.println("id: " + entry.getKey()
                    + "; Event Type: " + entry.getValue().getEventType()
                    + "; Data: " + entry.getValue().getData());
        }
    }
}
