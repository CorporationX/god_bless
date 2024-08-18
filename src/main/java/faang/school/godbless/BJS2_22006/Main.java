package faang.school.godbless.BJS2_22006;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("email", (notification) -> System.out.println("Sending by email: " + notification.getMessage()));
        notificationManager.registerHandler("sms", (notification) -> System.out.println("Sending SMS: " + notification.getMessage()));
        notificationManager.registerHandler("push", (notification) -> System.out.println("Sending a push notification: " + notification.getMessage()));

        Notification emailNotificationOne = new Notification("email", "Your account has been successfully activated");
        Notification emailNotificationTwo = new Notification("email", "");
        Notification smsNotification = new Notification("sms", "You have successfully changed your password");
        Notification pushNotification = new Notification("push", "New post from user: Frank");

        notificationManager.sendNotification(emailNotificationOne);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);

        notificationManager.addNotificationFilter(notification -> !notification.getMessage().isBlank());
        notificationManager.addNotificationFilter(notification -> !notification.getType().equals("sms"));

        System.out.println(notificationManager.isValidNotification(emailNotificationOne));
        System.out.println(notificationManager.isValidNotification(emailNotificationTwo));
        System.out.println(notificationManager.isValidNotification(smsNotification));
        System.out.println(notificationManager.isValidNotification(pushNotification));
    }
}
