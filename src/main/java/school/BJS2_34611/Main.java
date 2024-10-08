package school.BJS2_34611;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    static final Set<String> set = new HashSet<>(Set.of("email","sms","push"));

    public static void main(String[] args) {

        NotificationManager notificationManager = new NotificationManager();

// Регистрация обработчиков оповещений
        notificationManager.registerHandler("email",
                (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage())
        );

        notificationManager.registerHandler("sms",
                (notification) -> System.out.println("Отправка SMS: " + notification.getMessage())
        );

        notificationManager.registerHandler("push",
                (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage())
        );

        notificationManager.registerHandler2(set, (notification) -> {
            List<String> contains18Plus = new ArrayList<>(Arrays.asList(notification.getMessage().split(" ")));
        return contains18Plus.contains("18+");});

// Отправка оповещений
        Notification emailNotification = new Notification("email", "18+ контент. Что-то на некультурном");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");

        notificationManager.sendNotification(set,emailNotification);
        notificationManager.sendNotification(set,smsNotification);
        notificationManager.sendNotification(set,pushNotification);





    }
}
