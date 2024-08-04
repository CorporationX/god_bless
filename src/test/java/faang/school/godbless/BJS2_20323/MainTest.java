package faang.school.godbless.BJS2_20323;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    Main main;

    @BeforeEach
    void init() {
        main = new Main();
    }

    @Test
    void addStreamEventTest() {
        int eventsByIdSizeBefore = main.getEventsById().size();
        int postEventsSize = main.getStreamEventsByType("Post").size();

        StreamEvent event = new StreamEvent(7, "Post", "Газета");
        main.addStreamEvent(event);

        assertEquals(eventsByIdSizeBefore + 1, main.getEventsById().size());
        assertEquals(postEventsSize + 1, main.getStreamEventsByType("Post").size());

    }

    @Test
    void getStreamEventByIdTest() {
        StreamEvent expected = new StreamEvent(1, "SMS", "Списание средств: -50 р.");
        StreamEvent result = main.getStreamEventById(1);
        assertEquals(expected, result);
    }

    @Test
    void getStreamEventsByTypeTest() {
        StreamEvent event1 = new StreamEvent(1, "SMS", "Списание средств: -50 р.");
        StreamEvent event2 = new StreamEvent(5, "SMS", "Абнент 123 не в сети");
        List<StreamEvent> expected = List.of(event1, event2);
        List<StreamEvent> result = main.getStreamEventsByType("SMS");
        assertEquals(expected, result);
    }

    @Test
    void deleteStreamEventTest() {
        int eventsByIdSizeBefore = main.getEventsById().size();
        int postEventsSize = main.getStreamEventsByType("SMS").size();
        Integer id = 1;

        boolean result = main.deleteStreamEvent(id);

        assertTrue(result);
        assertEquals(eventsByIdSizeBefore - 1, main.getEventsById().size());
        assertEquals(postEventsSize - 1, main.getStreamEventsByType("SMS").size());
    }

    @Test
    void testPrintEvents() {
        main.printEvents();
    }
}