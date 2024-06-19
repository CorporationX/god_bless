package faang.school.godbless.java_sql.task_5;

import java.util.ArrayList;

public class ProvideStreamEvents {

    final static String[] EVENT_TYPES = {"CREATE", "UPDATE", "DELETE"};

    static ArrayList<StreamEvent> provideStreamEvents() {
        ArrayList<StreamEvent> streamEvents = new ArrayList<>();
        var firstStreamEvent = new StreamEvent(0, EVENT_TYPES[0], "Data 0");
        var secondStreamEvent = new StreamEvent(1, EVENT_TYPES[1], "Data 1");
        var thirdStreamEvent = new StreamEvent(2, EVENT_TYPES[2], "Data 2");
        var fourthStreamEvent = new StreamEvent(3, EVENT_TYPES[0], "Data 3");
        var fifthStreamEvent = new StreamEvent(4, EVENT_TYPES[1], "Data 4");
        var sixthStreamEvent = new StreamEvent(5, EVENT_TYPES[2], "Data 5");
        streamEvents.add(firstStreamEvent);
        streamEvents.add(secondStreamEvent);
        streamEvents.add(thirdStreamEvent);
        streamEvents.add(fourthStreamEvent);
        streamEvents.add(fifthStreamEvent);
        streamEvents.add(sixthStreamEvent);
        return streamEvents;
    }
}
