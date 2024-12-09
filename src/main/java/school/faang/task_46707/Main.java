package school.faang.task_46707;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        var bannerWords = List.of("badWord1", "badWord2");

        notificationManager.registerHandler("email",
            (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage())
        );
        notificationManager.registerHandler("sms",
            (notification) -> System.out.println("Отправка SMS: " + notification.getMessage())
        );
        notificationManager.registerHandler("push",
            (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage())
        );

        notificationManager.registerFilter("push",
            (notification) -> {
                for (String word : bannerWords) {
                    if (notification.getMessage().contains(word)) {
                        return true;
                    }
                }
                return false;
            });

        Notification emailRegisterNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsPassNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushPostNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");
        Notification pushBadWordNotification = new Notification("push", "Сообщение содержит badWord1");


        notificationManager.sendNotification(emailRegisterNotification);
        notificationManager.sendNotification(smsPassNotification);
        notificationManager.sendNotification(pushPostNotification);
        notificationManager.sendNotification(pushBadWordNotification);
    }
}
