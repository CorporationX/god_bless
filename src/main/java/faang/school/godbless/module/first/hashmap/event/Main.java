package faang.school.godbless.module.first.hashmap.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final Map<Integer, StreamEvent> ID_TO_EVENT = new HashMap<>();
    public static final Map<String, List<StreamEvent>> EVENT_TYPE_TO_EVENTS = new HashMap<>();
    public static final String EVENT_TYPE_PARTY = "PARTY";
    
    public static void main(String[] args) {
        addEvent(new StreamEvent(1, EVENT_TYPE_PARTY, "A"));
        addEvent(new StreamEvent(2, EVENT_TYPE_PARTY, "B"));
        addEvent(new StreamEvent(3, EVENT_TYPE_PARTY, "C"));
        
        printAllEvents();
        System.out.println();
        System.out.println(getEventById(2));
        System.out.println(getEventsByEventType(EVENT_TYPE_PARTY));
        deleteEventById(2);
        printAllEvents();
    }
    
    public static void addEvent(StreamEvent streamEvent) {
        ID_TO_EVENT.putIfAbsent(streamEvent.getId(), streamEvent);
        EVENT_TYPE_TO_EVENTS.computeIfAbsent(streamEvent.getEventType(), (value) -> new ArrayList<>()).add(streamEvent);
    }
    
    public static StreamEvent getEventById(int id) {
        return ID_TO_EVENT.get(id);
    }
    
    public static List<StreamEvent> getEventsByEventType(String eventType) {
        return EVENT_TYPE_TO_EVENTS.get(eventType);
    }
    
    public static void deleteEventById(int id) {
        StreamEvent removed = ID_TO_EVENT.remove(id);
        if (removed == null) {
            System.out.printf("Событие стрима с ID %d не найден \n", id);
            return;
        }
        EVENT_TYPE_TO_EVENTS.remove(removed.getEventType());
    }
    
    public static void printAllEvents() {
        System.out.println("Все события");
        for (var entry : ID_TO_EVENT.entrySet()) {
            StreamEvent value = entry.getValue();
            System.out.printf(
                "ID события: %d. Тип события: %s .Данные события: %s \n",
                entry.getKey(),
                value.getEventType(),
                value.getData()
            );
        }
    }
}
