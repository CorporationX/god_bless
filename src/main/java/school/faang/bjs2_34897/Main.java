package school.faang.bjs2_34897;

public class Main {
    public static void main(String[] args) {

        NotificationManager manager1 = new NotificationManager();
        NotificationManager manager2 = new NotificationManager();

        manager1.registerHandler("Email", (notification) -> {
            System.out.println("Sending email; " + notification.getMessage());
        });

        manager2.registerContentFilter((notification -> {
            return !notification.getMessage().toLowerCase().contains("spam");
        }));

        Notification emailNote1 = new Notification("Email", "Nice to see you here with us");
        Notification emailNote2 = new Notification("Email", "Dame spam!!!");

        manager1.sendNotification(emailNote1);
        manager1.sendNotification(emailNote2);

        manager2.registerHandler("Push", (notification) -> {
            System.out.println("Send push notification ; " + notification.getMessage());
        });


        Notification pushNotification = new Notification("Push", "Warning something bad happend");
        manager2.sendNotification(pushNotification);

        manager2.sendNotification(emailNote1);
        manager2.sendNotification(emailNote2);
    }
}
