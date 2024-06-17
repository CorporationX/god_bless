package faang.school.godbless.domain.task_events;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<Integer, StreamEvent> streamEventMap = new HashMap<>();
    private  static Map<String, List<StreamEvent>> stringListMap = new HashMap<>();
    public static void main(String[] args) {

    }

    private static void addEvent(Integer id, String eventType, String data){
        StreamEvent event = new StreamEvent(id, eventType, data);
        streamEventMap.put(id, event);
    }

}
