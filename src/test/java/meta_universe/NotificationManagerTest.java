package meta_universe;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import the_library_of_westeros.Book;
import the_library_of_westeros.Main;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;

class NotificationManagerTest {
    Map<String, Consumer<Notification>> handlers = new HashMap<>();
    NotificationManager notificationManager = new NotificationManager(handlers);

    @BeforeEach
    void setUp() {
        notificationManager.registerHandler("email", notification -> {
            System.out.println(notification.getMessage());
        });
    }

    @AfterEach
    void tearDown() {
        handlers.clear();
    }

    @Test
    void registerHandler() {
        notificationManager.registerHandler("sms", notification -> {
            System.out.println(notification.getMessage());
        });

        assertEquals(handlers.get("sms"), notificationManager.getHANDLERS().get("sms"));
    }

    @Test
    void sendNotification() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        notificationManager.sendNotification(new Notification("email", "EMAIL: Dear user"));

        assertEquals("EMAIL: Dear user\n", outContent.toString());

        System.setOut(originalOut);
    }
}