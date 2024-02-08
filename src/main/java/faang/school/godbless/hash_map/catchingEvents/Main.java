package faang.school.godbless.hash_map.catchingEvents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<Integer, StreamEvent> mapIdEvent = new HashMap<>(); // id события и событие потока
    private static final Map<String, List<StreamEvent>> mapTypeListEvent = new HashMap<>(); // тип события и список событий

    public static void main(String[] args) {
        addStreamEvent(1, "Вечеринка", "Алкоголь, Еда, Воздушные шары");
        addStreamEvent(2, "Свадьба", "Ресторан Claude Monet, Крабы");
        addStreamEvent(3, "Корпоратив", "LoftHall Backyard, 8 официантов, Банкет");
        addStreamEvent(4, "Корпоратив", "LoftHall Greenwich, 3 официантов");

        printAllEvent();
        System.out.println(findStreamEventId(1));

        System.out.println(findListStreamEvent("Корпоратив"));
        deleteStreamEvent(5);
        printAllEvent();

    }

    private static void addStreamEvent(int id, String eventType, String data){
        StreamEvent streamEvent = new StreamEvent(id, eventType, data);
        mapIdEvent.put(streamEvent.getId(), streamEvent);
        if(!mapTypeListEvent.containsKey(streamEvent.getEventType())) {
            mapTypeListEvent.put(streamEvent.getEventType(), new ArrayList<>());
        }
        mapTypeListEvent.get(streamEvent.getEventType()).add(streamEvent);
    }

    private static StreamEvent findStreamEventId(int id){
        return mapIdEvent.get(id);
    }

    private static List<StreamEvent> findListStreamEvent(String eventType){
        return mapTypeListEvent.get(eventType);
    }

    private static void deleteStreamEvent(int id){
        StreamEvent streamEvent = findStreamEventId(id);
        if(streamEvent != null) {
            mapIdEvent.remove(id);
            mapTypeListEvent.get(streamEvent.getEventType()).remove(streamEvent);
        }
    }
    private static void printAllEvent(){
        for(Map.Entry<Integer, StreamEvent> entry: mapIdEvent.entrySet()){
            System.out.println(entry.getValue());
        }
    }
}
