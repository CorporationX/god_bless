package faang.school.godbless.metaverse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.function.Function;

public class NotificationManagerTest {
    private NotificationManager notificationManager;
    private Function<Notification, Notification> markImportantNotification;
    private Function<Notification, Notification> markNotImportantNotification;
    private Notification emailNotification;
    private Notification smsNotification;
    private Notification pushNotification;

    @BeforeEach
    public void setUp() {
        notificationManager = new NotificationManager();
        markImportantNotification = (notification) -> new Notification(notification.getType(), "ВАЖНО!: " + notification.getMessage());
        markNotImportantNotification = (notification) -> new Notification(notification.getType(), "НЕ ВАЖНО!: " + notification.getMessage());
        emailNotification = new Notification("email", "Пройдите стажировку");
        smsNotification = new Notification("sms", "Пакет услуг активирован");
        pushNotification = new Notification("push", "Новый пост от пользователя: Ivan Petrov");
    }

    @Test
    public void testMarkNotification() {
        assertEquals("ВАЖНО!: Пройдите стажировку", notificationManager.markNotification(emailNotification, markImportantNotification).getMessage());
        assertEquals("НЕ ВАЖНО!: Пакет услуг активирован", notificationManager.markNotification(smsNotification, markNotImportantNotification).getMessage());
        assertEquals("Новый пост от пользователя: Ivan Petrov", pushNotification.getMessage());
    }
}
