package school.faang.bjs2_70565;

import java.util.function.Predicate;

public class Main {

    private static final NotificationManager manager = new NotificationManager();
    private static final String EMAIL_FOOTER = "(Окончание текста письма)";
    private static final String SMS_FOOTER = "(окончание sms)";
    private static final String PUSH_FOOTER = "@push message@";

    private static void registerHandlers() {
        Predicate<Notification> filter =
            notification -> !notification.getMessage().contains("нецензурность");

        NotificationHandlers<Notification> emailHandlers = new NotificationHandlers<>(
            notification -> System.out.printf("email: %s\n", notification.getMessage()),
            filter,
            notification -> "%s / %s".formatted(notification.getMessage(), EMAIL_FOOTER)
        );

        NotificationHandlers<Notification> smsHandlers = new NotificationHandlers<>(
            notification -> System.out.printf("sms: %s\n", notification.getMessage()),
            filter,
            notification -> "%s / %s".formatted(notification.getMessage(), SMS_FOOTER)
        );

        NotificationHandlers<Notification> pushHandlers = new NotificationHandlers<>(
            notification -> System.out.printf("push notification: %s\n", notification.getMessage()),
            filter,
            notification -> "%s / %s".formatted(notification.getMessage(), PUSH_FOOTER)
        );

        manager.registerHandler(NotificationType.EMAIL, emailHandlers);
        manager.registerHandler(NotificationType.SMS, smsHandlers);
        manager.registerHandler(NotificationType.PUSH, pushHandlers);
    }

    public static void main(String[] args) {
        registerHandlers();

        Notification emailNotification = new Notification(NotificationType.EMAIL, "Ваш аккаунт активирован");
        Notification smsNotification = new Notification(NotificationType.SMS, "Ваш пароль изменен");
        Notification pushNotification = new Notification(NotificationType.PUSH, "У вас новое сообщение!");

        manager.sendNotification(emailNotification);
        manager.sendNotification(smsNotification);
        manager.sendNotification(pushNotification);
    }
}
