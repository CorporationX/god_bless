package BJS2_20429;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, StreamEvent> events = new HashMap<>();
        Map<String, List<StreamEvent>> eventInfo = new HashMap<>();

        events.put(1, new StreamEvent(1, "Work", "Work isn't a wolf and won't ran to the forest"));
        events.put(2, new StreamEvent(2, "Work", "Work is hard"));
        events.put(3, new StreamEvent(3, "Study", "Need some motivation"));
        events.put(4, new StreamEvent(4, "Play", "Play is fun!"));

        List<StreamEvent> workList = new ArrayList<>();
        workList.add(new StreamEvent(5, "Work", "Work isn't a wolf and won't ran to the forest"));
        workList.add(new StreamEvent(6, "Work", "Work is hard"));
        List<StreamEvent> studyList = new ArrayList<>();
        studyList.add(new StreamEvent(7, "Study", "Need some motivation"));
        List<StreamEvent> playList = new ArrayList<>();
        playList.add(new StreamEvent(8, "Play", "Play is fun!"));

        eventInfo.put(workList.get(0).getEventType(), workList);
        eventInfo.put(studyList.get(0).getEventType(), studyList);
        eventInfo.put(playList.get(0).getEventType(), playList);

        StreamEvent streamEventTest = new StreamEvent(10, "Work", "Work work work...");

        //Add new event in two HashMaps
        addNewEvent(events, eventInfo, streamEventTest);

        //Get stream by id
        getStreamEventById(events, streamEventTest);

        //Get stream list by EventType
        getStreamEventListByEventType(eventInfo, streamEventTest);

        //remove event from two HashMaps
        removeStreamEventById(events, eventInfo, streamEventTest);

        //Get all streams
        getAllStreamEvent(events, eventInfo);

    }

    public static void addNewEvent(Map<Integer, StreamEvent> events,
                                   Map<String, List<StreamEvent>> eventInfo, StreamEvent event) {
        if (!events.containsKey(event.getId())) {
            events.put(event.getId(), event);
            System.out.println("New event " + event.getEventType() + " was added!");
        }
        if (!eventInfo.containsKey(event.getEventType())) {
            eventInfo.put(event.getEventType(), new ArrayList<>());
            eventInfo.get(event.getEventType()).add(event);
        } else {
            eventInfo.get(event.getEventType()).add(event);
            System.out.println("New event " + event.getEventType() + " was added in the list!");
        }
    }

    public static void getStreamEventById(Map<Integer, StreamEvent> events, StreamEvent event) {
        System.out.println(events.get(event.getId()));
    }

    public static void getStreamEventListByEventType(Map<String, List<StreamEvent>> eventInfo, StreamEvent event) {
        System.out.println(eventInfo.get(event.getEventType()));
    }

    public static void removeStreamEventById(Map<Integer, StreamEvent> events,
                                             Map<String, List<StreamEvent>> eventInfo, StreamEvent event) {
        events.remove(event.getId());
        eventInfo.get(event.getEventType()).remove(event);
        System.out.println("Event " + event.getEventType() + " was removed!");
    }

    public static void getAllStreamEvent(Map<Integer, StreamEvent> events, Map<String, List<StreamEvent>> eventInfo) {
        for (Map.Entry<Integer, StreamEvent> entry : events.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        for (Map.Entry<String, List<StreamEvent>> entry : eventInfo.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

}
