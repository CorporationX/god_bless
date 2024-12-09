package school.faang.task_46597;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.addFilter(n -> new Notification(n.type(), n.message().toUpperCase()));

        notificationManager.registerHandler("ApplicationMessage", (t) -> System.out.println(t));
        notificationManager.registerHandler("EmailMessage", (t) -> System.out.println(t));

        List<Notification> notifications = List.of(
                new Notification("ApplicationMessage", "info1"),
                new Notification("ApplicationMessage", "info2"),
                new Notification("EmailMessage", "error1")
        );

        notifications.forEach(notificationManager::sendNotification);
    }
}
