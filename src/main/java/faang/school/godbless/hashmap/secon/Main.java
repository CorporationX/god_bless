package faang.school.godbless.hashmap.secon;

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
        main.deleteStreamEventById(6);
        main.deleteStreamEventById(7);
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
        if (streamEventById.get(id) != null) {
            return streamEventById.get(id);
        } else {
            throw new RuntimeException("Search error! Stream event by id not found!");
        }
    }

    public List<StreamEvent> searchStreamEventsByType(String eventType) {
        if (streamEventsByType.get(eventType) != null) {
            return streamEventsByType.get(eventType);
        } else {
            throw new RuntimeException("Search error! Stream events by type not found!");
        }
    }

    public void deleteStreamEventById(int id) {
        if (streamEventById.get(id) != null) {
            streamEventsByType.get(streamEventById.get(id).getEventType()).remove(streamEventById.get(id));
            streamEventById.remove(id);
        } else {
            throw new RuntimeException("\n" +
                    "Deletion error! Stream event not found!");
        }
    }

    public void writeStreamEvents(HashMap<Integer, StreamEvent> streamEventById) {
        for (Map.Entry entry : streamEventById.entrySet()) {
            System.out.println(entry);
        }
    }
}