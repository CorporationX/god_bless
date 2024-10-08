package school.faang.meta_universe_BJS2_34638;

public class Main {

    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("email",
                (notification) -> System.out.println("Sending email: " + notification.getMessage())
                ,notificationManager.getNotificationsImplementations()
        );
        notificationManager.registerHandler("sms",
                (notification) -> System.out.println("Sending SMS: " + notification.getMessage())
                ,notificationManager.getNotificationsImplementations()
        );
        notificationManager.registerHandler("push",
                (notification) -> System.out.println("Sending push notification: " + notification.getMessage())
                ,notificationManager.getNotificationsImplementations()
        );
        notificationManager.registerHandler("fax",
                (notification) -> System.out.println("This is inappropriate content"),
                notificationManager.getInappropriateContent()
        );

        Notification emailNotification = new Notification("email", "Your account has been successfully activated");
        Notification smsNotification = new Notification("sms", "You have successfully changed your password");
        Notification pushNotification = new Notification("push", "New post from user: JohnDoe");
        Notification faxNotification = new Notification("fax", "Please review and sign the attached document");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
        notificationManager.blockInappropriateContent(faxNotification);
    }
}
