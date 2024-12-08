package school.faang.task_46608;

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

        // Отправка оповещений
        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);


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

        Notification notificationWithBadWord = new Notification("email", "Здесь будет bad_word");
        Notification filteredNotification =
                notificationManager.filterNotification("bad_words", notificationWithBadWord);
        notificationManager.sendNotification(filteredNotification);

        Notification notificationWithSpecialCharacters = new Notification("sms", "Слишком много !!!!!");
        Notification filteredNotificationSecond =
                notificationManager.filterNotification("special_characters", notificationWithSpecialCharacters);
        notificationManager.sendNotification(filteredNotificationSecond);
    }
}
