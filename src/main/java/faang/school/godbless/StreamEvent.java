package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StreamEvent {
    private int id;
    private String eventType;
    private String data;

    public StreamEvent(int id, String eventType, String data) {
        this.id = id;
        this.eventType = eventType;
        this.data = data;
    }

    public StreamEvent() {

    }

    public int getId() {
        return id;
    }

    public String getEventType() {
        return eventType;
    }

    public String getData() {
        return data;
    }

    Map<Integer, StreamEvent> idMap = new HashMap<>();
    Map<String, List<StreamEvent>> typeMap = new HashMap<>();



    public static void main(String args[]){
        StreamEvent streamEvent = new StreamEvent();

        streamEvent.addEvent(1, "TypeA", "DataA");
        streamEvent.addEvent(2, "TypeB", "DataB");
        streamEvent.addEvent(3, "TypeA", "DataC");

        System.out.println("All Events:");
        streamEvent.printAllEvents();

        System.out.println("\nFind Event by ID 2:");
        StreamEvent foundEvent = streamEvent.findEventById(2);
        if (foundEvent != null) {
            System.out.println("ID: " + foundEvent.getId() + ", Type: " + foundEvent.getEventType() + ", Data: " + foundEvent.getData());
        } else {
            System.out.println("Event not found");
        }

        System.out.println("\nFind Events by Type TypeA:");
        List<StreamEvent> eventsOfTypeA = streamEvent.findEventsByType("TypeA");
        for (StreamEvent event : eventsOfTypeA) {
            System.out.println("ID: " + event.getId() + ", Type: " + event.getEventType() + ", Data: " + event.getData());
        }

        System.out.println("\nUpdate Event with ID 1:");
        streamEvent.updateEvent(1, "TypeC", "DataUpdated");
        streamEvent.printAllEvents();

        System.out.println("\nRemove Event with ID 3:");
        streamEvent.removeEventById(3);
        streamEvent.printAllEvents();
    }

    public void addEvent(int id, String eventType, String data) {
        StreamEvent event = new StreamEvent(id, eventType, data);

        idMap.put(id, event);

        typeMap.computeIfAbsent(eventType, k -> new ArrayList<>()).add(event);
    }

    public StreamEvent findEventById(int id) {
        return idMap.get(id);
    }

    public List<StreamEvent> findEventsByType(String eventType) {
        return typeMap.getOrDefault(eventType, new ArrayList<>());
    }

    public void removeEventById(int id) {
        StreamEvent eventToRemove = idMap.remove(id);

        if (eventToRemove != null) {
            List<StreamEvent> eventsOfType = typeMap.get(eventToRemove.getEventType());
            if (eventsOfType != null) {
                eventsOfType.remove(eventToRemove);
            }
        }
    }

    public void updateEvent(int id, String newEventType, String newData) {
        removeEventById(id);
        addEvent(id, newEventType, newData);
    }

    public void printAllEvents() {
        for (Map.Entry<Integer, StreamEvent> entry : idMap.entrySet()) {
            StreamEvent event = entry.getValue();
            System.out.println("ID: " + event.getId() + ", Type: " + event.getEventType() + ", Data: " + event.getData());
        }
    }
}
