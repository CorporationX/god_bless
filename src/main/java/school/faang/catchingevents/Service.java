package school.faang.catchingevents;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static school.faang.catchingevents.Main.STREAM_EVENT;
import static school.faang.catchingevents.Main.TYP_AND_LIST_EVENT;

public class Service {
    /**
     * добавления нового события потока и обновления обоих HashMap
     */
    public void addEvent(StreamEvent streamEvent) {
        STREAM_EVENT.putIfAbsent(streamEvent.getId(), streamEvent);
        TYP_AND_LIST_EVENT.computeIfAbsent(streamEvent.getEventType(), k -> new ArrayList<>()).add(streamEvent);
    }

    /**
     * поиска события потока по его ID
     */
    public StreamEvent searchedById(int id) {
        return STREAM_EVENT.get(id);
    }

    /**
     * поиска списка событий потока по типу события
     */
    public List<StreamEvent> searchedByType(String eventType) {
        return TYP_AND_LIST_EVENT.getOrDefault(eventType, new ArrayList<>());
    }

    /**
     * удаления события потока по его ID и обновления обоих HashMap
     */
    public void removeStreamEventsById(int id) {
        StreamEvent streamEvent = STREAM_EVENT.remove(id);
        if (streamEvent != null) {
            List<StreamEvent> eventList = TYP_AND_LIST_EVENT.get(streamEvent.getEventType());
            if (eventList != null) {
                eventList.remove(streamEvent);
                if (eventList.isEmpty()) {
                    TYP_AND_LIST_EVENT.remove(streamEvent.getEventType());
                }
            }
        }
    }

    /**
     * метод для вывода информации о всех событиях потока
     */
    public void printAllStreamEvents() {
        for (Map.Entry<Integer, StreamEvent> entry : STREAM_EVENT.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
