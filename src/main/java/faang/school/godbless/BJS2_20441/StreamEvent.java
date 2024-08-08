package faang.school.godbless.BJS2_20441;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@ToString
@Getter
public class StreamEvent {
    private int id;
    private String eventType;
    private String data;

    public static void addEvent(StreamEvent event, Map<Integer, StreamEvent> mapEvent, Map<String, List<StreamEvent>> mapListEvent) {
        mapEvent.put(event.id, event);
        String key = event.eventType;
        if (!mapListEvent.containsKey(key)) {
            List<StreamEvent> list = new ArrayList<>();
            list.add(event);
            mapListEvent.put(key, list);
        } else{
            mapListEvent.get(key).add(event);
        }
    }

    public static void searchEventId(int id, Map<Integer, StreamEvent> mapEvent) {
        if (mapEvent.containsKey(id)) {
            System.out.println(mapEvent.get(id));
        }
    }

    public static void searchEventType(String type, Map<String, List<StreamEvent>> mapListEvent) {
        if (mapListEvent.containsKey(type)) {
            System.out.println(mapListEvent.get(type));
        }
    }

    public static void deleteEventById(int id, Map<Integer, StreamEvent> mapEvent, Map<String, List<StreamEvent>> mapListEvent) {
        String key = mapEvent.get(id).getEventType();
        mapEvent.remove(id);
        if (mapListEvent.containsKey(key)) {
            mapListEvent.remove(key);
        } else{
            throw new IllegalArgumentException();
        }
    }
}
