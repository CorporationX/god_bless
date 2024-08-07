package exception.catching.test;

import exceptions.catching.Main;
import exceptions.catching.StreamEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EventMapsTest {
    private Map<Integer, StreamEvent> eventsMap;
    private Map<String, List<StreamEvent>> eventsTypeLists;

    @BeforeEach
    void setUp() {
        eventsMap = new HashMap<>();
        eventsTypeLists = new HashMap<>();
    }

    @Test
    @DisplayName("Test addEvent method with valid arguments")
    void eventMapsTest_addEvent() {
        StreamEvent event1 = new StreamEvent(1, "test1", "test");
        StreamEvent event2 = new StreamEvent(2, "test1", "test");
        StreamEvent event3 = new StreamEvent(3, "test2", "test");

        Main.addEvent(eventsMap, eventsTypeLists, event1);
        Main.addEvent(eventsMap, eventsTypeLists, event2);
        Main.addEvent(eventsMap, eventsTypeLists, event3);

        assertAll(
                () -> assertEquals(3, eventsMap.size()),
                () -> assertEquals(2, eventsTypeLists.size()),
                () -> assertEquals(2, eventsTypeLists.get("test1").size())
        );
    }

    @Test
    @DisplayName("Test addEvent method with null arguments")
    void eventMapsTest_addEventWithNullArguments() {
        StreamEvent event1 = new StreamEvent(1, "test1", "test");

        assertAll(
                () -> assertThrows(
                        NullPointerException.class,
                        () -> Main.addEvent(null, eventsTypeLists, event1)),
                () -> assertThrows(
                        NullPointerException.class,
                        () -> Main.addEvent(eventsMap, null, event1)),
                () -> assertThrows(
                        NullPointerException.class,
                        () -> Main.addEvent(eventsMap, eventsTypeLists, null))
        );
    }

    @Test
    @DisplayName("Test searchEventById method with valid arguments")
    void eventMapsTest_searchById() {
        StreamEvent expected = new StreamEvent(1, "test1", "test");
        Main.addEvent(eventsMap, eventsTypeLists, expected);

        StreamEvent result = Main.searchEventById(eventsMap, expected.getId());

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test searchEventById method with id not in stream")
    void eventMapsTest_searchByIdNotInStream() {
        StreamEvent result = Main.searchEventById(eventsMap, -1);

        assertNull(result);
    }

    @Test
    @DisplayName("Test searchEventById method with null arguments")
    void eventMapsTest_searchByIdWithNullArguments() {
        assertThrows(NullPointerException.class, () -> Main.searchEventById(null, 1));
    }

    @Test
    @DisplayName("Test searchEventListByType method with valig arguments")
    void eventMapsTest_searchEventListByType() {
        StreamEvent event1 = new StreamEvent(1, "test1", "test");
        Main.addEvent(eventsMap, eventsTypeLists, event1);

        List<StreamEvent> result = Main.searchEventListByType(eventsTypeLists, "test1");

        assertAll(
                () -> assertNotNull(result),
                () -> assertTrue(result.contains(event1))
        );
    }

    @Test
    @DisplayName("Test searchEventListByType method with type not in stream")
    void eventMapsTest_searchEventListByTypeWithTypeNotInStream() {
        List<StreamEvent> result = Main.searchEventListByType(eventsTypeLists, "test1");

        assertNull(result);
    }

    @Test
    @DisplayName("Test searchEventListByType method with null arguments")
    void eventMapsTest_searchEventListByTypeWithNullArguments() {
        assertAll(
                () -> assertThrows(NullPointerException.class,
                        () -> Main.searchEventListByType(null, "test")),
                () -> assertThrows(NullPointerException.class,
                        () -> Main.searchEventListByType(eventsTypeLists, null))
        );
    }

    @Test
    @DisplayName("Test removeEvent method with valid arguments")
    void eventMapsTest_removeEvent() {
        StreamEvent event1 = new StreamEvent(1, "test1", "test");
        StreamEvent event2 = new StreamEvent(2, "test2", "test");
        Main.addEvent(eventsMap, eventsTypeLists, event1);
        Main.addEvent(eventsMap, eventsTypeLists, event2);

        Main.removeEvent(eventsMap, eventsTypeLists, 1);

        assertAll(
                () -> assertFalse(eventsMap.containsKey(event1.getId())),
                () -> assertEquals(1, eventsTypeLists.size())
        );
    }

    @Test
    @DisplayName("Test removeEvent method with event not in the stream")
    void eventMapsTest_removeEventNotInTheStream() {
        StreamEvent event1 = new StreamEvent(1, "test1", "test");
        Main.addEvent(eventsMap, eventsTypeLists, event1);

        Main.removeEvent(eventsMap, eventsTypeLists, 2);

        assertAll(
                () -> assertTrue(eventsMap.containsKey(event1.getId())),
                () -> assertEquals(1, eventsTypeLists.size())
        );
    }

    @Test
    @DisplayName("Test removeEvent method with null arguments")
    void eventMapsTest_removeEventWithNullArguments() {
        assertAll(
                () -> assertThrows(
                        NullPointerException.class,
                        () -> Main.removeEvent(null, eventsTypeLists, 1)),
                () -> assertThrows(
                        NullPointerException.class,
                        () -> Main.removeEvent(eventsMap, null, 1))
        );
    }
}
