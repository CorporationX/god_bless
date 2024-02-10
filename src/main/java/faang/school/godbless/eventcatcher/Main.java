package faang.school.godbless.eventcatcher;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
    public static Map<Integer, StreamEvent> eventsByID = new HashMap<>();
    public static Map<String, List<StreamEvent>> eventsSortedByType = new HashMap<>();
    public static void main(String[] args) {
        StreamEvent eventTransformation = new StreamEvent(353, "Transform data", "Some Data");
        StreamEvent eventAnalyzing = new StreamEvent(3534, "Analyze data", "Some Data");
        StreamEvent eventAnalyzing2 = new StreamEvent(3574, "Analyze data", "Some Data");
        StreamEvent eventAnalyzing3 = new StreamEvent(3094, "Analyze data", "Some Data");
        StreamEvent eventPerform = new StreamEvent(343, "Perfoming data", "Some Data");
        addStreamEvent(eventTransformation);
        addStreamEvent(eventAnalyzing);
        addStreamEvent(eventAnalyzing2);
        addStreamEvent(eventAnalyzing3);
        addStreamEvent(eventPerform);
        listAllEvents();
        System.out.println();
        removeEvent(353);
        listAllEvents();
        System.out.println();
        removeEvent(3094);
        System.out.println();
        System.out.println(searchByID(3534));
        removeEvent(3423525);
    }
    public static void addStreamEvent(StreamEvent event){
        eventsByID.put(event.getId(), event);
        if (eventsSortedByType.containsKey(event.getEventType())){
            eventsSortedByType.get(event.getEventType()).add(event);
        }else{
            List<StreamEvent> eventInStream = new LinkedList<>();
            eventInStream.add(event);
            eventsSortedByType.put(event.getEventType(), eventInStream);
        }
    }

    public static StreamEvent searchByID(int id){
        return eventsByID.get(id);
    }

    public static List<StreamEvent> searchByType(String type){
        return eventsSortedByType.get(type);
    }
    public static void removeEvent(int id){
        eventsByID.remove(id);
    }
    public static void listAllEvents(){
        for (var entry : eventsByID.entrySet()){
            System.out.println(entry.getValue());
        }
    }


}
//Should i preserve the sequence of events' flow or could it be randomly executed?
