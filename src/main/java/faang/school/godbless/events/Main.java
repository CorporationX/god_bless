package faang.school.godbless.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<Integer, StreamEvent> eventByIdMap = new HashMap<>();
    private  static Map<String, List<StreamEvent>> eventByTypeMap = new HashMap<>();
    public static void main(String[] args) {
        StreamEvent event1 = new StreamEvent(1, "type1", "data1");
        StreamEvent event2 = new StreamEvent(2, "type2", "data2");
        StreamEvent event3 = new StreamEvent(3, "type1", "data3");

        addNewEvent( event1 );
        addNewEvent( event2 );
        addNewEvent( event3 );

        printAllEvents();
        deleteStreamEventById(2);
        System.out.println("\n");
        System.out.println(findListOfStreamEventsByType("type1"));
        System.out.println(findStreamEventById(2));
        System.out.println("\n");
        printAllEvents();
    }
    public static void addNewEvent(StreamEvent streamEvent){
        eventByIdMap.put(streamEvent.getId(), streamEvent);
        if(!eventByTypeMap.containsKey( streamEvent.getEventType()))
            eventByTypeMap.put( streamEvent.getEventType(), new ArrayList<>());

        eventByTypeMap.get( streamEvent.getEventType() ).add( streamEvent);
    }

    public static StreamEvent findStreamEventById(int id){
        if(eventByIdMap.containsKey(id)){
            return eventByIdMap.get(id);
        }
        System.out.println("No event with such id exist");
        return null;
    }
    public static List<StreamEvent> findListOfStreamEventsByType(String type){
        if(eventByTypeMap.containsKey(type)){
            System.out.println("List with " + type + " :");
            return eventByTypeMap.get( type);
        }
           System.out.println("No events with such type exist");
           return null;
    }
    public static void deleteStreamEventById(int id){
        StreamEvent streamEvent = eventByIdMap.remove(id);
        if(streamEvent==null){
            System.out.println("No such event with given id in eventIdMap");
            return;
        }
        List<StreamEvent> typeList = eventByTypeMap.get(streamEvent.getEventType());
        if(typeList==null){
            System.out.println("No such event with given id in eventTypeMap");
            return;
        }
        typeList.remove( streamEvent );
    }
    public static void printAllEvents(){
        System.out.println("Events by ID:");
        eventByIdMap.forEach((id, event) -> System.out.println(id + ": " + event));

        System.out.println("Events by Type:");
        eventByTypeMap.forEach((type, events) -> {
            System.out.println(type + ":");
            events.forEach(System.out::println);
        });
    }
}
