package school.faang.task_46608;

import java.util.List;

public class Main {
    private static NotificationManager notificationManager;

    public static void main(String[] args) {
        notificationManager = new NotificationManager();

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

        // Отправка оповещений
        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");

        sendNotification(emailNotification);
        sendNotification(smsNotification);
        sendNotification(pushNotification);


        notificationManager.addFilter("bad_words",
                (notification) -> {
                    notification.setMessage(notification.getMessage()
                            .replace("bad_word", "*oops*")
                            .replace("bad_word2", "*oops*"));
                    return notification;
                }
        );
        notificationManager.addFilter("special_characters",
                (notification -> {
                    notification.setMessage(notification.getMessage()
                            .replace("!!!!!", "!")
                            .replace("?????", "?"));
                    return notification;
                }));

        List<Notification> notifications = createNotifications();
        for (Notification notification : notifications) {
            filterAndSendNotification("bad_words", notification);
            filterAndSendNotification("special_characters", notification);
        }
    }

    private static void sendNotification(Notification notification) {
        notificationManager.sendNotification(notification);
    }

    private static void filterAndSendNotification(String filter, Notification notification) {
        notificationManager.filterNotification(filter, notification);
    }

    private static List<Notification> createNotifications() {
        return List.of(
                new Notification("email", "Здесь будет bad_word"),
                new Notification("sms", "Слишком много !!!!!")
        );
    }
}
