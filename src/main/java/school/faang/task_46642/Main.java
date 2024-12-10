package school.faang.task_46642;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler("email", (notification) ->
                System.out.println("Sending via email: " + notification.message())
        );

        notificationManager.registerHandler("sms", (notification) ->
                System.out.println("Sending SMS: " + notification.message())
        );

        notificationManager.registerHandler("push", (notification) ->
                System.out.println("Sending push notification: " + notification.message())
        );

        notificationManager.addFilter("restricted", (notification) -> {
            if (notification.message().contains("restricted")) {
                System.out.println("Restricted content detected in the message: " + notification.message());
            }
        });

        Notification emailNotification = new Notification("email",
                "Your account has been successfully activated.");
        Notification smsNotification = new Notification("sms",
                "You successfully changed your password.");
        Notification pushNotification = new Notification("push",
                "New post from user: JohnDoe.");
        Notification filteredNotification = new Notification("email",
                "Contains restricted content in the text.");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);

        notificationManager.processFilters(filteredNotification);
    }
}