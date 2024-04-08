package faang.school.godbless.lambdas.task_2;

import faang.school.godbless.lambdas.task_2.model.Notification;
import faang.school.godbless.lambdas.task_2.util.NotificationManager;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        notificationManager.registerHandler("email", (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage()));
        notificationManager.registerHandler("sms", (notification) -> System.out.println("Отправка SMS: " + notification.getMessage()));
        notificationManager.registerHandler("push", (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage()));
        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");
        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
