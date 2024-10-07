package school.faang.bsj2_33230;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static school.faang.bsj2_33230.Main.STREAM_EVENTS_BY_ID;
import static school.faang.bsj2_33230.Main.STREAM_EVENTS_BY_TYPE;
import static school.faang.bsj2_33230.Main.addStreamEvent;
import static school.faang.bsj2_33230.Main.deleteStreamEventById;
import static school.faang.bsj2_33230.Main.id;
import static school.faang.bsj2_33230.Main.printAllStreamEvents;
import static school.faang.bsj2_33230.Main.searchStreamEventById;
import static school.faang.bsj2_33230.Main.searchStreamEventsByType;

class MainTest {

    @BeforeEach
    void setUp() {
        STREAM_EVENTS_BY_ID.clear();
        STREAM_EVENTS_BY_TYPE.clear();
        id = 0;
    }

    @Test
    void testAddStreamEvent() {
        StreamEvent newsStreamEvent = addStreamEvent("News", "BirthDay, Accident, Holiday");
        String targetEventType = newsStreamEvent.getEventType();

        assertTrue(STREAM_EVENTS_BY_ID.containsValue(newsStreamEvent));
        assertTrue(STREAM_EVENTS_BY_TYPE.get(targetEventType).contains(newsStreamEvent));
    }

    @Test
    void testSearchStreamEventById() {
        StreamEvent newsStreamEvent = addStreamEvent("News", "BirthDay, Accident, Holiday");
        StreamEvent tvStreamEvent = addStreamEvent("TV shows", "Pole Chudes, Comedy Club, Disney");
        int firstTargetId = newsStreamEvent.getId();
        int secondTargetId = tvStreamEvent.getId();

        assertEquals(newsStreamEvent, searchStreamEventById(firstTargetId));
        assertEquals(tvStreamEvent, searchStreamEventById(secondTargetId));
    }

    @Test
    void testSearchStreamEventsByType() {
        StreamEvent tvStreamEvent = addStreamEvent("TV shows", "Pole Chudes, Comedy Club, Disney");
        StreamEvent moviesStreamEvent = addStreamEvent("Movies", "Die Hard, Lord of the Rings");
        String firstTargetType = tvStreamEvent.getEventType();
        String secondTargetType = moviesStreamEvent.getEventType();

        assertTrue(searchStreamEventsByType(firstTargetType).contains(tvStreamEvent));
        assertTrue(searchStreamEventsByType(secondTargetType).contains(moviesStreamEvent));
    }

    @Test
    void testDeleteStreamEventById() {
        StreamEvent newsStreamEvent = addStreamEvent("News", "BirthDay, Accident, Holiday");
        int targetId = newsStreamEvent.getId();
        String targetEventType = newsStreamEvent.getEventType();

        assertTrue(STREAM_EVENTS_BY_ID.containsValue(newsStreamEvent));
        assertTrue(STREAM_EVENTS_BY_TYPE.get(targetEventType).contains(newsStreamEvent));

        deleteStreamEventById(targetId);

        assertFalse(STREAM_EVENTS_BY_ID.containsValue(newsStreamEvent));
        assertFalse(STREAM_EVENTS_BY_TYPE.get(targetEventType).contains(newsStreamEvent));
    }

    @Test
    void testPrintAllStreamEvents() {
        addStreamEvent("News", "BirthDay, Accident, Holiday");
        addStreamEvent("TV shows", "Pole Chudes, Comedy Club, Disney");
        addStreamEvent("Movies", "Die Hard, Lord of the Rings");
        printAllStreamEvents();
    }
}