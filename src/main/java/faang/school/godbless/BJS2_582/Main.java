package faang.school.godbless.BJS2_582;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, StreamEvent> mapEvent = new HashMap<>();
        HashMap<String, List<StreamEvent>> mapEvents = new HashMap<>();
        StreamEvent streamEvent1 = new StreamEvent(1, "NewYear", "someData");
        addNewStreamEvent(mapEvent, mapEvents, streamEvent1);
        System.out.println(mapEvent);
        System.out.println(mapEvents);
        searchStreamEvent(mapEvent, 1);
        searchListStreamEvent(mapEvents, "NewYear");
        deleteStreamEvent(mapEvent, mapEvents, 1);
        System.out.println(mapEvent);
        System.out.println(mapEvents);
        addNewStreamEvent(mapEvent, mapEvents, streamEvent1);
        output(mapEvent);
    }
    public static void addNewStreamEvent(HashMap<Integer, StreamEvent> map, HashMap<String, List<StreamEvent>> mapEvents, StreamEvent streamEvent){
        List<StreamEvent> listStreamEvent= new ArrayList<>();
        listStreamEvent.add(streamEvent);
        map.put(streamEvent.getId(), streamEvent);
        mapEvents.put(streamEvent.getEventType(), listStreamEvent);
    }

    public static void searchStreamEvent(HashMap<Integer, StreamEvent> map,int id){
        if(map.get(id) != null){
            System.out.println(map.get(id));
        }else{
            System.out.print("There are no event with id "+id);
        }
    }

    public static void searchListStreamEvent(HashMap<String, List<StreamEvent>> map, String typeEvent){
        if(map.containsKey(typeEvent)){
            System.out.println(map.get(typeEvent));
        }else{
            System.out.print("There are no this event type");
        }
    }

    public static void deleteStreamEvent(HashMap<Integer, StreamEvent> eventsGroupedById, HashMap<String, List<StreamEvent>> eventsGroupedByType, int id){
        if(eventsGroupedById.containsKey(id)){
            eventsGroupedByType.remove(eventsGroupedById.get(id).getEventType());
            eventsGroupedById.remove(id);
        }else{
            System.out.println("There are no event with id"+id);
        }
    }

    public static void output(HashMap<Integer, StreamEvent> mapEvent){
        for (Map.Entry<Integer, StreamEvent> entry : mapEvent.entrySet()) {
            System.out.println(entry);
        }
    }
}

