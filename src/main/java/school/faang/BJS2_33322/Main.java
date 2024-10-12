package school.faang.BJS2_33322;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private Map<Integer, StreamEvent> eventById = new HashMap<>();
    private Map<String, List<StreamEvent>> eventsByType = new HashMap<>();

    public void addEvent(StreamEvent event) {
        eventById.put(event.getId(), event);

        eventsByType.computeIfAbsent(event.getEventType(), k -> new ArrayList<>()).add(event);
    }

    public StreamEvent getEventById(int id) {
        return eventById.get(id);
    }

    public List<StreamEvent> getEventsByType(String eventType) {
        return eventsByType.getOrDefault(eventType, new ArrayList<>());
    }

    public void removeEventById(int id) {
        StreamEvent event = eventById.remove(id);
    }

    public void printAllEvents() {
        for (Map.Entry<Integer, StreamEvent> entry : eventById.entrySet()) {
            StreamEvent event = entry.getValue();
            System.out.println("ID: " + event.getId() + ", Type: " + event.getEventType() + ", Data: " + event.getData());
        }
    }

    public static void main(String[] args) {
        Main streamProcessor = new Main();

        streamProcessor.addEvent(new StreamEvent(1, "TypeA", "Data1"));
        streamProcessor.addEvent(new StreamEvent(2, "TypeB", "Data2"));
        streamProcessor.addEvent(new StreamEvent(3, "TypeA", "Data3"));

        System.out.println("Event with ID 1: " + streamProcessor.getEventById(1));

        System.out.println("Events of TypeA: " + streamProcessor.getEventsByType("TypeA"));

        streamProcessor.removeEventById(2);

        streamProcessor.printAllEvents();
    }

}
