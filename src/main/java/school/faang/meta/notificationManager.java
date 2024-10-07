package school.faang.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class notificationManager {
    private static final Map<String, Consumer<Notification>> NOTIFICATION_TYPE_NOTIFICATION_MANGER = new HashMap<>();

    public static void main(String[] args) {
        notificationManager notificationManager = getNotificationManger();

        Notification emailNotification = new Notification("email", "You account has been successfully activated");
        Notification smsNotification = new Notification("sms", "You have successfully changed your password");
        Notification pushNotification = new Notification("push", "A new post from user: JohnDoe");
        Notification unknownNotification = new Notification("unknown", "A secret message from UFO is here for you, human...");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
        notificationManager.sendNotification(unknownNotification);

    }

    private static notificationManager getNotificationManger() {
        notificationManager notificationManager = new notificationManager();

        notificationManager.registerHandler("email",
                (notification) -> System.out.println("Sending by email: " + notification.getMessage()));
        notificationManager.registerHandler("sms",
                (notification) -> System.out.println("Sending message by sms" + notification.getMessage()));
        notificationManager.registerHandler("push",
                (notification) -> System.out.println("Sending a push notification: " + notification.getMessage()));
        return notificationManager;
    }

    public void registerHandler(String notificationIdentifier, Consumer<Notification> notification) {
        NOTIFICATION_TYPE_NOTIFICATION_MANGER.put(notificationIdentifier, notification);
    }

    public void sendNotification(Notification notification) {
        Consumer<Notification> notificationHandler = NOTIFICATION_TYPE_NOTIFICATION_MANGER.get(notification.getType());
        if (notificationHandler != null) {
            notificationHandler.accept(notification);
        } else {
            System.out.println("Oops looks like we can't handle this type of notification: " + notification.getType());
        }
    }
}