package faang.school.godbless.lambda.metaUniverse;

public class CheckNotificationManager {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        // Регистрация обработчиков оповещений
        notificationManager.registerHandler("email", (notification) ->
                System.out.println("Отправка по электронной почте: " + notification.getMessage()));
        notificationManager.registerHandler("sms", (notification) ->
                System.out.println("Отправка SMS: " + notification.getMessage()));
        notificationManager.registerHandler("push", (notification) ->
                System.out.println("Отправка push-уведомления: " + notification.getMessage()));

        // Отправка оповещений
        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);

        // Регистрация обработчиков оповещений с приоритетом
        notificationManager.registerHandlerPriority("email", (notification -> {
            System.out.println("Отправка по электронной почте: " + notification.getMessage());

            int maxPriority = 100;
            int minPriority = 1;
            int defaultPriority = 50;
            if (notification.getMessage().startsWith("Ошибка"))
                return maxPriority;
            else if (notification.getMessage().startsWith("TODO"))
                return defaultPriority;
            else
                return minPriority;
        }));

        notificationManager.registerHandlerPriority("sms", (notification -> {
            System.out.println("Отправка SMS: " + notification.getMessage());

            int maxPriority = 10;
            int minPriority = 1;
            int defaultPriority = 5;
            if (notification.getMessage().startsWith("Здравствуйте"))
                return maxPriority;
            else if (notification.getMessage().startsWith("Привет"))
                return defaultPriority;
            else
                return minPriority;
        }));

        // Отправка оповещений
        Notification emailNotificationPriority = new Notification("email", "TODO: Решить задачу Meta-вселенная");
        Notification smsNotificationPriority = new Notification("sms",
                "Здравствуйте, хотим предложить Вам офер в нашу компанию!");

        int priorityEmail = notificationManager.sendNotificationPriority(emailNotificationPriority);
        int prioritySms = notificationManager.sendNotificationPriority(smsNotificationPriority);

        System.out.println("Приоритет email-сообщения: " + priorityEmail);
        System.out.println("Приоритет sms-сообщения: " + prioritySms);
    }
}
