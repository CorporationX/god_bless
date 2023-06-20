package faang.school.godbless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.function.Consumer;
import java.util.function.Predicate;


public class Application {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        // Регистрация обработчиков оповещений
        notificationManager.registerHandler("email", (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage()));
        notificationManager.registerHandler("sms", (notification) -> System.out.println("Отправка SMS: " + notification.getMessage()));
        notificationManager.registerHandler("push", (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage()));

        // Регистрация фильтров содержания оповещений
        notificationManager.registerContentFilter("email", (notification) -> !notification.getMessage().contains("спам"));
        notificationManager.registerContentFilter("sms", (notification) -> notification.getMessage().length() <= 30);
        notificationManager.registerContentFilter("push", (notification) -> notification.getMessage().length() <= 20);

        // Отправка оповещений
        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована спам");
        Notification spamEmailNotification = new Notification("email", "Получите миллионы долларов!");
        Notification longSMSNotification = new Notification("sms", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec vel nisl vel est mattis dignissim.");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(spamEmailNotification);
        notificationManager.sendNotification(longSMSNotification);



    }
}
