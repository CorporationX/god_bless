package faang.school.godbless.BJS2_4136;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
@AllArgsConstructor
public class StreamEvent {
    private int id;
    private String eventType;
    private String data;

    public static StreamEvent findEventById(int id, HashMap<Integer, StreamEvent> target) {
        return target.get(id);
    }

    public static List<StreamEvent> findEventsByType(String eventType, HashMap<String, List<StreamEvent>> target) {
        return target.getOrDefault(eventType, new ArrayList<>());
    }

    public static void printAllEvents(HashMap<Integer, StreamEvent> target) {
        System.out.println("Все события:");
        for (HashMap.Entry<Integer, StreamEvent> entry : target.entrySet()) {
            StreamEvent event = entry.getValue();
            System.out.printf("ID=%s, Type=%s, Data=%s", event.getId(), event.getEventType(), event.getData());
            System.out.println();
        }
    }
}
