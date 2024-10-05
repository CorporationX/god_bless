package school.faang.BJS233254;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static Map<Integer, StreamEvent> ID_EVENT_MAP = new HashMap<>();
    static Map<String, List<StreamEvent>> EVENT_MAP = new HashMap<>();

    static Integer ID = 1;

    enum eventType {
        BDPARTY,
        GENDERPARTY,
        BABYSHOWER,
        FUNERAL,


    }

    static void addEvent(StreamEvent event) {
        ID_EVENT_MAP.put(ID, event);
        ID++;
        EVENT_MAP.computeIfAbsent(event.getEvent(), i -> new ArrayList<>()).add(event);
    }

    static StreamEvent findEventById(int id) {
        return ID_EVENT_MAP.get(id);
    }

    static List<StreamEvent> findListByEventType(String type) {
        try {
            return EVENT_MAP.get(eventType.valueOf(type).toString());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("The wrong event type name");
        }
    }

    static void deleteEvent(int id) {
        StreamEvent streamEvent = ID_EVENT_MAP.get(id);
        for (String s : EVENT_MAP.keySet()) {
            if (s.equals(streamEvent.getEvent())) {
                EVENT_MAP.get(s).remove(streamEvent);
            }
        }
        ID_EVENT_MAP.remove(id);
    }

    static void getAll() {
        for (Map.Entry<String, List<StreamEvent>> stringListEntry : EVENT_MAP.entrySet()) {
            for (StreamEvent streamEvent : stringListEntry.getValue()) {
                System.out.println(streamEvent.getId() + " " + streamEvent.getEvent() + " " + streamEvent.getData());
            }
        }
    }

    public static void main(String[] args) {
        addEvent(new StreamEvent(ID, eventType.BABYSHOWER.toString(), "9 месяц"));
        addEvent(new StreamEvent(ID, eventType.BDPARTY.toString(), "18 летие"));
        addEvent(new StreamEvent(ID, eventType.GENDERPARTY.toString(), "Девочка"));
        addEvent(new StreamEvent(ID, eventType.FUNERAL.toString(), "Бабушка"));
        addEvent(new StreamEvent(ID, eventType.BDPARTY.toString(), "50 летие"));
        addEvent(new StreamEvent(ID, eventType.BABYSHOWER.toString(), "9 месяц"));
        addEvent(new StreamEvent(ID, eventType.GENDERPARTY.toString(), "Мальчик"));

        System.out.println(findEventById(2));
        System.out.println(findListByEventType("GENDERPARTY"));
        deleteEvent(7);
        addEvent(new StreamEvent(ID, eventType.BDPARTY.toString(), "33 летие"));
        getAll();

    }
}
