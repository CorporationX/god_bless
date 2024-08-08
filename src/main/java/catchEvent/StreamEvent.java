package catchEvent;

import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@EqualsAndHashCode
public class StreamEvent {
    private int id;
    private String eventType;
    private String data;

    public StreamEvent(int id, String eventType, String data) {
        this.id = id;
        this.eventType = eventType;
        this.data = data;
    }

    public static void addEvent(StreamEvent event, Map<Integer, StreamEvent> idEvent,  Map<String, List<StreamEvent>> typeEventSearch) {
        idEvent.put(event.id, event);

        String key = event.eventType;

        if (!typeEventSearch.containsKey(key)) {
            List<StreamEvent> testList = new ArrayList<>();
            testList.add(event);
            typeEventSearch.put(key,testList);
        }

    }

    public static void eventIdSearch(int id, Map<Integer, StreamEvent> idEvent) {
        if (idEvent.containsKey(id)) {
            System.out.println(idEvent.get(id));
        }

    }
    public static void eventTypeSearch(String type, Map<String, List<StreamEvent>> typeEventSearch) {
        if (typeEventSearch.containsKey(type)) {
            System.out.println(typeEventSearch.get(type));
        }

    }

    public static void deleteEventID(int id, Map<Integer, StreamEvent> idEvent,  Map<String, List<StreamEvent>> typeEventSearch) {
        String type = idEvent.get(id).eventType;

        if (typeEventSearch.containsKey(type)) {
            typeEventSearch.remove(type);
            System.out.println("Successful delete!");
        }


        if (idEvent.containsKey(id)) {
            idEvent.remove(id);
            System.out.println("Successful delete!");
        }

    }

    public static void allEvents(Map<Integer, StreamEvent> idEvent,  Map<String, List<StreamEvent>> typeEventSearch) {
        for (Map.Entry<Integer, StreamEvent> pair : idEvent.entrySet()) {
            System.out.println(pair.getKey() + " : " + pair.getValue().getEventType() + " - " + pair.getValue().getData());
        }

        for (Map.Entry<String, List<StreamEvent>> pair : typeEventSearch.entrySet()) {
            for (int i = 0; i < pair.getValue().size(); i++) {
                System.out.println(pair.getKey() + " : " + pair.getValue().get(i).getId() + " - " + pair.getValue().get(i).getData());
            }
        }
    }

    @Override
    public String toString() {
        return "StreamEvent{" +
                "id=" + id +
                ", eventType='" + eventType + '\'' +
                ", data='" + data + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getEventType() {
        return eventType;
    }

    public String getData() {
        return data;
    }
}
