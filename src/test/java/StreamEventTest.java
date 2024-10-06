import model.StreamEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.StreamEventService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class StreamEventTest {
    private List<StreamEvent> events;

    @BeforeEach
    void setUp() {
        StreamEventService.eventById = new HashMap<>();
        StreamEventService.eventsByType = new HashMap<>();
        events = new ArrayList<>(Arrays.asList(
                new StreamEvent(1, "programming", "some data about programming"),
                new StreamEvent(2, "sport", "some data about sport"),
                new StreamEvent(3, "study", "some data  about study"),
                new StreamEvent(4, "AI", "some data about AI")
        ));

        events.forEach(StreamEventService::addEvent);
    }

    @Test
    @DisplayName("test to add stream event to hashmap")
    void testToAddEvent() {
        assertEquals(
                StreamEventService.eventById.size(),
                StreamEventService.eventsByType.size()
        );
        assertEquals(4, StreamEventService.eventById.size());
    }

    @Test
    @DisplayName("test to find event by id")
    void testToFindById() {
        assertEquals("programming", StreamEventService.findStreamEventById(1).getEventType());
        assertEquals("sport", StreamEventService.findStreamEventById(2).getEventType());
        assertEquals("study", StreamEventService.findStreamEventById(3).getEventType());
        assertEquals("AI", StreamEventService.findStreamEventById(4).getEventType());
    }

    @Test
    @DisplayName("test to find events by event type")
    void testToFindEventsByType() {
        assertEquals(1, StreamEventService.findStreamEventsByEvenType("programming").size());
        assertEquals(
                "some data about AI",
                StreamEventService.findStreamEventsByEvenType("AI").get(0).getData()
        );
    }

    @Test
    @DisplayName("test to remove event by id")
    void testToRemoveEventById() {
        StreamEventService.removeStreamEventById(2);

        assertNull(StreamEventService.findStreamEventsByEvenType("sport"));
    }
}
