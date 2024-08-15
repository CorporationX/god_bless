package faang.school.godbless.MetaUniverse;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        final List<String> restrictedTypes = new ArrayList<>();
        restrictedTypes.add("pop");
        Predicate<String> checkBannedWords = word -> !restrictedTypes.contains(word);


        notificationManager.registerHandler("email", (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage()), checkBannedWords);
        notificationManager.registerHandler("sms", (notification) -> System.out.println("Отправка SMS: " + notification.getMessage()), checkBannedWords);
        notificationManager.registerHandler("push", (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage()), checkBannedWords);
        notificationManager.registerHandler("pop", (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage()), checkBannedWords);


        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");
        Notification telegramNotification = new Notification("telegram", "Новый пост от пользователя: JohnDoe");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
        notificationManager.sendNotification(telegramNotification);
    }
}
