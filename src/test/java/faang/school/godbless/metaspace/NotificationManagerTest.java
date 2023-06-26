package faang.school.godbless.metaspace;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;

class NotificationManagerTest {
    private NotificationManager notificationManager;
    private Consumer<Notification> handler;
    private String notificationId;

    @BeforeEach
    void setUp() {
        notificationManager = new NotificationManager();
        handler = System.out::println;
        notificationId = "sms";
    }

    @Test
    void shouldThrowException() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class,
                        () -> notificationManager.registerHandler("", handler)),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> notificationManager.registerHandler(null, handler)),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> notificationManager.registerHandler("sms", null))
        );
    }

    @Test
    void testRegisterHandler() {
        Map<String, Consumer<Notification>> expectedMap = Map.of(notificationId, handler);
        notificationManager.registerHandler(notificationId, handler);
        assertEquals(expectedMap, notificationManager.getNotificationHandler());
    }

    @Test
    void testSendNotification() {
        assertDoesNotThrow(() -> notificationManager.sendNotification(null));
    }
}