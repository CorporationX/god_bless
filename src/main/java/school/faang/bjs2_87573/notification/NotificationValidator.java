package school.faang.bjs2_87573.notification;

public class NotificationValidator {
    static void validateNotification(String message, Notification.NotificationType notificationType) {
        validateNotificationMessage(message);
        validateNotificationType(notificationType);
    }

    static void validateNotificationMessage(String message) {
        if (message == null || message.isBlank()) {
            throw new IllegalArgumentException("notification message cannot be null");
        }
    }

    static void validateNotificationType(Notification.NotificationType notificationType) {
        if (notificationType == null) {
            throw new IllegalArgumentException("notification type cannot be null");
        }
    }
}
