package BJS2_20429;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, StreamEvent> eventsById = new HashMap<>();
        Map<String, List<StreamEvent>> eventInfoByType = new HashMap<>();

        eventsById.put(1, new StreamEvent(1, "Work", "Work isn't a wolf and won't ran to the forest"));
        eventsById.put(2, new StreamEvent(2, "Work", "Work is hard"));
        eventsById.put(3, new StreamEvent(3, "Study", "Need some motivation"));
        eventsById.put(4, new StreamEvent(4, "Play", "Play is fun!"));

        List<StreamEvent> workList = new ArrayList<>();
        workList.add(new StreamEvent(5, "Work", "Work isn't a wolf and won't ran to the forest"));
        workList.add(new StreamEvent(6, "Work", "Work is hard"));
        List<StreamEvent> studyList = new ArrayList<>();
        studyList.add(new StreamEvent(7, "Study", "Need some motivation"));
        List<StreamEvent> playList = new ArrayList<>();
        playList.add(new StreamEvent(8, "Play", "Play is fun!"));

        eventInfoByType.put(workList.get(0).getEventType(), workList);
        eventInfoByType.put(studyList.get(0).getEventType(), studyList);
        eventInfoByType.put(playList.get(0).getEventType(), playList);

        StreamEvent streamEventTest = new StreamEvent(10, "Work", "Work work work...");

        //Add new event in two HashMaps
        addNewEvent(eventsById, eventInfoByType, streamEventTest);

        //Trying to add null as event argument
        addNewEvent(eventsById, eventInfoByType, null);

        //Get stream by id and null check
        getStreamEventById(eventsById, streamEventTest);
        getStreamEventById(eventsById, null);


        //Get stream list by EventType and null check
        getStreamEventListByEventType(eventInfoByType, streamEventTest);
        getStreamEventListByEventType(eventInfoByType, null);

        //remove event from two HashMaps and null check
        removeStreamEventById(eventsById, eventInfoByType, streamEventTest);
        removeStreamEventById(eventsById, eventInfoByType, null);

        //Get all streams
        getAllStreamEvent(eventsById, eventInfoByType);

    }

    public static void addNewEvent(Map<Integer, StreamEvent> eventsById,
                                   Map<String, List<StreamEvent>> eventInfoByType, StreamEvent event) {
        try {
            eventsById.putIfAbsent(event.getId(), event);
            eventInfoByType.computeIfAbsent(event.getEventType(), key -> new ArrayList<>()).add(event);
            System.out.println("New event " + event.getEventType() + " was added!");
        } catch (NullPointerException e) {
            System.out.println("Event can't be null!");
        }
    }

    public static void getStreamEventById(Map<Integer, StreamEvent> eventsById, StreamEvent event) {
        try {
            if (eventsById.get(event.getId()) != null) {
                System.out.println(eventsById.get(event.getId()));
            } else {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            System.out.println("Error event is null!");
        }
    }

    public static void getStreamEventListByEventType(Map<String, List<StreamEvent>> eventInfoByType, StreamEvent event) {
        try {
            if (eventInfoByType.get(event.getEventType()) != null) {
                System.out.println(eventInfoByType.get(event.getEventType()));
            } else {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            System.out.println("Error event is null!");
        }

    }

    public static void removeStreamEventById(Map<Integer, StreamEvent> eventsById,
                                             Map<String, List<StreamEvent>> eventInfoByType, StreamEvent event) {
        try {
            eventsById.remove(event.getId());
            eventInfoByType.get(event.getEventType()).remove(event);
            System.out.println("Event " + event.getEventType() + " was removed!");
        } catch (NullPointerException e) {
            System.out.println("Error event is null!");
        }
    }

    public static void getAllStreamEvent(Map<Integer, StreamEvent> eventsById, Map<String, List<StreamEvent>> eventInfoByType) {
        for (Map.Entry<Integer, StreamEvent> entry : eventsById.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        for (Map.Entry<String, List<StreamEvent>> entry : eventInfoByType.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
