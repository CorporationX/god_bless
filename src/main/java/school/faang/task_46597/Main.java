package school.faang.task_46597;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.addFilter(n -> new Notification(n.type(), n.message().toUpperCase()));

        notificationManager.registerHandler("ApplicationMessage", (t) -> System.out.println(t));
        notificationManager.registerHandler("EmailMessage", (t) -> System.out.println(t));

        notificationManager.sendNotification(new Notification("ApplicationMessage", "info1"));
        notificationManager.sendNotification(new Notification("ApplicationMessage", "info2"));

        notificationManager.sendNotification(new Notification("EmailMessage", "error1"));
    }
}
