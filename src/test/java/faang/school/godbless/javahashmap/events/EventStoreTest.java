package faang.school.godbless.javahashmap.events;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EventStoreTest {

    private static final String USER_CREATED_TYPE = "UserCreated";
    private static final String USER_UPDATED_TYPE = "UserUpdated";
    private static final StreamEvent EVENT_1 = new StreamEvent(1, USER_CREATED_TYPE, "name: Aleksandr");
    private static final StreamEvent EVENT_2 = new StreamEvent(2, USER_CREATED_TYPE, "name: Victor");
    private static final StreamEvent EVENT_3 = new StreamEvent(3, USER_CREATED_TYPE, "name: Sasha");
    private static final StreamEvent EVENT_4 = new StreamEvent(4, USER_CREATED_TYPE, "name: Natasha");
    private static final StreamEvent EVENT_5 = new StreamEvent(2, USER_UPDATED_TYPE, "name: Natasha New");
    private static final String ALL_EVENTS_INFO = """
            ID: 1, Type: UserCreated, Data: name: Aleksandr\r
            ID: 2, Type: UserCreated, Data: name: Victor\r
            ID: 3, Type: UserCreated, Data: name: Sasha\r
            ID: 4, Type: UserCreated, Data: name: Natasha\r
            """;

    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;

    @Test
    void testAddOrUpdateEvent_OnlyAdd() {
        EventStore eventStore = new EventStore();

        eventStore.addOrUpdateEvent(EVENT_1);
        eventStore.addOrUpdateEvent(EVENT_2);
        eventStore.addOrUpdateEvent(EVENT_3);
        eventStore.addOrUpdateEvent(EVENT_4);

        Map<Integer, StreamEvent> eventsGroupById = eventStore.getDeepCopyOfAllEventsGroupById();
        assertEquals(4, eventsGroupById.size());
        assertEquals(EVENT_1, eventsGroupById.get(1));
        assertEquals(EVENT_2, eventsGroupById.get(2));
        assertEquals(EVENT_3, eventsGroupById.get(3));
        assertEquals(EVENT_4, eventsGroupById.get(4));

        Map<String, List<StreamEvent>> eventsGroupByType = eventStore.getDeepCopyOfAllEventsGroupByType();
        assertEquals(1, eventsGroupByType.size());
        List<StreamEvent> streamEvents = eventsGroupByType.get(USER_CREATED_TYPE);
        assertEquals(4, streamEvents.size());
        assertTrue(streamEvents.contains(EVENT_1));
        assertTrue(streamEvents.contains(EVENT_2));
        assertTrue(streamEvents.contains(EVENT_3));
        assertTrue(streamEvents.contains(EVENT_4));
    }

    @Test
    void testAddOrUpdateEvent_AddAndUpdate() {
        EventStore eventStore = new EventStore();

        eventStore.addOrUpdateEvent(EVENT_1);
        eventStore.addOrUpdateEvent(EVENT_2);
        eventStore.addOrUpdateEvent(EVENT_3);
        eventStore.addOrUpdateEvent(EVENT_4);
        eventStore.addOrUpdateEvent(EVENT_5);

        Map<Integer, StreamEvent> eventsGroupById = eventStore.getDeepCopyOfAllEventsGroupById();
        assertEquals(4, eventsGroupById.size());
        assertEquals(EVENT_1, eventsGroupById.get(1));
        assertEquals(EVENT_5, eventsGroupById.get(2));
        assertEquals(EVENT_3, eventsGroupById.get(3));
        assertEquals(EVENT_4, eventsGroupById.get(4));

        Map<String, List<StreamEvent>> eventsGroupByType = eventStore.getDeepCopyOfAllEventsGroupByType();
        assertEquals(2, eventsGroupByType.size());

        List<StreamEvent> streamEventsCreated = eventsGroupByType.get(USER_CREATED_TYPE);
        assertEquals(3, streamEventsCreated.size());
        assertTrue(streamEventsCreated.contains(EVENT_1));
        assertTrue(streamEventsCreated.contains(EVENT_3));
        assertTrue(streamEventsCreated.contains(EVENT_4));

        List<StreamEvent> streamEventsUpdated = eventsGroupByType.get(USER_UPDATED_TYPE);
        assertEquals(1, streamEventsUpdated.size());
        assertTrue(streamEventsUpdated.contains(EVENT_5));
    }

    @Test
    void testFindEventById() {
        EventStore eventStore = new EventStore();

        eventStore.addOrUpdateEvent(EVENT_1);
        eventStore.addOrUpdateEvent(EVENT_2);
        eventStore.addOrUpdateEvent(EVENT_3);
        eventStore.addOrUpdateEvent(EVENT_4);

        assertEquals(EVENT_1, eventStore.findEventById(1));
        assertEquals(EVENT_2, eventStore.findEventById(2));
        assertEquals(EVENT_3, eventStore.findEventById(3));
        assertEquals(EVENT_4, eventStore.findEventById(4));
        assertNull(eventStore.findEventById(5));
    }

    @Test
    void testFindEventsByType() {
        EventStore eventStore = new EventStore();

        eventStore.addOrUpdateEvent(EVENT_1);
        eventStore.addOrUpdateEvent(EVENT_2);
        eventStore.addOrUpdateEvent(EVENT_3);
        eventStore.addOrUpdateEvent(EVENT_4);
        eventStore.addOrUpdateEvent(EVENT_5);

        List<StreamEvent> eventsCreated = eventStore.findEventsByType(USER_CREATED_TYPE);
        assertEquals(3, eventsCreated.size());
        assertTrue(eventsCreated.contains(EVENT_1));
        assertTrue(eventsCreated.contains(EVENT_3));
        assertTrue(eventsCreated.contains(EVENT_4));

        List<StreamEvent> eventsUpdated = eventStore.findEventsByType(USER_UPDATED_TYPE);
        assertEquals(1, eventsUpdated.size());
        assertTrue(eventsUpdated.contains(EVENT_5));

        assertEquals(0, eventStore.findEventsByType("UnknownType").size());
    }

    @Test
    void testDeleteEventById() {
        EventStore eventStore = new EventStore();

        eventStore.addOrUpdateEvent(EVENT_1);
        eventStore.addOrUpdateEvent(EVENT_2);
        eventStore.addOrUpdateEvent(EVENT_3);
        eventStore.addOrUpdateEvent(EVENT_4);

        eventStore.deleteEventById(2);

        Map<Integer, StreamEvent> eventsGroupById = eventStore.getDeepCopyOfAllEventsGroupById();
        assertEquals(3, eventsGroupById.size());
        assertEquals(EVENT_1, eventsGroupById.get(1));
        assertEquals(EVENT_3, eventsGroupById.get(3));
        assertEquals(EVENT_4, eventsGroupById.get(4));

        Map<String, List<StreamEvent>> eventsGroupByType = eventStore.getDeepCopyOfAllEventsGroupByType();
        assertEquals(1, eventsGroupByType.size());
        List<StreamEvent> eventsCreated = eventsGroupByType.get(USER_CREATED_TYPE);
        assertEquals(3, eventsCreated.size());
        assertTrue(eventsCreated.contains(EVENT_1));
        assertTrue(eventsCreated.contains(EVENT_3));
        assertTrue(eventsCreated.contains(EVENT_4));
    }

    @Test
    void testPrintAllEvents() {
        System.setOut(new PrintStream(outContent));
        outContent.reset();
        EventStore eventStore = new EventStore();

        eventStore.addOrUpdateEvent(EVENT_1);
        eventStore.addOrUpdateEvent(EVENT_2);
        eventStore.addOrUpdateEvent(EVENT_3);
        eventStore.addOrUpdateEvent(EVENT_4);

        eventStore.printAllEvents();

        assertEquals(ALL_EVENTS_INFO, outContent.toString());
        System.setOut(originalOut);
    }
}