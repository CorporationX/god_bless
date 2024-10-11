package school.faang.stream.event;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class StreamEventStorageTest {

    private StreamEventStorage streamEventStorage;

    private StreamEvent streamEvent1;
    private StreamEvent streamEvent2;
    private StreamEvent streamEvent3;

    @BeforeEach
    public void setUp() {
        streamEventStorage = new StreamEventStorage();

        streamEvent1 = new StreamEvent(1, "eventType1", "data1");
        streamEvent2 = new StreamEvent(2, "eventType1", "data2");
        streamEvent3 = new StreamEvent(3, "eventType2", "data3");

        streamEventStorage.add(streamEvent1);
        streamEventStorage.add(streamEvent2);
        streamEventStorage.add(streamEvent3);
    }

    @Test
    public void addAndFindByIdTest() {
        StreamEvent streamEventById = streamEventStorage.findById(streamEvent1.getId());
        assertEquals(streamEventById, streamEvent1);
    }

    @Test
    public void addAndFindByEventTypeTest() {
        List<StreamEvent> streamEvents = streamEventStorage.findByEventType("eventType1");
        assertEquals(2, streamEvents.size());
    }

    @Test
    public void deleteByIdTest() {
        streamEventStorage.deleteById(1);
        List<StreamEvent> streamEvents = streamEventStorage.findByEventType("eventType1");
        assertEquals(1, streamEvents.size());
    }

    @Test
    public void deleteByIdLastStreamEventTest() {
        streamEventStorage.deleteById(3);
        List<StreamEvent> streamEvents = streamEventStorage.findByEventType("eventType2");
        assertNull(streamEvents);
    }

    @Test
    public void printAllStreamEventsTest() {
        streamEventStorage.printAllStreamEvent();
    }
}
