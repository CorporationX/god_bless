package faang.school.godbless.meta;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NotificationManagerTest {

    @DisplayName("should send messages with different types")
    @Test
    void testTypeHandler() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        NotificationManager notificationManager = new NotificationManager();
        notificationManager.registerTypeHandler("email", (notification -> System.out.printf("via email: %s\n",
                notification.getMessage())));
        notificationManager.registerTypeHandler("push", (notification -> System.out.printf("as push: %s\n",
                notification.getMessage())));
        notificationManager.registerTypeHandler("sms", (notification -> System.out.printf("via sms: %s\n",
                notification.getMessage())));

        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);

        String expected = """
                via email: Ваша учетная запись успешно активирована
                via sms: Вы успешно изменили свой пароль
                as push: Новый пост от пользователя: JohnDoe
                """;
        assertEquals(expected, output.toString());
        System.setOut(null);
    }

    @DisplayName("should sanitize messages")
    @Test
    void testContentEditor() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        NotificationManager notificationManager = new NotificationManager();
        notificationManager.registerTypeHandler("sms", (notification -> System.out.printf("via sms: %s\n",
                notification.getMessage())));
        notificationManager.registerContentEditor("fuck", (message -> message.replaceAll("fuck", "f#ck")));
        notificationManager.registerContentEditor("shit", (message -> message.replaceAll("shit", "sh!t")));

        Notification swearNotification1 = new Notification("sms", "fuck that!");
        Notification swearNotification2 = new Notification("sms", "Oh, shit, shit, shit!");

        notificationManager.sendNotification(swearNotification1);
        notificationManager.sendNotification(swearNotification2);

        String expected = """
                via sms: f#ck that!
                via sms: Oh, sh!t, sh!t, sh!t!
                """;
        assertEquals(expected, output.toString());
        System.setOut(null);
    }

    @DisplayName("shouldn't send messages with prohibited content")
    @Test
    void testContentBlocker() {
        NotificationManager notificationManager = new NotificationManager();
        notificationManager.registerTypeHandler("sms", (notification -> System.out.printf("via sms: %s\n",
                notification.getMessage())));
        notificationManager.registerContentBlocker("bomb",
                (notification -> notification.getMessage().contains("bomb")));
        notificationManager.registerContentBlocker("drugs", (notification -> notification.getMessage().contains(
                "drugs")));

        Notification prohibitedNotification1 = new Notification("sms", "How to make a bomb:...");
        Notification prohibitedNotification2 = new Notification("sms", "How to get drugs:...");

        assertThrows(IllegalArgumentException.class,
                () -> notificationManager.sendNotification(prohibitedNotification1));
        assertThrows(IllegalArgumentException.class,
                () -> notificationManager.sendNotification(prohibitedNotification2));
    }
}
