package dima.evseenko.meta;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class NotificationManagerTest {

    @Test
    void registerHandler() {
        NotificationManager manager = new NotificationManager();
        manager.registerHandler(NotificationType.PUSH, (notification) -> System.out.println("Push notification: " + notification.getMessage()));

        assertNotNull(manager.getNotificationHandler(NotificationType.PUSH));
    }

    @Test
    void registerNullHandler() {
        NotificationManager manager = new NotificationManager();
        manager.registerHandler(NotificationType.PUSH, null);

        assertNull(manager.getNotificationHandler(NotificationType.PUSH));
    }
}