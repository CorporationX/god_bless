package CatchingEvents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    private static final HashMap<Integer, StreamEvent> streamEvents = new HashMap<>();
    private static final HashMap<String, List<StreamEvent>> streamEventsByType = new HashMap<>();

    public static void main(String[] args) {
        addStreamEvent(1, "click", "click on red button");
        addStreamEvent(2, "copy", "copied text to the clipboard");
        addStreamEvent(3, "paste", "pasted text from the clipboard");
        addStreamEvent(4, "copy", "copied text to the clipboard");

        System.out.println(getStreamEventById(2));
        System.out.println(getStreamEventsByType("copy"));
        printInfoAboutStreamEvents();
        deleteStreamEventById(4);
        printInfoAboutStreamEvents();
    }


    public static StreamEvent addStreamEvent(int id, String eventType, String data) {
        StreamEvent streamEvent = new StreamEvent(id, eventType, data);
        streamEvents.put(id, streamEvent);
        if(!streamEventsByType.containsKey(eventType)) {
            streamEventsByType.put(eventType, new ArrayList<>());
        }
        streamEventsByType.get(eventType).add(streamEvent);
        return streamEvent;
    }

    public static StreamEvent getStreamEventById(int id) {
        return streamEvents.get(id);
    }
    public static List<StreamEvent> getStreamEventsByType(String eventType) {
        return streamEventsByType.get(eventType);
    }

    public static void deleteStreamEventById(int id) {
        StreamEvent streamEvent = streamEvents.get(id);
        streamEventsByType.get(streamEvent.getEventType()).remove(streamEvent);
        streamEvents.remove(id);
    }

    public static void printInfoAboutStreamEvents(){
        for(StreamEvent streamEvent : streamEvents.values()) {
            System.out.println(streamEvent);
        }
    }
}
