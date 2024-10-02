package dima.evseenko.events;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StreamControllerTest {

    @Test
    void addEvent() {
        StreamController sc = new StreamController();
        sc.addEvent(new StreamEvent(1L, EventType.STREAM_VIDEO, "video..."));

        assertEquals(new StreamEvent(1L, EventType.STREAM_VIDEO, "video..."), sc.getEvent(1L));
    }

    @Test
    void addNullEvent() {
        assertThrows(IllegalArgumentException.class, () -> new StreamController().addEvent(null));
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
    void deleteNullEvent() {
        assertThrows(IllegalArgumentException.class, () -> new StreamController().deleteEvent(null));
    }

    @Test
    void getEvent() {
        StreamController sc = new StreamController();
        sc.addEvent(new StreamEvent(1L, EventType.STREAM_VIDEO, "video..."));

        assertEquals(new StreamEvent(1L, EventType.STREAM_VIDEO, "video..."), sc.getEvent(1L));
    }

    @Test
    void getEventByNullId(){
        assertThrows(IllegalArgumentException.class, () -> new StreamController().getEvent(null));
    }

    @Test
    void getEvents() {
        StreamController sc = new StreamController();
        sc.addEvent(new StreamEvent(1L, EventType.STREAM_VIDEO, "video..."));

        assertTrue(sc.getEvents(EventType.STREAM_VIDEO).contains(new StreamEvent(1L, EventType.STREAM_VIDEO, "video...")));
    }

    @Test
    void getEventsByNullEventType(){
        assertThrows(IllegalArgumentException.class, () -> new StreamController().getEvents(null));
    }
}