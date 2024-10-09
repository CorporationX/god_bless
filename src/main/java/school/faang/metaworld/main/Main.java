package school.faang.metaworld.main;

import school.faang.metaworld.maincode.Notification;
import school.faang.metaworld.maincode.NotificationManager;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("email", (notification) ->
                System.out.println("отправка по электронной почте: " + notification.getMessage()));

        notificationManager.registerHandler("sms", (notification) ->
                System.out.println("отправка по SMS: " + notification.getMessage()));

        notificationManager.registerHandler("push", (notification) ->
                System.out.println("отправка push-уведомления: " + notification.getMessage()));

        Notification emailNotification =
                new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification =
                new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification =
                new Notification("push", "Новый пост от пользователя: JohnDoe");
        Notification anotherNotification =
                new Notification("another", "Новый пост от пользователя: Gadzhi");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
        notificationManager.sendNotification(anotherNotification);
    }
}
