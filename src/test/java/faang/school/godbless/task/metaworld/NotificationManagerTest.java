package faang.school.godbless.task.metaworld;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class NotificationManagerTest {

    @Test
    void sendNotification_throwNoSuchElementException() {
        NotificationManager notificationManager = new NotificationManager();
        notificationManager.registerHandler("email", (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage()));
        Notification emailNotification = new Notification("push", "Ваша учетная запись успешно активирована");

        var exception = assertThrows(NoSuchElementException.class, () -> notificationManager.sendNotification(emailNotification));
        assertEquals(exception.getMessage(), "Have no notification type: push");
    }
}