package school.faang.bjs2_70675;

/**
 * Задача Meta-вселенная?
 */
public class Main {

    public static final int MAX_SMS_MESSAGE_LENGTH = 160;
    public static final int MAX_SMS_UNICODE_MESSAGE_LENGTH = 70;

    public static void main(String[] args) {
        NotificationManager notificationManager = getNotificationManager();

        notificationManager.registerHandler(NotificationType.EMAIL,
                notification -> System.out.println("Email: " + notification.getMessage()));

        notificationManager.registerHandler(NotificationType.SMS,
                notification -> System.out.println("SMS: " + notification.getMessage()));

        notificationManager.registerHandler(NotificationType.PUSH,
                notification -> System.out.println("Push: " + notification.getMessage()));

        Notification emailNotification = new Notification(NotificationType.EMAIL, "Ваш аккаунт активирован");
        Notification smsNotification = new Notification(NotificationType.SMS, "Ваш пароль изменен");
        Notification pushNotification = new Notification(NotificationType.PUSH, "У вас новое сообщение!");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }

    private static NotificationManager getNotificationManager() {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.setNotificationModifier(
                notification -> {
                    notification.setMessage(notification.getMessage() + " (Подпись, высказывающая всяческое уважение)");
                    return notification;
                }
        );

        notificationManager.setNotificationFilter(notification -> {
            String message = notification.getMessage();

            if (notification.getType() == NotificationType.SMS) {
                int maxMessageLength = MAX_SMS_MESSAGE_LENGTH;
                for (char currentChar : message.toCharArray()) {
                    if (Character.UnicodeBlock.of(currentChar) != Character.UnicodeBlock.BASIC_LATIN) {
                        maxMessageLength = MAX_SMS_UNICODE_MESSAGE_LENGTH;
                        break;
                    }
                }

                return message.length() <= maxMessageLength;
            }

            return true;
        });

        return notificationManager;
    }
}
