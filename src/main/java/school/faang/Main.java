package school.faang;

import school.faang.bjs46858.Notification;
import school.faang.bjs46858.NotificationManager;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        notificationManager.addValidation((notification) -> !notification.getMessage().contains("негр"));

        notificationManager.registerHandler("Phone notification",
                notification -> System.out.println("Message \"" + notification.getMessage() + "\" is sent to phone"));

        Notification notification = new Notification("Phone notification", "Прив негр");
        try {
            notificationManager.sendNotification(notification);
        } catch (IllegalArgumentException e) {
            notification.setMessage("Прив афроамериканец");
            notificationManager.sendNotification(notification);
        }
    }
}
