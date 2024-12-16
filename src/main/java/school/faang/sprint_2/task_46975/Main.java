package school.faang.sprint_2.task_46975;

import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("email",
                notification -> System.out.println("Отправка по электронной почте: " + notification.message())
        );

        notificationManager.registerHandler("sms",
                notification -> System.out.println("Отправка SMS: " + notification.message())
        );

        notificationManager.registerHandler("push",
                notification -> System.out.println("Отправка push-уведомления: " + notification.message())
        );

        Notification emailNotification = new Notification("email", "Ваша учетная запись успешно активирована");
        Notification smsNotification = new Notification("sms", "Вы успешно изменили свой пароль");
        Notification pushNotification = new Notification("push", "Новый пост от пользователя: JohnDoe");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);

        Predicate<String> profanityFilter = content -> !content.toLowerCase().contains("нецензурно");

        final Notification inappropriateNotification = new Notification("sms", "Это сообщение нецензурно");

        if (ContentFilter.isContentAcceptable(inappropriateNotification, profanityFilter)) {
            notificationManager.sendNotification(inappropriateNotification);
        } else {
            System.out.println("Сообщение не отправлено: checkstyle fail");
        }
    }
}
