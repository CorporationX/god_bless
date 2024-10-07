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

    @BeforeEach
    void setUp() {
        streamEventService = new StreamEventService();

        event1 = new StreamEvent("INFO", "First event data");
        event2 = new StreamEvent("ERROR", "Second event data");
        event3 = new StreamEvent("INFO", "Third event data");
    }

    @Test
    @DisplayName("Adding events")
    void testAddingEvents() {
        addThreeEvents();

        assertEquals(streamEventService.getEventsCount(), 3);
        assertEquals(streamEventService.getEventGroupsCount(), 2);
    }

    @Test
    @DisplayName("Getting event by its id")
    void testGetEventById() {
        addThreeEvents();

        assertEquals(event2, streamEventService.getEvent(event2.getId()));
    }

    @Test
    @DisplayName("Getting events by theirs types")
    void testGetEventsByType() {
        addThreeEvents();

        assertEquals(2, streamEventService.getEvents("INFO").size());
        assertEquals(1, streamEventService.getEvents("ERROR").size());
    }

    @Test
    @DisplayName("Removing event")
    void testRemoveEventById() {
        addThreeEvents();
        int event1Id = event1.getId();
        streamEventService.removeEvent(event1Id);

        assertEquals(2, streamEventService.getEventsCount());
        assertNull(streamEventService.getEvent(event1Id));
    }

    private void addThreeEvents() {
        streamEventService.addEvent(event1);
        streamEventService.addEvent(event2);
        streamEventService.addEvent(event3);
    }
}