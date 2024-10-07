package school.faang.BJS2_33328;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {

    private final Map<Integer, StreamEvent> integerStreamEventMap = new HashMap<>();
    private final Map<String, List<StreamEvent>> typeEventsMap = new HashMap<>();

    public static void main(String[] args) {
        Main main = new Main();

        main.addEvent(new StreamEvent(1, "Type 1", "Data 1"));
        main.addEvent(new StreamEvent(2, "Type 1", "Data 2"));
        main.addEvent(new StreamEvent(3, "Type 3", "Data 3"));

        main.printAllEvents();

        System.out.printf("\n ====> findStreamEventById : %s", main.findStreamEventById(1).toString());
        System.out.printf("\n ====> findStreamEventByType : %s", main.findStreamEventByType("Type 1").toString());

        main.deleteEventById(3);

        main.printAllEvents();
    }

    public void addEvent(StreamEvent streamEvent){
        integerStreamEventMap.put(streamEvent.getId(), streamEvent);
        typeEventsMap.putIfAbsent(streamEvent.getEventType(), new ArrayList<>());
        typeEventsMap.get(streamEvent.getEventType()).add(streamEvent);
    }

    public StreamEvent findStreamEventById(int id){
        return integerStreamEventMap.get(id);
    }

    public List<StreamEvent> findStreamEventByType(String eventType){
        return typeEventsMap.getOrDefault(eventType, new ArrayList<>());
    }

    public void deleteEventById(int id) {
        if (integerStreamEventMap.containsKey(id)) {
            StreamEvent streamEventTemp = integerStreamEventMap.get(id);
            integerStreamEventMap.remove(id);
            if (typeEventsMap.containsKey(streamEventTemp.getEventType())) {
                typeEventsMap.get(streamEventTemp.getEventType()).remove(streamEventTemp);
                if (typeEventsMap.get(streamEventTemp.getEventType()).size() == 0) {
                    typeEventsMap.remove(streamEventTemp.getEventType());
                }
            }
        }
    }

    public void printAllEvents() {
        System.out.println("\n ==== An information about Events ====");
        for(Map.Entry<Integer,StreamEvent> entry : integerStreamEventMap.entrySet()){
            System.out.printf("Event ID: %d ===== Event description: %s \n", entry.getKey(), entry.getValue().toString());
        }
    }
}