package faang.school.godbless.catching_events;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, StreamEvent> eventMap = new HashMap<>();
        Map<String, List<StreamEvent>> eventTypeMap = new HashMap<>();

        // Testing Examples
        StreamEvent concert = new StreamEvent(1, "Entertainment", "Popular Singer");
        StreamEvent filmRelease = new StreamEvent(2, "Entertainment", "Popular Film");
        StreamEvent parkOpening = new StreamEvent(3, "Usual", "Beautiful Park");
        StreamEvent.addStreamEvent(eventMap, eventTypeMap, concert);
        StreamEvent.addStreamEvent(eventMap, eventTypeMap, filmRelease);
        StreamEvent.addStreamEvent(eventMap, eventTypeMap, parkOpening);

        StreamEvent.showAllStreamEvents(eventMap);

        // Before deleting event with id = 1
        StreamEvent eventWithId1 = StreamEvent.findStreamEventById(eventMap, 1);
        System.out.println("Event with id 1 = " + eventWithId1);

        System.out.println("Entertainment events");
        List<StreamEvent> streamEventList = StreamEvent.findStreamEventByEventType(eventTypeMap, "Entertainment");
        if(streamEventList != null){
            for(StreamEvent streamEvent : streamEventList){
                System.out.println(streamEvent);
            }
        }

        // After deleting event with id = 1
        System.out.println("Deleting stream with id = 1");
        StreamEvent.deleteStreamEvent(eventMap, eventTypeMap, eventWithId1);

        eventWithId1 = StreamEvent.findStreamEventById(eventMap, 1);
        System.out.println("Event with id 1 = " + eventWithId1);

        System.out.println("Entertainment events");
        streamEventList = StreamEvent.findStreamEventByEventType(eventTypeMap, "Entertainment");
        if(streamEventList != null){
            for(StreamEvent streamEvent : streamEventList){
                System.out.println(streamEvent);
            }
        }
    }
}
