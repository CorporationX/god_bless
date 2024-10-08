package catchingEvents;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, StreamEvent> streamEventMap = new HashMap<>();
        Map<String, List<StreamEvent>> specificStreamEventMap = new HashMap<>();

        StreamEvent event1 = new StreamEvent(1, "LOGIN", "User logged in");
        StreamEvent event2 = new StreamEvent(2, "LOGOUT", "User logged out");
        StreamEvent event3 = new StreamEvent(10, "LOGIN", "User registration");

        try {
            StreamEvent event4 = new StreamEvent(10, "", "djksf");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }

        StreamEvent.addStreamEvent(streamEventMap, specificStreamEventMap, event1);
        StreamEvent.printAllStreamEventMap(streamEventMap);
        StreamEvent.printSpecificEventMap(specificStreamEventMap);

        System.out.println("\n");
        StreamEvent.addStreamEvent(streamEventMap, specificStreamEventMap, event2);
        StreamEvent.addStreamEvent(streamEventMap, specificStreamEventMap, event3);
        StreamEvent.printAllStreamEventMap(streamEventMap);
        StreamEvent.printSpecificEventMap(specificStreamEventMap);

        System.out.println("\n");
        System.out.println(StreamEvent.findStreamEvent(2, streamEventMap));
        System.out.println(StreamEvent.findStreamEventList("LOGIN", specificStreamEventMap));

        System.out.println("\n");

        try {
            StreamEvent.removeStreamEvent(22, streamEventMap, specificStreamEventMap);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        StreamEvent.printAllStreamEventMap(streamEventMap);
        StreamEvent.printSpecificEventMap(specificStreamEventMap);

        System.out.println("\n");
        StreamEvent.removeStreamEvent(1, streamEventMap, specificStreamEventMap);
        StreamEvent.printAllStreamEventMap(streamEventMap);
        StreamEvent.printSpecificEventMap(specificStreamEventMap);
    }
}
