package school.faang.catchingevents;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MainTest {

    @Test
    public void streamEvents() {
        StreamEvent streamEvent_1 = new StreamEvent(1, "type_1", "data_1");
        StreamEvent streamEvent_2 = new StreamEvent(2, "type_2", "data_2");
        StreamEvent streamEvent_3 = new StreamEvent(3, "type_1", "data_3");

        Main.addStreamEvent(streamEvent_1);
        Main.addStreamEvent(streamEvent_2);
        Main.addStreamEvent(streamEvent_3);

        assertEquals(Main.getStreamEventById(1).orElse(null), streamEvent_1);
        assertEquals(Main.getStreamEventById(2).orElse(null), streamEvent_2);

        assertEquals(Main.getStreamEventsByEventType("type_1"), List.of(streamEvent_1, streamEvent_3));
        assertEquals(Main.getStreamEventsByEventType("type_2"), List.of(streamEvent_2));

        Main.removeStreamEvent(1);
        assertNull(Main.getStreamEventById(1).orElse(null));
        assertEquals(Main.getStreamEventsByEventType("type_1"), List.of(streamEvent_3));


        Main.removeStreamEvent(2);
        Main.removeStreamEvent(3);
    }
}
