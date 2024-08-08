package catchEvent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, StreamEvent> idEvent = new HashMap<>();
        Map<String, List<StreamEvent>> typeEventSearch = new HashMap<>();

        StreamEvent event = new StreamEvent(0,"Birthday","Mama");
        StreamEvent event1 = new StreamEvent(1,"Birthday","Papa");

        StreamEvent.addEvent(event, idEvent, typeEventSearch);
        StreamEvent.addEvent(event1, idEvent, typeEventSearch);

        System.out.println();

        StreamEvent.eventIdSearch(0, idEvent);
        StreamEvent.eventTypeSearch("Birthday", typeEventSearch);

        System.out.println();

        StreamEvent.allEvents(idEvent, typeEventSearch);
        StreamEvent.deleteEventID(0, idEvent, typeEventSearch);
        StreamEvent.deleteEventID(1, idEvent, typeEventSearch);
    }
}
