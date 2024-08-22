package faang.school.godbless.event;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MainTest {

    @Test
    void testAddEvent() {
        StreamEvent event5 = new StreamEvent(5, EventType.CREATE, "User3 create order");
        Main.addEvent(event5);

        Assertions.assertEquals(Main.idEventMap.get(5), event5);
        Assertions.assertTrue(Main.typeEventsMap.get(event5.getEventType()).contains(event5));
    }

    @Test
    void testFindEvent() {
        StreamEvent event6 = new StreamEvent(6, EventType.CREATE, "User6 create order");
        Main.addEvent(event6);

        Assertions.assertEquals(Main.findEvent(6), event6);
    }

    @Test
    void testFindEventList() {
        StreamEvent event1 = new StreamEvent(1, EventType.CREATE, "User1 created a post");
        Main.addEvent(event1);
        StreamEvent event2 = new StreamEvent(2, EventType.UPDATE, "User1 updated a post");
        Main.addEvent(event2);
        StreamEvent event3 = new StreamEvent(3, EventType.UPDATE, "User2 created a post");
        Main.addEvent(event3);
        Main.addEvent(new StreamEvent(4, EventType.DELETE, "User1 deleted a post"));

        List<StreamEvent> eventList = Main.findEventList(EventType.UPDATE);
        Assertions.assertEquals(2, eventList.size());
        Assertions.assertTrue(eventList.containsAll(List.of(event2, event3)));
    }

    @Test
    void testDeleteEvent() {
        StreamEvent event1 = new StreamEvent(1, EventType.CREATE, "User1 created a post");
        Main.addEvent(event1);

        Assertions.assertEquals(Main.findEvent(1), event1);
        Main.deleteEvent(1);

        Assertions.assertNull(Main.idEventMap.get(1));
        Assertions.assertTrue(Main.typeEventsMap.get(EventType.CREATE).isEmpty());
    }
}
