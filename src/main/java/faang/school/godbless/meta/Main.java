package faang.school.godbless.meta;

import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        Consumer<Notification> notificationHandler = notification -> System.out.println("new msg from "+notification.getMessage());
        Consumer<Notification> gmailHandler = notification -> System.out.println("new email from "+notification.getMessage());
        notificationManager.registerHandler("message",notificationHandler);
        notificationManager.registerHandler("gmail",gmailHandler);
        Notification msg = new Notification("message","Hello");
        Notification googleMail = new Notification("gmail","New mail from user....");
        notificationManager.sendNotification(msg);
        notificationManager.sendNotification(googleMail);
    }
}
