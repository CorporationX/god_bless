package faang.school.godbless.BJS2_21979;

import java.util.Arrays;
import java.util.Set;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<String, String> censorship = (word) -> {
            int length = word.length();
            if (length <= 5) {
                return "*".repeat(length);
            }

            return word.substring(0, 3) + "*".repeat(length - 3);
        };
        CensorshipManager censorshipManager = new CensorshipManager(censorship, Set.of("debil", "1C", "kakashka"));

        NotificationManager notificationManager = new NotificationManager();
        notificationManager.registerHandler("email", (notification) ->
                System.out.println("Отправка по электронной почте: " + notification.getMessage()));
        notificationManager.sendNotificationIfValid(
                new Notification("email", "Ваша учетная запись успешно активирована", censorshipManager)
        );

        notificationManager.registerValidator((words) -> Arrays.stream(words).allMatch(word -> word.length() <= 25));
        notificationManager.registerHandler(
                "sms", (notification) -> System.out.println("Отправка SMS: " + notification.getMessage())
        );
        notificationManager.sendNotificationIfValid(
                new Notification("sms", "Вы успешно изменили свой пароль!!!!!!!!!!!!!!", censorshipManager)
        );

        notificationManager.registerHandler("push", (notification) ->
                System.out.println("Отправка push-уведомления: " + notification.getMessage()));
        notificationManager.sendNotificationIfValid(
                new Notification("push", "Новый пост от пользователя: DEBIL", censorshipManager)
        );
        notificationManager.sendNotificationIfValid(
                new Notification("push", "Новый пост от пользователя: kakashka", censorshipManager)
        );
    }
}
