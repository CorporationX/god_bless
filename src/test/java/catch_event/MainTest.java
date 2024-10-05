package catch_event;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {
    @Test
    void addNewEvent() {
        Main.addNewEvent(new StreamEvent(999, "user.login", "Kate"));

        assertEquals(1, Main.STREAM_EVENTS.size());

        Main.removeEventByID(999);
    }

    @Test
    void searchEventByID() {
        Main.addNewEvent(new StreamEvent(888, "user.logout", "Jane"));

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Main.searchEventByID(888);

        assertEquals(
                "StreamEvent(id=888, eventType=user.logout, data=Jane)\n",
                outContent.toString()
        );

        System.setOut(originalOut);

        Main.removeEventByID(888);
    }

    @Test
    void searchEventsByType() {
        Main.addNewEvent(new StreamEvent(777, "user.init", "Jane"));

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Main.searchEventsByType("user.init");

        assertEquals(
                "[StreamEvent(id=777, eventType=user.init, data=Jane)]\n",
                outContent.toString()
        );

        System.setOut(originalOut);

        Main.removeEventByID(777);
    }

    @Test
    void removeEventByID() {
        Main.addNewEvent(new StreamEvent(666, "user.created", "John"));
        Main.removeEventByID(666);

        assertEquals(0, Main.STREAM_EVENTS.size());

        assertEquals(0, Main.STREAM_EVENTS.size());
    }

    @Test
    void printAllInfo() {
        Main.addNewEvent(new StreamEvent(33, "user.created", "John"));
        Main.addNewEvent(new StreamEvent(44, "user.login", "Kate"));

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Main.printAllInfo();

        assertEquals(
                "ID: 33, type: user.created, data: John\n" +
                        "ID: 44, type: user.login, data: Kate\n",
                outContent.toString()
        );

        System.setOut(originalOut);

        Main.removeEventByID(33);
        Main.removeEventByID(44);
    }
}