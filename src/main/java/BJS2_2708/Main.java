package BJS2_2708;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

// Регистрация обработчиков оповещений
        notificationManager.registerHandler("email", (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage()));
        notificationManager.registerHandler("sms", (notification) -> System.out.println("Отправка SMS: " + notification.getMessage()));
        notificationManager.registerHandler("push", (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage()));

        Notification emailNotification = new Notification("email", "ура! теперь вы подписаны на нашу рассылку");
        Notification smsNotification = new Notification("sms", "только что в ваш аккаунт был выполнен вход");
        Notification pushNotification = new Notification("push", "у вас новое сообщение");


        notificationManager.sendNotification(emailNotification);
    }
}
