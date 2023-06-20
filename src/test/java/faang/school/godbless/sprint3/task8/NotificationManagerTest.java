package faang.school.godbless.sprint3.task8;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class NotificationManagerTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;


    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void testSendNotification() {
        NotificationManager notificationManager = new NotificationManager();
        notificationManager.registerHandler("email", (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage()));
        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        notificationManager.sendNotification(emailNotification);

        assertEquals("Отправка по электронной почте: Ваша учетная запись успешно активирована\r\n", outContent.toString());
    }

    @Test
    void testValidationRegisterHandler() {
        NotificationManager notificationManager = new NotificationManager();
        String type = null;

        assertThrows(IllegalArgumentException.class, () -> notificationManager
                .registerHandler(type, (notification) -> System.out.println(" " + notification.getMessage())));
        assertThrows(IllegalArgumentException.class, () -> notificationManager
                .registerHandler("  ", (notification) -> System.out.println(" " + notification.getMessage())));
    }

    @Test
    void testValidationSendNotification() {
        NotificationManager notificationManager = new NotificationManager();

        assertThrows(IllegalArgumentException.class, () -> notificationManager
                .sendNotification(null));
    }
}