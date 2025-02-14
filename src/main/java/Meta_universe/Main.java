package Meta_universe;

import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();
        testRegisterHandler(manager);
        testSendNotification(manager);
        testAddFilter(manager);
        testSetMessageCorrector(manager);
    }

    private static void testRegisterHandler(NotificationManager manager) {
        try {
            manager.registerHandler(NotificationType.SMS, notification ->
                    System.out.println("Sending SMS: " + notification.getMessage()));
            manager.registerHandler(NotificationType.EMAIL, notification ->
                    System.out.println("Sending Email: " + notification.getMessage()));
            manager.registerHandler(NotificationType.PUSH, notification ->
                    System.out.println("Sending Push Notification: " + notification.getMessage()));
            manager.registerHandler(NotificationType.SMS, notification ->
                    System.out.println("Sending SMS again"));
        } catch (Exception e) {
            System.out.println("Exception during handler registration: " + e.getMessage());
        }
    }

    private static void testSendNotification(NotificationManager manager) {
        Notification smsNotification = new Notification(NotificationType.SMS, "New SMS message!");
        Notification emailNotification = new Notification(NotificationType.EMAIL, "New Email!");
        Notification pushNotification = new Notification(NotificationType.PUSH, "New Push Notification!");

        manager.sendNotification(smsNotification);
        manager.sendNotification(emailNotification);
        manager.sendNotification(pushNotification);
    }

    private static void testAddFilter(NotificationManager manager) {
        Predicate<Notification> fishingFilter = notification -> !notification.getMessage().contains("fishing");
        manager.addFilter(fishingFilter);
        Notification fishingNotification = new Notification(NotificationType.EMAIL, "Fishing offer!");
        manager.sendNotification(fishingNotification);
    }

    private static void testSetMessageCorrector(NotificationManager manager) {
        Function<Notification, Notification> signatureCorrector = notification -> {
            String newMessage = notification.getMessage() + "\nBest regards, Meta Team!";
            return new Notification(notification.getType(), newMessage);
        };
        manager.setMessageCorrector(signatureCorrector);

        Notification notification = new Notification(NotificationType.PUSH, "New push notification!");
        manager.sendNotification(notification);
    }
}