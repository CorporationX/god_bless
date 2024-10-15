package school.faang.bjs2_34844.service;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class ValidatorNotificationManager {
    public void validateNotNull(Object object, String errMessage) {
        if (object == null) {
            throw new IllegalArgumentException(errMessage);
        }
    }

    public void validateRegisterHandler(TypeNotification typeNotification, Consumer<Notification> handler) {
        validateNotNull(typeNotification, ErrMessagesValidate.TYPE_NOTIFICATION_IS_NULL);
        validateNotNull(handler, ErrMessagesValidate.HANDLER_IS_NULL);
    }

    public void validateSendNotification(Notification notification) {
        validateNotNull(notification, ErrMessagesValidate.NOTIFICATION_IS_NULL);

        TypeNotification typeNotification = notification.getType();
        if (typeNotification == null) {
            throw new NoSuchElementException(ErrMessagesValidate.TYPE_NOTIFICATION_IS_NULL);
        }
    }
}
