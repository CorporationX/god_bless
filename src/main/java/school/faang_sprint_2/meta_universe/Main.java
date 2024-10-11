package school.faang_sprint_2.meta_universe;

public class Main {

    public static void main(String[] args) {

        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("email",
                notification -> System.out.println("Send by email:" + notification.message()));
        notificationManager.registerHandler("sms",
                notification -> System.out.println("Send by SMS: " + notification.message()));
        notificationManager.registerHandler("push",
                notification -> System.out.println("Send push-notifications: " + notification.message()));

        Notification emailNotification = new Notification("email", "Your account successfully activated");
        Notification smsNotification = new Notification("sms", "Password successfully changed");
        Notification pushNotification = new Notification("push", "New post from user: JohnDoe");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
    }
}
