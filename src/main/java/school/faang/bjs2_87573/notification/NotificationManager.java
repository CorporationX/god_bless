package school.faang.bjs2_87573.notification;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

import school.faang.bjs2_87573.exception.NotificationHandlerAlreadyExistsException;
import school.faang.bjs2_87573.exception.NotificationHandlerUpdatingFailedException;
import school.faang.bjs2_87573.exception.NotificationTypeNotFoundException;
import school.faang.bjs2_87573.notification.Notification.NotificationType;

public class NotificationManager {
    private static final Map<NotificationType, Consumer<Notification>> NOTIFICATION_HANDLERS = new HashMap<>();

    private NotificationManager() {

    }

    public static void registerHandler(NotificationType notificationType, Consumer<Notification> handler) {
        NotificationValidator.validateNotificationType(notificationType);
        ensureNotificationHandlerValid(handler);
        if (NOTIFICATION_HANDLERS.containsKey(notificationType)) {
            throw new NotificationHandlerAlreadyExistsException(
                    "the handler already exists - if you want a new version you should update this handler"
            );
        }
        NOTIFICATION_HANDLERS.put(notificationType, handler);
    }

    public static void sendNotification(Notification notification) {
        Objects.requireNonNull(notification, "notification cannot be null");
        NotificationType notificationType = notification.notificationType();
        ensureNotificationTypeExists(notificationType);
        NOTIFICATION_HANDLERS.get(notificationType).accept(notification);
    }

    public static void updateNotificationHandler(NotificationType notificationType, Consumer<Notification> newHandler) {
        NotificationValidator.validateNotificationType(notificationType);
        try {
            ensureNotificationTypeExists(notificationType);
        } catch (NotificationTypeNotFoundException e) {
            throw new NotificationHandlerUpdatingFailedException("cannot update the handler", e);
        }
        ensureNotificationHandlerValid(newHandler);
        NOTIFICATION_HANDLERS.put(notificationType, newHandler);
    }

    private static void ensureNotificationTypeExists(NotificationType notificationType) {
        if (!NOTIFICATION_HANDLERS.containsKey(notificationType)) {
            throw new NotificationTypeNotFoundException("notification type is not registered yet");
        }
    }

    private static void ensureNotificationHandlerValid(Consumer<Notification> notificationHandler) {
        Objects.requireNonNull(notificationHandler, "notification handler cannot be null");
    }
}
