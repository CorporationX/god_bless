package faang.school.godbless.task.event.catching;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class EventManagerTest {
    StreamEvent event1 = new StreamEvent(1, "login", "user1");
    StreamEvent event2 = new StreamEvent(2, "logout", "user2");
    StreamEvent event3 = new StreamEvent(3, "purchase", "user3");
    StreamEvent event4 = new StreamEvent(4, "login", "user4");
    StreamEvent event5 = new StreamEvent(5, "purchase", "user5");
    StreamEvent event6 = new StreamEvent(6, "logout", "user6");
    StreamEvent event7 = new StreamEvent(7, "login", "user7");
    StreamEvent event8 = new StreamEvent(8, "purchase", "user8");
    StreamEvent event9 = new StreamEvent(9, "logout", "user9");
   StreamEvent event10 = new StreamEvent(10, "login", "user10");

         EventManager eventManager;
    List<StreamEvent> eventListInCache;
    List<StreamEvent> eventListInCacheByEventType;
               String eventType;
          StreamEvent expectedStreamEvent;

    @BeforeEach
    void setUp() {
        eventManager = new EventManager(new HashMap<>(), new HashMap<>());
        eventListInCache = List.of(event1, event2, event3, event4, event5,
                                   event6, event7, event8, event9, event10);
        // add test data to cash:
        eventListInCache.forEach(event -> eventManager.addNewStreamEvent(event));

        eventType = "login";
        eventListInCacheByEventType = eventListInCache.stream()
                .filter(event -> event.eventType().equals(eventType))
                .collect(Collectors.toList());

        expectedStreamEvent = new StreamEvent(12, "T","D");
    }

    @Test
    void testAddNewStreamEvent() {
        eventManager.addNewStreamEvent(expectedStreamEvent);
        assertEquals(expectedStreamEvent, eventManager.findStreamEventById(expectedStreamEvent.id()));
    }

    @Test
    void testFindStreamEventById() {
        eventManager.addNewStreamEvent(expectedStreamEvent);
        assertEquals(expectedStreamEvent, eventManager.findStreamEventById(expectedStreamEvent.id()));
    }

    @Test
    void testFindStreamEventByEventType() {
        List<StreamEvent> actualEventList = eventManager.findStreamEventByEventType(eventType);
        assertEquals(eventListInCacheByEventType, actualEventList);
    }

    @Test
    void deleteStreamEventById() {
        eventManager.addNewStreamEvent(expectedStreamEvent);
        assertEquals(expectedStreamEvent, eventManager.findStreamEventById(expectedStreamEvent.id()));
        eventManager.deleteStreamEventById(expectedStreamEvent.id());
        assertNull(eventManager.findStreamEventById(expectedStreamEvent.id()));
    }
}
