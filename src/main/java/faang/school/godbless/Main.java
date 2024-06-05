package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<Integer, StreamEvent> mapIdEvent = new HashMap<>();
    private static Map<String, List<StreamEvent>> mapListEvent = new HashMap<>();

    public static void main(String[] args) {
        addEventStream(new StreamEvent(1, "A", "aaa"));
        addEventStream(new StreamEvent(2, "B", "bbb"));
        addEventStream(new StreamEvent(3, "C", "ccc"));
        addEventStream(new StreamEvent(4, "A", "aaa"));
        addEventStream(new StreamEvent(5, "C", "ccc"));

        System.out.println(mapIdEvent);
        System.out.println("----------------------------");
        System.out.println(mapListEvent);

        addEventStream(new StreamEvent(6, "C", "ccc"));

        System.out.println(mapIdEvent);
        System.out.println("----------------------------");
        System.out.println(mapListEvent);

        deleteEventStream(3);

        System.out.println(mapIdEvent);
        System.out.println("----------------------------");
        System.out.println(mapListEvent);

        System.out.println("==============================");
        System.out.println(searchEvent(4));
        System.out.println(searchStreamEvent("C"));;
    }

    // добавления нового события потока
    static void addEventStream(StreamEvent streamEvent){
        mapIdEvent.put(streamEvent.getId(), streamEvent);
        updateMapListEvent(streamEvent);

    }

    // Обновление дополненной HashMap, где группируются объекты по типу события
    static void updateMapListEvent(StreamEvent streamEvent){
        if (mapListEvent.containsKey(streamEvent.getEventType())){
            mapListEvent.get(streamEvent.getEventType()).add(streamEvent);
        }
        else
            mapListEvent.computeIfAbsent(streamEvent.getEventType(), newListEvent -> new ArrayList<>()).add(streamEvent);
    }

    // Поиск события потока по ID
    static StreamEvent searchEvent(int id){
        return mapIdEvent.get(id);
    }

    //поиск списка событий потока по типу события
    static List<StreamEvent> searchStreamEvent(String typeEvent){
        return mapListEvent.get(typeEvent);
    }

    //удаление события потока по его ID
    static void deleteEventStream(int id){
        updateDeleteMapListEvent(mapIdEvent.get(id));
        mapIdEvent.remove(id);

    }
    // Обновление измененной HashMap
    static void updateDeleteMapListEvent(StreamEvent streamEvent){
        mapListEvent.get(streamEvent.getEventType()).remove(streamEvent);
    }
}
