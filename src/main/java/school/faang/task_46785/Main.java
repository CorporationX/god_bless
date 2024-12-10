package school.faang.task_46785;

import java.util.function.Function;

public class Main {
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

        Function<Notification, Notification> modifier = n -> {
            String newMessage = n.getMessage().replace("плохой", "самый лучший");
            n.setMessage(newMessage);
            return n;
        };


        // Отправка оповещений
        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");
        Notification noNameNotification = new Notification("noName", "Новый пост от пользователя: JohnDoe");
        Notification modifierNotification = new Notification("push", "Java плохой язык!!!");

        notificationManager.sendNotification(emailNotification, modifier);
        notificationManager.sendNotification(smsNotification, modifier);
        notificationManager.sendNotification(pushNotification, modifier);
        notificationManager.sendNotification(noNameNotification, modifier);
        notificationManager.sendNotification(modifierNotification, modifier);
    }
}
