package school.faang.task_57967;

public class FilteredNotificationException extends NotificationException {
    public FilteredNotificationException(String message) {
        super("Notification filtered out: " + message);
    }
}
