package school.faang.task_46877;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        Map<String, Consumer<Notification>> handlers = new HashMap<>();
        handlers.put("email", Main::printSendEmail);
        handlers.put("sms", Main::printSendSms);
        handlers.put("push", Main::printPushSend);

        handlers.forEach(notificationManager::registerHandler);


        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");

        List<Notification> notifications = Arrays.asList(emailNotification, smsNotification, pushNotification);

        notifications.forEach(notificationManager::sendNotification);
    }

    private static void printPushSend(Notification notification) {
        System.out.println("Отправка push-уведомления: " + notification.getMessage());
    }

    private static void printSendSms(Notification notification) {
        System.out.println("Отправка SMS: " + notification.getMessage());
    }

    private static void printSendEmail(Notification notification) {
        System.out.println("Отправка по электронной почте: " + notification.getMessage());
    }
}
