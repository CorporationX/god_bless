package school.BJS2_33257;

import java.util.*;

public class Main {

    private static final Map<Integer, StreamEvent> mappa = new HashMap<>();
    private static final Map<String, List<StreamEvent>> mappa2 = new HashMap<>();


    public static void main(String[] args) {
        StreamEvent streamEvent_1 = new StreamEvent(1, "Обращение", "Обратились 10 человек");
        StreamEvent streamEvent_2 = new StreamEvent(2, "Обращение", "Обратились 5 человек");
        StreamEvent streamEvent_3 = new StreamEvent(3, "Обращение", "Обратились 7 человек");
        StreamEvent streamEvent_4 = new StreamEvent(4, "Жалоба", "Пожаловались 9 человек");
        StreamEvent streamEvent_5 = new StreamEvent(5, "Жалоба", "Пожаловались 100 человек");
        StreamEvent streamEvent_6 = new StreamEvent(6, "Благодарность", "Поблагодарили 4 человeка");
        addEvent(streamEvent_1);
        addEvent(streamEvent_2);
        addEvent(streamEvent_3);
        addEvent(streamEvent_4);
        addEvent(streamEvent_5);
        addEvent(streamEvent_6);
        printStreamEvent();
        System.out.println("----------------------------------");
        System.out.println(getStreamEventWithID(5));
        System.out.println("----------------------------------");
        System.out.println(Arrays.asList(getStreamEventWithEventType("Обращение")));
        System.out.println("----------------------------------");
        removeStreamEvent(6);
        printStreamEvent();
    }

    private static void addEvent(StreamEvent streamEvent) {
        mappa.put(streamEvent.getId(), streamEvent);
        mappa2.computeIfAbsent(streamEvent.getType(), k -> new ArrayList<>()).add(streamEvent);
    }

    private static StreamEvent getStreamEventWithID(Integer id) {
        return mappa.get(id);
    }

    private static List<StreamEvent> getStreamEventWithEventType(String eventType) {
        return mappa2.get(eventType);
    }

    private static void removeStreamEvent(Integer id) {
        mappa.remove(id);
        Map<String, List<StreamEvent>> clone = new HashMap<>(mappa2);
        for (Map.Entry<String, List<StreamEvent>> entry : clone.entrySet())
            for (StreamEvent se : entry.getValue()) {
                if (se.getId() == id) {
                    mappa2.remove(se.getType());
                    return;
                }
            }
    }

    private static void printStreamEvent() {
        for (Map.Entry<Integer, StreamEvent> entry : mappa.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

}