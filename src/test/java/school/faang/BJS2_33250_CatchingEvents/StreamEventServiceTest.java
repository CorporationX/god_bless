package school.faang.BJS2_33250_CatchingEvents;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class StreamEventServiceTest {
    StreamEventService streamEventService;

    StreamEvent event1;
    StreamEvent event2;
    StreamEvent event3;
    StreamEvent event4;

    @BeforeEach
    void setUp() {
        streamEventService = new StreamEventService();

        event1 = new StreamEvent("INFO", "First event data");
        event2 = new StreamEvent("ERROR", "Second event data");
        event3 = new StreamEvent("INFO", "Third event data");
        event4 = new StreamEvent("DEBUG", "Fourth event data");

        streamEventService.addEvent(event1);
        streamEventService.addEvent(event2);
        streamEventService.addEvent(event3);
        streamEventService.addEvent(event4);
    }

    @Test
    @DisplayName("Adding events")
    void testAddingEvents() {
        assertEquals(streamEventService.getEventsCount(), 4);
        assertEquals(streamEventService.getEventGroupsCount(), 3);
    }

    @Test
    @DisplayName("Getting event by its id")
    void testGetEventById() {
        assertEquals(event2, streamEventService.getEvent(event2.getId()));
    }

    @Test
    @DisplayName("Getting events by theirs types")
    void testGetEventsByType() {
        assertEquals(2, streamEventService.getEvents("INFO").size());
        assertEquals(1, streamEventService.getEvents("DEBUG").size());
        assertEquals(1, streamEventService.getEvents("ERROR").size());
    }

    @Test
    @DisplayName("Removing event")
    void testRemoveEventById() {
        int event1Id = event1.getId();
        streamEventService.removeEvent(event1Id);

        assertEquals(3, streamEventService.getEventsCount());
        assertNull(streamEventService.getEvent(event1Id));
    }
}