package faang.school.godbless.BJS2_20802;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest extends Main {
    private Main main;
    private StreamEvent streamEvent1;
    private StreamEvent streamEvent2;

    @BeforeEach
    void setUp() {
        main = new Main();
        streamEvent1 = new StreamEvent(1, "Тип1", "Привет");
        streamEvent2 = new StreamEvent(2, "Тип2", "Здорово");
        main.addStreamEvent(streamEvent1);
        main.addStreamEvent(streamEvent2);
    }

    @Test
    void testAddStreamEvent() {
        assertTrue(main.getStreamEventMap().containsKey(1));
    }

    @Test
    void testFindStreamEvent() {
        StreamEvent streamEvent = main.findStreamEvent(streamEvent1.getId());
        assertEquals(1, streamEvent.getId());
    }

    @Test
    void testFindStreamEvents() {
        List<StreamEvent> eventList = main.findStreamEvents("Тип1");
        assertTrue(eventList.contains(streamEvent1));
    }

    @Test
    void testRemoveStreamEvent() {
        main.removeStreamEvent(1);
        assertFalse(main.getStreamEventMap().containsKey(1));
    }
}