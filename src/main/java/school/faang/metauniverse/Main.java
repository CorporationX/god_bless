package school.faang.metauniverse;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();
        manager.registerHandler(NotificationType.EMAIL,
                notification -> System.out.println(notification.getMessage()));
        manager.registerHandler(NotificationType.PUSH,
                notification -> System.out.println(notification.getMessage()));
        manager.registerHandler(NotificationType.SMS,
                notification -> System.out.println(notification.getMessage()));

        String badWord = "badword";
        manager.setFilter(notification -> {
            String message = notification.getMessage().toLowerCase();
            return message.contains(badWord);
        });

        String modifier = "\nWith love by marsel-mkh\n";
        manager.modifierNotification(notification -> {
            String message = notification.getMessage() + modifier;
            return new Notification(notification.getType(), message);
        });

        Notification emailNotification = new Notification(NotificationType.EMAIL,
                "Вы отправили email");
        Notification pushNotification = new Notification(NotificationType.PUSH,
                "Вы отправили push уведомление");
        Notification smsNotification = new Notification(NotificationType.SMS,
                "Вы отправили sms ");
        Notification badSmsNotification = new Notification(NotificationType.SMS,
                "В этом сообщение присутствуют badword");
        Notification nullNotification = new Notification(null,
                "Это сообщение с неизвестным типом");

        manager.sendNotification(emailNotification);
        manager.sendNotification(pushNotification);
        manager.sendNotification(smsNotification);
        manager.sendNotification(badSmsNotification);
        manager.sendNotification(nullNotification);

    }
}
