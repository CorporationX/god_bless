package service;

import model.StreamEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StreamEventService {
    public static Map<Integer, StreamEvent> eventById = new HashMap<>();
    public static Map<String, List<StreamEvent>> eventsByType = new HashMap<>();

    public static void addEvent(StreamEvent event){
        eventById.put(event.getId(), event);
        eventsByType.computeIfAbsent(event.getEventType(), eventType -> new ArrayList<StreamEvent>()).add(event);
    }

    public static StreamEvent findStreamEventById(int id){
        return eventById.get(id);
    }

    public static List<StreamEvent> findStreamEventsByEvenType(String eventType){
        return eventsByType.get(eventType);
    }

    public static void removeStreamEventById(int id){
        StreamEvent removingEvent = eventById.remove(id);
        eventsByType.remove(removingEvent.getEventType());
    }

    public static void getAllStreamEvents(){
        for(Map.Entry<Integer, StreamEvent> eventEntry : eventById.entrySet()){
            System.out.println(
                    "id: " + eventEntry.getKey() +
                    "\nevent type: " + eventEntry.getValue().getEventType() +
                    "\ndata: " + eventEntry.getValue().getData()
            );
        }
    }
}
