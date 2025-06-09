package school.faang.meta.notification;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NotificationManagerTest {
    private NotificationManager manager;

    @BeforeEach
    public void setUp() {
        manager = new NotificationManager();
    }

    @Test
    public void testRegisterHandler() {
        Consumer<Notification> emailHandler = notification -> System.out.println("Email: " + notification.getMessage());
        boolean emailRegistered = manager.registerHandler(NotificationType.EMAIL, emailHandler);
        boolean secondEmailRegistered = manager.registerHandler(NotificationType.EMAIL, emailHandler);
        assertTrue(emailRegistered);
        assertTrue(!secondEmailRegistered);
    }

    public void testSendNotification() {
        manager.registerHandler(NotificationType.EMAIL,
                notification -> System.out.println("Email: " + notification.getMessage())
        );

        manager.registerHandler(NotificationType.SMS,
                notification -> System.out.println("SMS: " + notification.getMessage())
        );

        Notification emailNotification = new Notification(NotificationType.EMAIL, "Ваш аккаунт активирован");
        Notification smsNotification = new Notification(NotificationType.SMS, "Ваш пароль изменен");
        Notification pushNotification = new Notification(NotificationType.PUSH, "У вас новое сообщение!");

        boolean emailSent = manager.sendNotification(emailNotification);
        boolean smsSent = manager.sendNotification(smsNotification);
        boolean pushSent = manager.sendNotification(pushNotification);

        assertTrue(emailSent);
        assertTrue(smsSent);
        assertTrue(!pushSent);
    }
}
