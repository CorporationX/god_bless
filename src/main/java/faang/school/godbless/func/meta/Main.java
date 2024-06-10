package faang.school.godbless.func.meta;

public class Main {

    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        // consumer-like
        notificationManager.registerHandler("push", (notification) -> {
            System.out.println("Sending push notification: " + notification.message());
            return null;
        });

        // function-like
        notificationManager.registerHandler("message", notification -> notification.message().replace("Instagram", "Meta"));

        Notification pushNotification = new Notification("push", "You have a new subscriber!");
        Notification messageNotification = new Notification("message", "Hey! have you heard about this new Instagram feature?");

        notificationManager.sendNotification(pushNotification);
        String message = notificationManager.sendNotification(messageNotification);
        System.out.println(message);
    }
}
