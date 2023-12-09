package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, StreamEvent> mapEvent = new HashMap<>();
        HashMap<String, List<StreamEvent>> mapEvents = new HashMap<>();
        StreamEvent se1 = new StreamEvent(1, "NewYear", "someData");
        addNewStreamEvent(mapEvent, mapEvents, se1);
        System.out.println(mapEvent);
        System.out.println(mapEvents);
        System.out.println(searchStreamEvent(mapEvent, 1));
        System.out.println(searchListStreamEvent(mapEvents, "NewYear"));
        deleteStreamEvent(mapEvent, mapEvents, 1);
        System.out.println(mapEvent);
        System.out.println(mapEvents);
        addNewStreamEvent(mapEvent, mapEvents, se1);
        output(mapEvent);
    }
    public static void addNewStreamEvent(HashMap<Integer, StreamEvent> map, HashMap<String, List<StreamEvent>> mapEvents, StreamEvent streamEvent){
        List<StreamEvent> se= new ArrayList<>();
        se.add(streamEvent);
        map.put(streamEvent.getId(), streamEvent);
        mapEvents.put(streamEvent.getEventType(), se);
    }
    public static StreamEvent searchStreamEvent(HashMap<Integer, StreamEvent> map,int id){
        if(map.get(id) != null){
            return map.get(id);
        }else{
            System.out.print("There are no event with id "+id);
        }
        return map.get(id);
    }
    public static List<StreamEvent> searchListStreamEvent(HashMap<String, List<StreamEvent>> map, String typeEvent){
        if(map.containsKey(typeEvent)){
            return map.get(typeEvent);
        }else{
            System.out.print("There are no this event type");
        }
        return map.get(typeEvent);
    }
    public static void deleteStreamEvent(HashMap<Integer, StreamEvent> map, HashMap<String, List<StreamEvent>> list, int id){
        if(map.containsKey(id)){
            list.remove(map.get(id).getEventType());
            map.remove(id);
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
