package school.faang.metauniverse;

import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("email", notification -> System.out.println("Отправка по " +
                "электронной почте: " + notification.getMessage())
        );

        notificationManager.registerHandler("sms", notification -> System.out.println("Отправка SMS: " +
                notification.getMessage())
        );

        notificationManager.registerHandler("push", notification -> System.out.println("Отправка " +
                "push-уведомления: " + notification.getMessage())
        );

        Notification emailNotification = new Notification("email", "Ваша учетная " +
                "запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы fuck успешно изменили " +
                "свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от " +
                "пользователя: JohnDoe");


        Predicate<String> filter = message -> message.contains("fuck");
        Function<String, String> corrector = message -> message.replace("fuck", "хороший человек и");

        notificationManager.sendFilteredNotification(emailNotification, filter, corrector);
        notificationManager.sendFilteredNotification(smsNotification, filter, corrector);
        notificationManager.sendFilteredNotification(pushNotification, filter, corrector);

    }
}
