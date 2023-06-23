package faang.school.godbless.meta.notification;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NotificationManagerTest {
    private static final String EMAIL = "email";
    private static final String SMS = "sms";
    private static final String PUSH = "push";
    private static final String NOTIFICATION_BY_EMAIL = "Отправка по электронной почте: ";
    private static final String NOTIFICATION_BY_SMS = "Отправка SMS: ";
    private static final String NOTIFICATION_BY_PUSH = "Отправка push-уведомления: ";
    private static final String SUCCESS_BY_EMAIL = "Ваша учетная запись успешно активирована";
    private static final String SUCCESS_BY_SMS = "Вы успешно изменили свой пароль";
    private static final String SUCCESS_BY_PUSH = "Новый пост от пользователя: JohnDoe";
    private NotificationManager notificationManager;
    private ByteArrayOutputStream output;

    @BeforeEach
    public void setUp() {
        notificationManager = new NotificationManager();
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        notificationManager.registerHandler(EMAIL, (notification) -> System.out.println(NOTIFICATION_BY_EMAIL + notification.getMessage()));
        notificationManager.registerHandler(SMS, (notification) -> System.out.println(NOTIFICATION_BY_SMS + notification.getMessage()));
        notificationManager.registerHandler(PUSH, (notification) -> System.out.println(NOTIFICATION_BY_PUSH + notification.getMessage()));
    }

    @Test
    public void registerHandlerTest() {
        Map<String, Consumer<Notification>> mapTypeToHandler = notificationManager.getHandlersMap();

        assertEquals(3, mapTypeToHandler.size());

        assertTrue(mapTypeToHandler.containsKey(EMAIL));
        assertTrue(mapTypeToHandler.containsKey(SMS));
        assertTrue(mapTypeToHandler.containsKey(PUSH));
    }

    @Test
    public void sendNotificationTest() {
        Notification emailNotification = new Notification(EMAIL, SUCCESS_BY_EMAIL);
        assertNotification(emailNotification, NOTIFICATION_BY_EMAIL + SUCCESS_BY_EMAIL);

        Notification smsNotification = new Notification(SMS, SUCCESS_BY_SMS);
        assertNotification(smsNotification, NOTIFICATION_BY_SMS + SUCCESS_BY_SMS);

        Notification pushNotification = new Notification(PUSH, SUCCESS_BY_PUSH);
        assertNotification(pushNotification, NOTIFICATION_BY_PUSH + SUCCESS_BY_PUSH);
    }

    private void assertNotification(Notification notification, String expectedOutput) {
        notificationManager.sendNotification(notification);
        assertEquals(expectedOutput, output.toString().trim());
        output.reset();
    }
}

