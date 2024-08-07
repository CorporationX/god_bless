package faang.school.godbless.BJS2_20441;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, StreamEvent> mapEvent = new HashMap<>();
        Map<String, List<StreamEvent>> mapListEvent = new HashMap<>();

        StreamEvent discoEvent = new StreamEvent(1, "Disco", "random text");
        StreamEvent pairProgrammingEvent = new StreamEvent(2, "pair programming", "dfdf");
        StreamEvent.addEvent(discoEvent, mapEvent, mapListEvent);
        StreamEvent.addEvent(pairProgrammingEvent, mapEvent, mapListEvent);

        StreamEvent.searchEventId(1, mapEvent);
        StreamEvent.searchEventType("pair programming", mapListEvent);

        StreamEvent.deleteEventById(1, mapEvent, mapListEvent);

        for (Map.Entry<Integer, StreamEvent> entry : mapEvent.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        for (Map.Entry<String, List<StreamEvent>> entry : mapListEvent.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

    }

}
