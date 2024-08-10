package faang.school.godbless.events;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventManagementTest {
    private EventManagement events;

    @Test
    void shouldAddEvent() {
        events = new EventManagement();
        events.addEvent(new StreamEvent(1, "subscribe", "a"));
        events.addEvent(new StreamEvent(2, "subscribe", "b"));
        assertEquals("a", events.searchById(1).getData());
        assertEquals(2, events.searchByType("subscribe").size());
    }

    @Test
    void shouldRemoveEvent() {
        events = new EventManagement();
        events.addEvent(new StreamEvent(1, "subscribe", "a"));
        events.addEvent(new StreamEvent(2, "subscribe", "b"));
        events.removeEvent(1);
        assertNull(events.searchById(1));
        assertEquals("b", events.searchById(2).getData());
    }

    @Test
    void shouldGetReport() {
        events = new EventManagement();
        events.addEvent(new StreamEvent(1, "subscribe", "a"));
        events.addEvent(new StreamEvent(2, "subscribe", "b"));
        String expected = """
                1:subscribe,a
                2:subscribe,b
                """;
        assertEquals(expected, events.getAllStreamsReport());
    }
}