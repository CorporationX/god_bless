package faang.school.godbless.BJS2_21954;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<String> badWords = List.of("cat", "dog", "mouse");
        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");
        Notification notificationWithSwear = new Notification("email", "I have a bad dog and cat");
        Predicate<Notification> hasSwearWords = (notification) -> {
            return badWords.stream().anyMatch(word -> notification.getMessage().contains(word));
        };
        Function<Notification, Notification> replaceSwearWord = (notification) -> {
          badWords.forEach(word -> notification.setMessage(notification.getMessage().replaceAll(word, "*".repeat(word.length()))));
          return notification;
        };

        NotificationManager.registerHandler("email", (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage()));
        NotificationManager.registerHandler("sms", (notification) -> System.out.println("Отправка SMS: " + notification.getMessage()));
        NotificationManager.registerHandler("push", (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage()));
        NotificationManager.registerFilter(hasSwearWords, replaceSwearWord);

        NotificationManager.sendNotification(emailNotification);
        NotificationManager.sendNotification(smsNotification);
        NotificationManager.sendNotification(pushNotification);
        NotificationManager.sendNotification(notificationWithSwear);
    }
}
