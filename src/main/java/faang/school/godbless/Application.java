package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {

    private static final Map<Integer, StreamEvent> ID_STREAM = new HashMap<>();
    private static final Map<String, List<StreamEvent>> TYPE_EVENT = new HashMap<>();


    public static void main(String[] args) {
        System.out.println("God Bless!");
        StreamEvent firstStream = new StreamEvent(1, "type 1", "info");
        StreamEvent secondStream = new StreamEvent(2, "type 1", "info");
        StreamEvent thirdStream = new StreamEvent(3, "type 2", "info");
        StreamEvent fourthStream = new StreamEvent(4, "type 2", "info");

        addEvent(firstStream);
        addEvent(secondStream);
        addEvent(thirdStream);
        addEvent(fourthStream);

        allMap();

        System.out.println();

        researchEvent(2);
        System.out.println();

        delEvent(2);

        allMap();

    }

    public static void addEvent(StreamEvent streamEvent) {
        ID_STREAM.put(streamEvent.getId(), streamEvent);
        if (TYPE_EVENT.containsKey(streamEvent.getEventType())) {
            TYPE_EVENT.get(streamEvent.getEventType()).add(streamEvent);
        } else {
            TYPE_EVENT.put(streamEvent.getEventType(), new ArrayList<>());
            TYPE_EVENT.get(streamEvent.getEventType()).add(streamEvent);
        }
    }

    public static void researchEvent(int id) {
        System.out.println(ID_STREAM.get(id));
    }

    public static void researchList(String typeEvent) {
        System.out.println(TYPE_EVENT.get(typeEvent));
    }

    public static void delEvent(int id) {
        TYPE_EVENT.get(ID_STREAM.get(id).getEventType()).remove(ID_STREAM.get(id));
        ID_STREAM.remove(id);
    }

    public static void allMap() {
        for (Map.Entry<Integer, StreamEvent> pair : ID_STREAM.entrySet()) {
            System.out.println(pair.getKey() + pair.getValue().toString());
        }
        System.out.println();

        for (Map.Entry<String, List<StreamEvent>> pair : TYPE_EVENT.entrySet()) {
            System.out.println(pair.getKey() + pair.getValue());
        }
    }

}