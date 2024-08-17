package faang.school.godbless.lambda.metauniverse;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NotificationManagerTest {

    private static final String EMAIL = "email";
    private static final String SMS = "sms";
    private static final String PUSH = "push";
    private static final String ALL_NOTIFICATIONS_OUTPUT = """
            Отправка по электронной почте: Notification(id=email, message=Ваша учетная запись успешно активирована)\r
            Отправка SMS: Notification(id=sms, message=Вы успешно изменили свой пароль)\r
            Отправка push-уведомления: Notification(id=push, message=Новый пост от пользователя: JohnDoe)\r
            """;

    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;

    private NotificationManager notificationManager;

    @Test
    void testSendNotification() {
        System.setOut(new PrintStream(outContent));
        outContent.reset();
        notificationManager = new NotificationManager();

        notificationManager.registerHandler(EMAIL, (notification) -> System.out.println("Отправка по электронной почте: " + notification));
        notificationManager.registerHandler(SMS, (notification) -> System.out.println("Отправка SMS: " + notification));
        notificationManager.registerHandler(PUSH, (notification) -> System.out.println("Отправка push-уведомления: " + notification));

        Notification emailNotification = new Notification(EMAIL, "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification(SMS, "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification(PUSH, "Новый пост от пользователя: JohnDoe");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);

        assertEquals(ALL_NOTIFICATIONS_OUTPUT, outContent.toString());
        System.setOut(originalOut);
    }

    @Test
    void testSendNotification_NoHandler() {
        System.setOut(new PrintStream(outContent));
        outContent.reset();
        notificationManager = new NotificationManager();

        Notification emailNotification = new Notification(EMAIL, "Ваша учетная запись успешно активирована");

        notificationManager.sendNotification(emailNotification);

        assertEquals(NotificationManager.NO_HANDLER_OUTPUT + EMAIL + "\r\n", outContent.toString());
        System.setOut(originalOut);
    }
}