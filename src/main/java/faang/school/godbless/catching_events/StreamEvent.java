package faang.school.godbless.catching_events;

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

    public static StreamEvent findStreamEventById(Map<Integer, StreamEvent> eventMap, int id){
        if(!eventMap.containsKey(id)){
            System.out.println("StreamEvent not found");
            return null;
        } else {
            return eventMap.get(id);
        }
    }

    public static List<StreamEvent> findStreamEventByEventType(Map<String, List<StreamEvent>> eventListMap,
                                                               String eventType){
        if(!eventListMap.containsKey(eventType)){
            System.out.println("List of events with this event type not found");
            return null;
        } else {
            return eventListMap.get(eventType);
        }
    }

    public static void addStreamEvent(Map<Integer, StreamEvent> eventMap,
                                      Map<String, List<StreamEvent>> eventListMap,
                                      StreamEvent streamEvent){
        eventMap.put(streamEvent.getId(), streamEvent);

        String eventType = streamEvent.getEventType();
        eventListMap.computeIfAbsent(eventType, streamEventAsKey -> new ArrayList<>());
        eventListMap.get(eventType).add(streamEvent);
    }

    public static void deleteStreamEvent(Map<Integer, StreamEvent> eventMap,
                                      Map<String, List<StreamEvent>> eventListMap,
                                      StreamEvent streamEvent){
        eventMap.remove(streamEvent.getId());

        eventListMap.get(streamEvent.getEventType()).remove(streamEvent);
    }

    public static void showAllStreamEvents(Map<Integer, StreamEvent> eventMap){
        for(Map.Entry<Integer, StreamEvent> eventEntry : eventMap.entrySet()){
            System.out.println(eventEntry.getValue());
        }
    }
}
