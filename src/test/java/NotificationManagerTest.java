import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.task57706.service.Notification;
import school.faang.task57706.service.NotificationManager;
import school.faang.task57706.service.NotificationType;

import static org.assertj.core.api.Assertions.*;

public class NotificationManagerTest {

    private NotificationManager notificationManager;

    @BeforeEach
    void setUp() {
        notificationManager = new NotificationManager();
    }

    @Test
    void testRegisterHandler() {
        notificationManager.registerHandler(NotificationType.EMAIL,
                notification -> System.out.println("Тест: " + notification.getMessage()));
    }

    @Test
    void testSendNotification() {
        notificationManager.registerHandler(NotificationType.SMS,
                notification -> System.out.println("Тест: " + notification.getMessage()));

        Notification testNotification = new Notification(NotificationType.SMS, "Тестовое сообщение");

        assertThatCode(() -> notificationManager.sendNotification(testNotification))
                .doesNotThrowAnyException();
    }

    @Test
    void testSendNotificationWithoutHandler() {
        Notification testNotification = new Notification(NotificationType.PUSH, "Тестовое сообщение");

        assertThatCode(() -> notificationManager.sendNotification(testNotification))
                .doesNotThrowAnyException();
    }
}