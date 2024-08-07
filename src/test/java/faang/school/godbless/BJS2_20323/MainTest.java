package faang.school.godbless.BJS2_20323;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    Main main;

    @BeforeEach
    void init() {
        main = new Main();

        StreamEvent event1 = new StreamEvent(1, "SMS", "Списание средств: -50 р.");
        StreamEvent event2 = new StreamEvent(2, "Email", "Проверочный код: 12345.");
        StreamEvent event3 = new StreamEvent(3, "Post", "Повестка из военкомата");
        StreamEvent event4 = new StreamEvent(4, "Email", "Успешная регистрация на сервисе");
        StreamEvent event5 = new StreamEvent(5, "SMS", "Абнент 123 не в сети");
        StreamEvent event6 = new StreamEvent(6, "Post", "Письмо от приставов");

        main.getEventsById().put(event1.getId(), event1);
        main.getEventsById().put(event2.getId(), event2);
        main.getEventsById().put(event3.getId(), event3);
        main.getEventsById().put(event4.getId(), event4);
        main.getEventsById().put(event5.getId(), event5);
        main.getEventsById().put(event6.getId(), event6);

        main.getEventsByTypes().put(event1.getEventType(), new ArrayList<>(Arrays.asList(event1, event5)));
        main.getEventsByTypes().put(event2.getEventType(), new ArrayList<>(Arrays.asList(event2, event4)));
        main.getEventsByTypes().put(event3.getEventType(), new ArrayList<>(Arrays.asList(event3, event6)));
    }

    @Test
    void addStreamEventTest() {
        int eventsByIdSizeBefore = main.getEventsById().size();
        int postEventsSize = main.getStreamEventsByType("Post").size();

        StreamEvent event = new StreamEvent(7, "Post", "Газета");
        main.addStreamEvent(event);

        assertEquals(eventsByIdSizeBefore + 1, main.getEventsById().size());
        assertEquals(postEventsSize + 1, main.getStreamEventsByType("Post").size());

    }

    @Test
    void getStreamEventByIdTest() {
        StreamEvent expected = new StreamEvent(1, "SMS", "Списание средств: -50 р.");
        StreamEvent result = main.getStreamEventById(1);
        assertEquals(expected, result);
    }

    @Test
    void getStreamEventsByTypeTest() {
        StreamEvent event1 = new StreamEvent(1, "SMS", "Списание средств: -50 р.");
        StreamEvent event2 = new StreamEvent(5, "SMS", "Абнент 123 не в сети");
        List<StreamEvent> expected = List.of(event1, event2);
        List<StreamEvent> result = main.getStreamEventsByType("SMS");
        assertEquals(expected, result);
    }

    @Test
    void deleteStreamEventTest() {
        int eventsByIdSizeBefore = main.getEventsById().size();
        int postEventsSize = main.getStreamEventsByType("SMS").size();
        Integer id = 1;

        main.deleteStreamEvent(id);

        assertEquals(eventsByIdSizeBefore - 1, main.getEventsById().size());
        assertEquals(postEventsSize - 1, main.getStreamEventsByType("SMS").size());
    }

    @Test
    void testPrintEvents() {
        main.printEvents();
    }
}