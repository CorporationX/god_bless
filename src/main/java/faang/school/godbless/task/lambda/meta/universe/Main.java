package faang.school.godbless.task.lambda.meta.universe;

import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String... args) {
        var notificationManager = new NotificationManager(new HashMap<>(), new HashMap<>());

        // Registration of notification handlers
        notificationManager.registerHandler("email", notification -> System.out.println("Отправка по электронной почте: " + notification.getMassage()));
        notificationManager.registerHandler("sms", notification -> System.out.println("Отправка SMS: " + notification.getMassage()));
        notificationManager.registerHandler("push", notification -> System.out.println("Отправка push-уведомления: " + notification.getMassage()));

        // Registration of notification filters
        List<String> banWords = List.of("kiwi", "apple");
        notificationManager.registerNotificationFilter(
                notification -> {
                    return banWords.stream().anyMatch(banWord ->
                            notification.getMassage().contains(banWord));
                },
                notification -> {
                    banWords.forEach(banWord -> {
                        notification.setMassage(notification.getMassage()
                                .replaceAll(banWord, "*".repeat(banWord.length())));
                    });
                    return notification;
                }
        );

        // Create notification
        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");

        // Notification with ban word
        Notification banWordNotification = new Notification("email", "kiwi better than apple!");

        // Send notification
        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
        notificationManager.sendNotification(banWordNotification);
    }
}
