package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    Map<Integer, StreamEvent> idMap = new HashMap<>();
    Map<String, List<StreamEvent>> typeMap = new HashMap<>();

    public void addStreamEvent(StreamEvent streamEvent) {
        idMap.put(streamEvent.getId(), streamEvent);
        typeMap.computeIfAbsent(streamEvent.getEventType(), se -> new ArrayList<>()).add(streamEvent);
    }

    public StreamEvent findStreamEventById(int id) {
        return idMap.get(id);
    }

    public List<StreamEvent> findStreamEventByType(String type) {
        return typeMap.get(type);
    }

    public Boolean removeStreamEvent(int id) {
        StreamEvent streamEvent = idMap.remove(id);
        if (streamEvent != null) {
            return typeMap.get(streamEvent.getEventType()).remove(streamEvent);
        }
        return false;
    }

    public void printStreamEvents() {
        for (Map.Entry<Integer, StreamEvent> entry : idMap.entrySet()) {
            System.out.println("id: " + entry.getKey()
                    + "; Event Type: " + entry.getValue().getEventType()
                    + "; Data: " + entry.getValue().getData());
        }
    }

    public static void main(String[] args) {

        Main main = new Main();
        main.addStreamEvent(new StreamEvent(1, "Warning", "adfadfasd"));
        main.addStreamEvent(new StreamEvent(2, "Warning", "fdsfsdf"));
        main.addStreamEvent(new StreamEvent(3, "Warning", "123213"));
        main.addStreamEvent(new StreamEvent(4, "Info", "gfgfsg"));
        main.addStreamEvent(new StreamEvent(5, "Info", "weqrert"));
        main.addStreamEvent(new StreamEvent(6, "Info", "1454325"));

        main.printStreamEvents();
        main.removeStreamEvent(1);
        System.out.println("After remove");
        main.printStreamEvents();
    }
}
