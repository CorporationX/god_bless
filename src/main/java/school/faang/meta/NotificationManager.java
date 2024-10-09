package school.faang.meta;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import static school.faang.meta.NotificationType.EMAIL;
import static school.faang.meta.NotificationType.PUSH;
import static school.faang.meta.NotificationType.SMS;
import static school.faang.meta.NotificationType.UNKNOWN;

public class NotificationManager {
    private static final Map<NotificationType, Consumer<Notification>> NOTIFICATION_TYPE_NOTIFICATION_MANGER = new HashMap<>();

    public static void main(String[] args) {
        NotificationManager notificationManager = getNotificationManger();

        Notification emailNotification = new Notification(EMAIL, "You account has been successfully activated");
        Notification smsNotification = new Notification(SMS, "You have successfully changed your password");
        Notification pushNotification = new Notification(PUSH, "A new post from user: JohnDoe");
        Notification unknownNotification = new Notification(UNKNOWN, "A secret message from UFO is here for you, human...");

        notificationManager.sendNotification(emailNotification);
        notificationManager.sendNotification(smsNotification);
        notificationManager.sendNotification(pushNotification);
        notificationManager.sendNotification(unknownNotification);

    }

    private static NotificationManager getNotificationManger() {
        NotificationManager notificationManager = new NotificationManager();

        notificationManager.registerHandler(EMAIL,
                (notification) -> System.out.println("Sending by email: " + notification.getMessage()));
        notificationManager.registerHandler(SMS,
                (notification) -> System.out.println("Sending message by sms: " + notification.getMessage()));
        notificationManager.registerHandler(PUSH,
                (notification) -> System.out.println("Sending a push notification: " + notification.getMessage()));
        return notificationManager;
    }

    public void registerHandler(NotificationType notificationIdentifier, Consumer<Notification> notification) {
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