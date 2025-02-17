package school.faang.task_57967;

public class InvalidNotificationTypeException extends NotificationException {
    public InvalidNotificationTypeException(String type) {
        super("Invalid notification type: " + type);
    }
}
