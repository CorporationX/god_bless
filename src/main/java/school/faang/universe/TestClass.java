package school.faang.universe;

public class TestClass {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.addFilterSubstitution("activated", String::toUpperCase);
        notificationManager.addFilterSubstitution("elephant", mess -> "<Prohibited content>");

        notificationManager.registerHandler("email",
                (notification) -> System.out.println("Sending email: " + notification.getMessage())
        );

        notificationManager.registerHandler("sms",
                (notification) -> System.out.println("Sending SMS: " + notification.getMessage())
        );

        notificationManager.registerHandler("push",
                (notification) -> System.out.println("Sending push: " + notification.getMessage())
        );

        Notification otherEmailNotification= new Notification("email", "Elephant for sale");
        Notification emailNotification = new Notification("email", "Your account has been activated");
        Notification smsNotification = new Notification("sms", "You have successfully changed your password");
        Notification pushNotification = new Notification("push1", "New post from: JohnDoe");

        notificationManager.sendNotification(emailNotification).orElseGet(() -> {
            System.out.println("Sending error: " + emailNotification.getType());
            return false;
        });

        notificationManager.sendNotification(otherEmailNotification).orElseGet(() -> {
            System.out.println("Sending error: " + otherEmailNotification.getType());
            return false;
        });

        notificationManager.sendNotification(smsNotification).orElseGet(() -> {
            System.out.println("Sending error: " + smsNotification.getType());
            return false;
        });

        notificationManager.sendNotification(pushNotification).orElseGet(() -> {
            System.out.println("Sending error: " + pushNotification.getType());
            return false;
        });
    }
}
