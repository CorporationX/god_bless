package faang.school.godbless.events;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StreamEventTest {
    @BeforeAll
    static void setUp(){
        Main.addEvent(new StreamEvent(1, "LOGIN", "User A logged in"));
        Main.addEvent(new StreamEvent(2, "LOGOUT", "User B logged out"));
        Main.addEvent(new StreamEvent(3, "LOGIN", "User C logged in"));
        Main.addEvent(new StreamEvent(4, "LOGOUT", "User A logged out"));
    }

    @Test
    void additionTest(){


        assertEquals(4, Main.eventsById.size());
    }

    @Test
    void getEventByIdTest(){
        assertEquals(new StreamEvent(3, "LOGIN", "User C logged in") ,Main.getEventById(3));
    }

    @Test
    void getEventsByTypeTest(){
        System.out.println(Main.getEventsByType("LOGIN"));
        assertEquals(2, Main.getEventsByType("LOGIN").size());
    }

    @Test
    void removeEventTest(){
        Main.removeEvent(1);
        assertEquals(3, Main.eventsById.size());
        Main.printAllEvents();
    }

    @Test
    void eventsEqualityTest(){
        StreamEvent testEvent = new StreamEvent(4, "LOGIN", "User B logged in");
        assertTrue(testEvent.equals(Main.getEventById(4)));
    }


}