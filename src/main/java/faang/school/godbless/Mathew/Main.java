package faang.school.godbless.Mathew;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static Map<Integer,StreamEvent> mappa = new HashMap<>();
    static Map<String, List<StreamEvent>> second_mappa = new HashMap<>();
    public static void addNewEvent(int id,String eventType,String data) {
        StreamEvent streamEvent = new StreamEvent(id,eventType,data);
        mappa.put(id,streamEvent);
        second_mappa.computeIfAbsent(eventType, value -> new ArrayList<>()).add(streamEvent);
    }
    public static void searchIt(int id) {
        mappa.get(id);
    }

    public static void searchType(String eventType) {
        second_mappa.get(eventType);
    }
    public static void removeEvent(int id) {
        String a = mappa.get(id).getEventType();
        second_mappa.remove(a);
        mappa.remove(id);
    }

}
