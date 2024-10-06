package faang.school.godbless.events;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EventServiceTest {

    @Test
    void testAddInEmptyList() {
        var service = new EventService();
        var event = new StreamEvent(1, "video", "data1");

        service.addEvent(event);

        Assertions.assertAll(
                ()-> Assertions.assertEquals(event, service.findEventById(event.id())),
                ()-> Assertions.assertEquals(1, service.findEventsByType(event.type()).size()),
                ()-> Assertions.assertEquals(event, service.findEventsByType(event.type()).get(0))
        );
    }

    @Test
    void testAddInNotEmptyList() {
        var service = new EventService();
        var event1 = new StreamEvent(1, "video", "data1");
        var event2 = new StreamEvent(2, "video", "data2");

        service.addEvent(event1);
        service.addEvent(event2);

        Assertions.assertAll(
                ()-> Assertions.assertEquals(event1, service.findEventById(event1.id())),
                ()-> Assertions.assertEquals(event2, service.findEventById(event2.id())),
                ()-> Assertions.assertEquals(2, service.findEventsByType("video").size()),
                ()-> Assertions.assertEquals(event1, service.findEventsByType("video").get(0)),
                ()-> Assertions.assertEquals(event2, service.findEventsByType("video").get(1))
        );
    }

    @Test
    void testRemoveEvent() {
        var service = new EventService();
        var event1 = new StreamEvent(1, "video", "data1");
        var event2 = new StreamEvent(2, "video", "data2");

        service.addEvent(event1);
        service.addEvent(event2);
        service.removeEventById(1);

        Assertions.assertAll(
                ()-> Assertions.assertNull(service.findEventById(event1.id())),
                ()-> Assertions.assertEquals(event2, service.findEventById(event2.id())),
                ()-> Assertions.assertEquals(1, service.findEventsByType("video").size()),
                ()-> Assertions.assertEquals(event2, service.findEventsByType("video").get(0))
        );
    }

    @Test
    void testPrintEvents() {
        var service = new EventService();
        var event1 = new StreamEvent(1, "video", "data1");
        var event2 = new StreamEvent(2, "video", "data2");

        service.addEvent(event1);
        service.addEvent(event2);

        Assertions.assertDoesNotThrow(service::printEvents);
    }

}
