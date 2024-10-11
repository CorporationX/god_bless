package school.faang.BJS2_34767;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;

public class NotificationManager {
    private static final Map<NotificationType, Consumer<Notification>> NOTIFICATION_HANDLER = new HashMap<>();
    private static final Set<String> FORBIDDEN_WORDS = Set.of("Дурак", "Глупый", "Толстый", "Плохой");
    private static final String ALLOWED_WORD = "Учиться";

    void registerHandler(NotificationType type, Consumer<Notification> handler) {
        if (validate(type, handler)) {
            NOTIFICATION_HANDLER.put(type, handler);
        } else {
            System.out.println("Проверьте входные данные!");
        }
    }

    void sendNotification(Notification notification) {
        if (validate(notification)) {
            checkNotificationMassage(notification);

            if (NOTIFICATION_HANDLER.containsKey(notification.getType())) {
                NOTIFICATION_HANDLER.get(notification.getType()).accept(notification);
            }
        } else {
            System.out.println("Проверьте входные данные!");
        }
    }

    private void checkNotificationMassage(Notification notification) {
        FORBIDDEN_WORDS.forEach((word) -> {
            if (notification.getMessage().toLowerCase().contains(word.toLowerCase())) {
                notification.setMessage(notification.getMessage().replace(word.toLowerCase(), ALLOWED_WORD));
            }
        });
    }

    private boolean validate(Notification notification) {
        return Objects.nonNull(notification);
    }

    private boolean validate(NotificationType notificationType) {
        return Objects.nonNull(notificationType);
    }

    private boolean validate(NotificationType notificationType, Consumer<Notification> notificationHandler) {
        return validate(notificationType) && Objects.nonNull(notificationHandler);
    }
}
