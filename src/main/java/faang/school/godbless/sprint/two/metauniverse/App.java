package faang.school.godbless.sprint.two.metauniverse;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class App {
    public static void main(String... args) {
        NotificationManager notificationManager = new NotificationManager();
        notificationManager.registeredFilters(
                (notificationMessage) -> Arrays.stream(Constants.BAD_WORDS)
                        .anyMatch(notificationMessage.toLowerCase()::contains),
                List.of("email", "push")
        );

        // Регистрация обработчиков оповещений
        notificationManager.registerHandler("email",
                (notification) -> System.out.println("Send via email: " + notification.getMessage())
        );
        notificationManager.registerHandler("sms", (notification) ->
                System.out.println("Send SMS: " + notification.getMessage())
        );
        notificationManager.registerHandler("push",
                (notification) -> System.out.println("Send push-notification: " + notification.getMessage())
        );

        // Отправка оповещений
        Notification emailNotification = new Notification("email", "Your account Bastard was successfully activated");
        Notification smsNotification = new Notification("sms", "Your password fuck was successfully changed");
        Notification pushNotification = new Notification("push", "New post from: JohnDoe");
        Notification telegramNotification = new Notification("telegram", "New message from Vasia");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
        notificationManager.sendNotification(telegramNotification);
    }
}
