package school.faang.bjs2_34897;

public class Main {
    public static void main(String[] args) {
        NotificationManager.registerHandler("Email", (notification) -> {
            System.out.println("Sending email; " + notification.getMessage());
        });

        NotificationManager.registerContentFilter((notification -> {
            return !notification.getMessage().toLowerCase().contains("spam");
        }));

        Notification emailNote1 = new Notification("Email", "Nice to see you here with us");
        Notification emailNote2 = new Notification("Email", "Dame spam!!!");

        NotificationManager.sendNotification(emailNote1);
        NotificationManager.sendNotification(emailNote2);

        NotificationManager.registerHandler("Push", (notification) -> {
            System.out.println("Send push notification ; " + notification.getMessage());
        });


        Notification pushNotification = new Notification("Push", "Warning something bad happend");
        NotificationManager.sendNotification(pushNotification);
    }
}
