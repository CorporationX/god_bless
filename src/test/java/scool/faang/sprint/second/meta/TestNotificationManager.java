package scool.faang.sprint.second.meta;

import org.junit.Test;
import org.mockito.Mockito;
import school.faang.sprint.second.meta.Notification;
import school.faang.sprint.second.meta.NotificationManager;
import school.faang.sprint.second.meta.NotificationType;

import java.util.function.Consumer;

public class TestNotificationManager {
    private final NotificationManager notificationManager = Mockito.spy(NotificationManager.class);

    @Test
    public void testRegisterHandler() {
        Consumer<Notification> consumer = (notification) -> System.out.println("Push: " + notification.getMessage());
        notificationManager.registerHandler(NotificationType.PUSH, consumer);

        Mockito.verify(notificationManager, Mockito.times(1))
                .registerHandler(NotificationType.PUSH, consumer);
    }

    @Test
    public void testSuccessSendMessage() {
        notificationManager.sendNotification(new Notification(NotificationType.PUSH, "Тестовое сообщение"));

        Mockito.verify(notificationManager, Mockito.times(1))
                .sendNotification(new Notification(NotificationType.PUSH, "Тестовое сообщение"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrowWhenSendBlankMessage() {
        notificationManager.sendNotification(new Notification(NotificationType.PUSH, ""));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrowWhenSendMessageWithDeniedWords() {
        notificationManager.sendNotification(new Notification(NotificationType.PUSH, "Кола - это очень полезно"));
    }
}
