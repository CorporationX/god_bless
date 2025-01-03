package derschrank.sprint04.task11.bjstwo_50572;

public interface NotificationManagerInterface {
    void addNotification(Notification notification);

    void fetchNotification(int id, String message);

    void printNotifications();
}
