package school.faang.task_46785;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        // Регистрация обработчиков оповещений
        notificationManager.registerHandler(NotificationType.EMAIL.getNonificationType(),
                (notification) -> System.out.println("Отправка по электронной почте: " + notification.getMessage())
        );

        notificationManager.registerHandler(NotificationType.SMS.getNonificationType(),
                (notification) -> System.out.println("Отправка SMS: " + notification.getMessage())
        );

        notificationManager.registerHandler(NotificationType.PUSH.getNonificationType(),
                (notification) -> System.out.println("Отправка push-уведомления: " + notification.getMessage())
        );
        notificationManager.registerHandler(null, null);

        Function<Notification, Notification> modifier = n -> {
            String newMessage = n.getMessage().replace("плохой", "самый лучший");
            n.setMessage(newMessage);
            return n;
        };


        // Отправка оповещений
        Notification emailNotification = new Notification(NotificationType.EMAIL.getNonificationType(),
                "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification(NotificationType.SMS.getNonificationType(),
                "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification(NotificationType.PUSH.getNonificationType(),
                "Новый пост от пользователя: JohnDoe");
        Notification noNameNotification = new Notification("No name",
                "Новый пост от пользователя: JohnDoe");
        Notification modifierNotification = new Notification(NotificationType.PUSH.getNonificationType(),
                "Java плохой язык!!!");

        notificationManager.sendNotification(emailNotification, modifier);
        notificationManager.sendNotification(smsNotification, modifier);
        notificationManager.sendNotification(pushNotification, modifier);
        notificationManager.sendNotification(noNameNotification, modifier);
        notificationManager.sendNotification(modifierNotification, modifier);
    }
}
