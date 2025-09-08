package school.faang.bjs2_87573.notification;

public record Notification(String message, NotificationType notificationType) {
    public Notification(String message, NotificationType notificationType) {
        NotificationValidator.validateNotification(message, notificationType);
        this.message = message;
        this.notificationType = notificationType;
    }

    public enum NotificationType {
        EMAIL,
        SMS,
        PUSH
    }
}
