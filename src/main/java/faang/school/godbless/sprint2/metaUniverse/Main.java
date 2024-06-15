package faang.school.godbless.sprint2.metaUniverse;

public class Main {

    public static void main(String[] args) {
        try {
            NotificationManager notificationManager = new NotificationManager();

            notificationManager.registerHandler("email", notification -> System.out.println("Email notification with message: " + notification.getMessage()));
            notificationManager.registerHandler("call", notification -> System.out.println("Call notification with message: " + notification.getMessage()));
            notificationManager.registerHandler("sms", notification -> System.out.println("Sms notification with message: " + notification.getMessage()));

            notificationManager.registerFilter("badWords", notification -> notification.getMessage().contains("bad word") ? null : notification);

            Notification emailNotification = new Notification("email", "email notification");
            Notification callNotification = new Notification("call", "call notification");
            Notification smsNotification = new Notification("sms", "sms notification with bad words");

            notificationManager.sendNotification(emailNotification);
            notificationManager.sendNotification(callNotification);
            notificationManager.sendNotification(smsNotification);
        } catch (Exception e) {
            System.out.println("Error message: " + e.getMessage());
        }
    }
}
