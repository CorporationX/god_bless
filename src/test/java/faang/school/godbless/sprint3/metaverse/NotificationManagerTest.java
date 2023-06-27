package faang.school.godbless.sprint3.metaverse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NotificationManagerTest {
    private NotificationManager notificationManager;

    @BeforeEach
    public void initializeTests() {
        notificationManager = new NotificationManager();

        notificationManager.registerHandler(NotificationType.EMAIL, (notification) -> "Sending an email: " + notification.getMessage());
        notificationManager.registerHandler(NotificationType.TEXT, (notification) -> "Sending a text: " + notification.getMessage());
        notificationManager.registerHandler(NotificationType.PUSH, (notification) -> "Sending a push notification: " + notification.getMessage());
    }
    @Test
    public void sendEmail() {
        Notification emailNotification = new Notification(NotificationType.EMAIL, "Your account has been confirmed");
        assertEquals("Sending an email: Your account has been confirmed", notificationManager.sendNotification(emailNotification));
    }

    @Test
    public void sendSms() {
        Notification smsNotification = new Notification(NotificationType.TEXT, "Password successfully updated");
        assertEquals("Sending a text: Password successfully updated", notificationManager.sendNotification(smsNotification));
    }

    @Test
    public void sendPush() {
        Notification pushNotification = new Notification(NotificationType.PUSH, "New message from user JohnDoe");
        assertEquals("Sending a push notification: New message from user JohnDoe",
                notificationManager.sendNotification(pushNotification));
    }
}
