package school.faang.HashMap2;

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

    //добавление и обновление
    public static void addEvent(int id, String eventType, String data,
                                Map<Integer, StreamEvent> idMap, Map<String, List<StreamEvent>> typeMap){
        StreamEvent event = new StreamEvent(id, eventType, data);

        idMap.put(event.getId(), event);
        typeMap.computeIfAbsent(event.getEventType(), k -> new ArrayList<>()).add(event);
    }

    //поиск события по id
    public static StreamEvent searchEvent(int id, Map<Integer, StreamEvent> idMap){
        if (idMap.containsKey(id)){
            return idMap.get(id);
        }
        else {
            return null;
        }
    }

    //поиск по событию
    public static List<StreamEvent> searchEventList (String eventType, Map<String, List<StreamEvent>> typeMap){
        if (typeMap.containsKey(eventType)){
            return typeMap.get(eventType);
        } else {
            return null;
        }
    }

    //удалить событие
    public static void deleteEvent(int id, Map<Integer, StreamEvent> idMap, Map<String, List<StreamEvent>> typeMap){
        StreamEvent event = searchEvent(id, idMap);
        idMap.remove(event.getId(), event);
        typeMap.get(event.getEventType()).remove(event);
    }

    //вывод информации по собитям
    public static void allEventsInfo(Map<String, List<StreamEvent>> typeMap){
        for (var entry : typeMap.entrySet()) {
            System.out.println("Event type: " + entry.getKey() + "\nEvents: ");
            for (StreamEvent event: entry.getValue()){
                System.out.println("id: " + event.getId() + ", data: " + event.getData());
            }
        }
    }




}
