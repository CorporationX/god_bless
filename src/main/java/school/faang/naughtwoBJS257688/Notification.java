package school.faang.naughtwoBJS257688;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Notification {
    private NotificationType type;
    private String message;

    public Notification(NotificationType type, String message) {
        if (message == null
                || message.isBlank()
                || doesMessageContainObscene(message)
                || isTypeInNotification(type)) {
            new IllegalArgumentException("Incorrect data entered");
        }
        else {
            this.type = type;
            this.message = message;
        }
    }

    private static boolean isTypeInNotification(NotificationType type) {
        for (NotificationType constant : NotificationType.values()) {
            if (constant.equals(type)) {
                return true;
            }
        }
        return false;
    }

    private static boolean doesMessageContainObscene(String message) {
        String messageLoverCase = message.toLowerCase();
        for (ObsceneExpressions word : ObsceneExpressions.values()) {
            if (messageLoverCase.contains(word.name().toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
