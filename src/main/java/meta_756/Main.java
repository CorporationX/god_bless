package meta_756;

public class Main {
    public static void main(String[] args) {

        NotificationManager notificationManager = new NotificationManager();

        Notification phonenotification = new Notification("phone", " to Manager");
        Notification emailnotification = new Notification("email", " to Customer");

        notificationManager.registerHandler("phone", (notification)
                -> System.out.println("Call by " + notification.getType() + notification.getMessage()));
        notificationManager.registerHandler("email", (notification)
                -> System.out.println("Send a message by " + notification.getType() + notification.getMessage()));
        notificationManager.sendNotification(phonenotification);
        notificationManager.sendNotification(emailnotification);

    }
}