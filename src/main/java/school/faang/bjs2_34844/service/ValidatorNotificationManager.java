package school.faang.bjs2_34844.service;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class ValidatorNotificationManager {
     void validateNotNull(Object object, ErrMessageValidate errMessage) {
        if (object == null) {
            throw new IllegalArgumentException(errMessage.name());
        }
    }

     void validateRegisterHandler(TypeNotification typeNotification, Consumer<Notification> handler) {
        validateNotNull(typeNotification, ErrMessageValidate.TYPE_NOTIFICATION_IS_NULL);
        validateNotNull(handler, ErrMessageValidate.HANDLER_IS_NULL);
    }

     void validateSendNotification(Notification notification) {
        validateNotNull(notification, ErrMessageValidate.NOTIFICATION_IS_NULL);

        TypeNotification typeNotification = notification.getType();
        if (typeNotification == null) {
            throw new NoSuchElementException(ErrMessageValidate.TYPE_NOTIFICATION_IS_NULL.name());
        }
    }
}
