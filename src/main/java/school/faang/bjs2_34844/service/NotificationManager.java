package school.faang.bjs2_34844.service;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
@Getter
public class NotificationManager {
    private final Map<TypeNotification, Consumer<Notification>> notificationIDsWithTheirHandlers = new HashMap<>();
    private final ValidatorNotificationManager validator = new ValidatorNotificationManager();

    public void registerHandler(TypeNotification typeNotification, Consumer<Notification> handler) {
        validator.validateRegisterHandler(typeNotification, handler);
        notificationIDsWithTheirHandlers.put(typeNotification, handler);
    }

    public void sendNotification(Notification notification) {
        validator.validateSendNotification(notification);
        TypeNotification typeNotification = notification.getType();

        Consumer<Notification> handler = notificationIDsWithTheirHandlers.get(typeNotification);
        handler.accept(notification);
    }


}
