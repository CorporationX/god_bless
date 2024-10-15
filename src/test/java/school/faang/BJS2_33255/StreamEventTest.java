package school.faang.BJS2_33255;

import org.junit.jupiter.api.Test;
import school.faang.firstStream.BJS2_33255.Main;
import school.faang.firstStream.BJS2_33255.StreamEvent;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StreamEventTest {
    @Test
    void addEvent() {
        StreamEvent streamEvent = new StreamEvent(1, "TypeA", "Data Type A Event 1");

        Main.addNewEvent(streamEvent);
        assertEquals(streamEvent, Main.getEventById(1));
    }

    @Test
    void getEventByIdTest() {
        StreamEvent streamEvent = new StreamEvent(1, "TypeA", "Data Type A Event 1");

        Main.addNewEvent(streamEvent);
        assertEquals(streamEvent, Main.getEventById(1));
    }

    @Test
    void getEventListByEventTypeTest() {
        StreamEvent streamEvent1 = new StreamEvent(1, "TypeA", "Data Type A Event 1");
        StreamEvent streamEvent2 = new StreamEvent(2, "TypeA", "Data Type A Event 2");
        Main.addNewEvent(streamEvent1);
        Main.addNewEvent(streamEvent2);

        assertNotNull(Main.getEventsListByEventType(streamEvent1.getEventType()));
    }

    @Test
    void deleteEventByIdTest() {
        StreamEvent streamEvent = new StreamEvent(1, "TypeA", "Data Type A Event 1");
        Main.addNewEvent(streamEvent);

        Main.deleteEventById(streamEvent.getId());
        assertNull(Main.getEventById(streamEvent.getId()));
    }
}
