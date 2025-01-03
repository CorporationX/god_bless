package derschrank.sprint04.task11.bjstwo_50572;

import java.util.ArrayList;
import java.util.List;

public class NotificationManager implements NotificationManagerInterface{
    private static final int DELAY_FOR_FETCHNOTIFICATION_MILLIS = 1000;
    private final List<Notification> notifications;

    public NotificationManager() {
        notifications = new ArrayList<>();
    }

    @Override
    public synchronized void addNotification(Notification notification) {
        notifications.add(notification);
    }

    @Override
    public void fetchNotification(int id, String message) {
        NotificatonService.toSleep(DELAY_FOR_FETCHNOTIFICATION_MILLIS);
        Notification notification = new Notification(id, message);
        addNotification(notification);
        System.out.println("Message was added: " + notification);
    }

    @Override
    public void printNotifications() {
        List<Notification> copyOfNotifications;
        synchronized (this) {
            copyOfNotifications = new ArrayList<>(notifications);
        }
        copyOfNotifications.forEach(System.out::println);
    }
}
