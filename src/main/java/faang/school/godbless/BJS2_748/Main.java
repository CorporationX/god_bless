package faang.school.godbless.BJS2_748;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        // Регистрация обработчиков оповещений
        notificationManager.registerHandler("email", notification -> System.out.println("Отправка по электронной почте: " + notification.getMessage()));
        notificationManager.registerHandler("sms", notification -> System.out.println("Отправка SMS: " + notification.getMessage()));
        notificationManager.registerHandler("push", notification -> System.out.println("Отправка push-уведомления: " + notification.getMessage()));

        //if message contains any bad word of list
        notificationManager.censoredWords("sms", List.of("дурак", "идиот"));
        notificationManager.censoredHandler("sms", (badWord, notification) -> {
            if (notification.getMessage().contains(badWord)) {
                return new Notification(notification.getType(), "Сообщение удалено!");
            }
            return notification;
        });

        // Отправка оповещений
        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль, дурак");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");
        Notification callNotification = new Notification("call", "Входящий вызов от пользователя: Vlad Mishustin");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
        notificationManager.sendNotification(callNotification);
    }
}