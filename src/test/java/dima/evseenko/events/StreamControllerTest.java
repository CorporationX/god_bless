package dima.evseenko.events;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StreamControllerTest {

    @Test
    void addEvent() {
        StreamController sc = new StreamController();
        sc.addEvent(new StreamEvent(1L, EventType.STREAM_VIDEO, "video..."));

        assertEquals(new StreamEvent(1L, EventType.STREAM_VIDEO, "video..."), sc.getEvent(1L));
    }

    @Test
    void deleteEvent() {
        StreamEvent event = new StreamEvent(1L, EventType.STREAM_VIDEO, "video...");

        StreamController sc = new StreamController();
        sc.addEvent(event);
        sc.deleteEvent(event);

        assertNull(sc.getEvent(1L));
    }

    @Test
    void getEvent() {
        StreamController sc = new StreamController();
        sc.addEvent(new StreamEvent(1L, EventType.STREAM_VIDEO, "video..."));

        assertEquals(new StreamEvent(1L, EventType.STREAM_VIDEO, "video..."), sc.getEvent(1L));
    }

    @Test
    void getEvents() {
        StreamController sc = new StreamController();
        sc.addEvent(new StreamEvent(1L, EventType.STREAM_VIDEO, "video..."));

        assertTrue(sc.getEvents(EventType.STREAM_VIDEO).contains(new StreamEvent(1L, EventType.STREAM_VIDEO, "video...")));
    }
}