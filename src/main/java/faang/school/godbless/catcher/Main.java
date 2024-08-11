package faang.school.godbless.catcher;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static faang.school.godbless.catcher.StreamEventService.*;

public class Main {

    public static Map<Integer, StreamEvent> streamEventIdMap = new HashMap<>();
    public static Map<String, List<StreamEvent>> streamEventTypeMap = new HashMap<>();

    public static void main(String[] args) {
        StreamEvent streamEvent = new StreamEvent(1, "Test", "test");
        addStreamEventAndUpdateMaps(streamEvent);
        streamEvent = new StreamEvent(1, "Test1", "test1");
        addStreamEventAndUpdateMaps(streamEvent);
        streamEvent = new StreamEvent(2, "Test", "test");
        addStreamEventAndUpdateMaps(streamEvent);

        printStreamEventById();
        System.out.println();
        printStreamEventByEventType();

        System.out.println();
        System.out.println(findStreamEventById(1));
        System.out.println();
        System.out.println(findStreamEventByEventType("Test"));

        removeStreamEventAndUpdateMaps(1);
        System.out.println();
        printStreamEventById();
        printStreamEventByEventType();
    }
}
