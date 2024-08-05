package faang.school.godbless.beksultan2005;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<Integer, StreamEvent> cacheById = new HashMap<>();
    private static Map<String, List<StreamEvent>> cacheByEvent = new HashMap<>();

    public static void addStreamEvent(StreamEvent streamEvent){
        cacheById.put((int) streamEvent.getId(), streamEvent);
        cacheByEvent.computeIfAbsent(streamEvent.getEventType(), k -> new ArrayList<>()).add(streamEvent);
    }

    public static StreamEvent getStreamEvent(int id){
        return cacheById.get(id);
    }

    public static List<StreamEvent> getStreamEvent(String eventType){
        return cacheByEvent.get(eventType);
    }

    public static void deleteStreamEvent(int id){
        cacheByEvent.get(cacheById.get(id).getEventType()).remove(cacheById.get(id));
        cacheById.remove(id);
    }

    public static void getAllStreamEvent(){
        cacheById.forEach((key, value) -> System.out.println(key + ": " + value.toString()));
    }

    public static void getAllStreamEventByEvent(){
        cacheByEvent.forEach((key, value) -> System.out.println(key + ": " + value.toString()));
    }

    public static void main(String[] args) {
        StreamEvent event1 = new StreamEvent(1, "Login", "User1 logged in");
        StreamEvent event2 = new StreamEvent(2, "Logout", "User1 logged out");
        StreamEvent event3 = new StreamEvent(3, "Login", "User2 logged in");

        addStreamEvent(event1);
        addStreamEvent(event2);
        addStreamEvent(event3);

        System.out.println("All stream events by ID:");
        getAllStreamEvent();

        System.out.println("\nAll stream events by event type:");
        getAllStreamEventByEvent();

        System.out.println("\nGet stream event by ID 2: " + getStreamEvent(2));

        System.out.println("\nGet stream events by event type 'Login': " + getStreamEvent("Login"));

        deleteStreamEvent(1);

        System.out.println("\nAll stream events by ID after deleting ID 1:");
        getAllStreamEvent();

        System.out.println("\nAll stream events by event type after deleting ID 1:");
        getAllStreamEventByEvent();
    }
}
