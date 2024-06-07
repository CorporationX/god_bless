package faang.school.godbless.catching_events;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StreamEventService streamEventService = new StreamEventService();

        // Testing Examples
        StreamEvent concert = new StreamEvent(1, "Entertainment", "Popular Singer");
        StreamEvent filmRelease = new StreamEvent(2, "Entertainment", "Popular Film");
        StreamEvent parkOpening = new StreamEvent(3, "Usual", "Beautiful Park");
        streamEventService.addStreamEvent(concert);
        streamEventService.addStreamEvent(filmRelease);
        streamEventService.addStreamEvent(parkOpening);

        streamEventService.showAllStreamEvents();

        // Before deleting event with id = 1
        StreamEvent eventWithId1 = streamEventService.findStreamEventById(1);
        System.out.println("Event with id 1 = " + eventWithId1);

        System.out.println("Entertainment events");
        List<StreamEvent> streamEventList = streamEventService.findStreamEventByEventType("Entertainment");
        if(streamEventList != null){
            for(StreamEvent streamEvent : streamEventList){
                System.out.println(streamEvent);
            }
        }

        // After deleting event with id = 1
        System.out.println("Deleting stream with id = 1");
        streamEventService.deleteStreamEvent(1, "Entertainment", "Popular Singer");

        streamEventService.deleteStreamEvent(1, "Entertainment", "Popular Singer");

        eventWithId1 = streamEventService.findStreamEventById(1);
        System.out.println("Event with id 1 = " + eventWithId1);

        System.out.println("Entertainment events");
        streamEventList = streamEventService.findStreamEventByEventType("Entertainment");
        if(streamEventList != null){
            for(StreamEvent streamEvent : streamEventList){
                System.out.println(streamEvent);
            }
        }
    }
}
