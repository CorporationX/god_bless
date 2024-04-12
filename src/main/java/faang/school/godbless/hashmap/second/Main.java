package faang.school.godbless.hashmap.second;

import java.util.*;

public class Main {
    private HashMap<Integer, StreamEvent> streamEventById = new HashMap<>();
    private HashMap<String, List<StreamEvent>> streamEventsByType = new HashMap<>();

    public static void main(String[] args) {
        Main main = new Main();
        main.addEvent(1, "Call on discord", "12.04.24 at 16:00");
        main.addEvent(2, "Call on discord", "15.04.24 at 12:00");
        main.addEvent(3, "Lesson", "12.04.24 at 14:00");
        main.addEvent(4, "Lesson", "13.04.24 at 18:00");
        main.addEvent(5, "Retro", "13.04.24 at 14:00");
        main.addEvent(6, "Retro", "13.04.24 at 15:00");
        main.addEvent(7, "Retro", "13.04.24 at 16:00");
        main.writeStreamEvents(main.streamEventById);
        System.out.println("*****");
        main.deleteStreamEventById(2);
        main.deleteStreamEventById(1);
        System.out.println(main.searchStreamEventById(4));
        System.out.println("*****");
        System.out.println(main.searchStreamEventsByType("Retro"));
        System.out.println("*****");
        main.writeStreamEvents(main.streamEventById);
    }

    public void addEvent(int id, String eventType, String data) {
        StreamEvent streamEvent = new StreamEvent(id, eventType, data);
        streamEventById.put(streamEvent.getId(), streamEvent);
        streamEventsByType.computeIfAbsent(streamEvent.getEventType(), k -> new ArrayList<>()).add(streamEvent);
    }

    public StreamEvent searchStreamEventById(int id) {
        return streamEventById.get(id);
    }

    public List<StreamEvent> searchStreamEventsByType(String eventType) {
        return streamEventsByType.get(eventType);
    }

    public void deleteStreamEventById(int id) {
        streamEventById.remove(id);
        streamEventsByType.remove(streamEventById.get(id).getEventType(), streamEventById.get(id));
    }

    public void writeStreamEvents(HashMap<Integer, StreamEvent> streamEventById) {
        for (Map.Entry entry : streamEventById.entrySet()) {
            System.out.println(entry);
        }
    }

}