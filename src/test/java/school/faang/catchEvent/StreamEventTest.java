package school.faang.catchEvent;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StreamEventTest {
    private final int id = 1;
    private final String eventType = "eventType";
    private final String data = "data";
    private Main eventClass;

    @BeforeEach
    void setUp() {
        eventClass = new Main();
    }

    @Test
    void addAndGetEventTest() {
        eventClass.addNewStreamEvent(id, eventType, data);
        assertEquals(new StreamEvent(id, eventType, data), eventClass.getStreamEvent(id));
    }

    @Test
    void getStreamEventListTest() {
        eventClass.addNewStreamEvent(id, eventType, data);
        assertTrue(eventClass.getStreamEventList(eventType).contains(new StreamEvent(id, eventType, data)));
    }

    @Test
    void removeEventTest() {
        eventClass.addNewStreamEvent(id, eventType, data);
        eventClass.removeStreamEvent(id);
        assertNull(eventClass.getStreamEvent(id));
    }
}
