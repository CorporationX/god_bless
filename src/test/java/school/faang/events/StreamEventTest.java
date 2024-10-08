package school.faang.events;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static school.faang.events.Main.addEvent;
import static school.faang.events.Main.eventMap;
import static school.faang.events.Main.eventsByType;
import static school.faang.events.Main.getEventById;
import static school.faang.events.Main.getEventListByType;
import static school.faang.events.Main.removeEvent;

public class StreamEventTest {
    @BeforeEach
    public void setUp() {
        eventMap = new HashMap<>();
        eventsByType = new HashMap<>();
    }

    @Test
    public void testAddEvent() {
        StreamEvent event = new StreamEvent(1, "type1", "Event 1");

        addEvent(event);

        assertEquals(1, eventMap.size());
        assertEquals(event, eventMap.get(1));
        assertEquals(1, eventsByType.size());
        assertEquals(1, eventsByType.get("type1").size());
        assertEquals(event, eventsByType.get("type1").get(0));
    }

    @Test
    public void testRemoveEvent() {
//        2 events have the same id
        StreamEvent event1 = new StreamEvent(1, "type1", "Event 1");
        StreamEvent event2 = new StreamEvent(2, "type2", "Event 2");
        StreamEvent event3 = new StreamEvent(3, "type1", "Event 3");
        StreamEvent event4 = new StreamEvent(3, "type1", "Event 4");

        addEvent(event1);
        addEvent(event3);
        addEvent(event2);
        addEvent(event4);

//        remove objects with the same id
        removeEvent(3);

        assertEquals(2, eventMap.size());
        assertNull(eventMap.get(3));
        assertEquals(2, eventsByType.size());
        assertEquals(1, eventsByType.get("type1").size());
        assertEquals(1, eventsByType.get("type1").get(0).getId());

        removeEvent(1);
        assertEquals(1, eventsByType.size());
        assertNull(eventsByType.get("type1"));

        removeEvent(8);
        assertEquals(1, eventsByType.size());
    }

    @Test
    public void testGetEventById() {
        StreamEvent event1 = new StreamEvent(1, "type1", "Event 1");
        StreamEvent event2 = new StreamEvent(2, "type2", "Event 2");
        eventMap.put(1, event1);
        eventMap.put(2, event2);

        assertEquals(event2, getEventById(2));
    }

    @Test
    public void testGetEventListByType() {
        StreamEvent event1 = new StreamEvent(1, "type1", "Event 1");
        StreamEvent event2 = new StreamEvent(2, "type2", "Event 2");
        StreamEvent event3 = new StreamEvent(3, "type1", "Event 3");
        addEvent(event1);
        addEvent(event3);
        addEvent(event2);

        List<StreamEvent> expectedEvenList = List.of(event1, event3);

        assertEquals(expectedEvenList, getEventListByType("type1"));
        assertNull(getEventListByType("typeNotFound"));
    }
}
