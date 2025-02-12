package school.faang.naughtwoBJS257688;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Notification {
    private NotificationType type;
    private String message;

    public Notification(NotificationType type, String message) {
        if (message == null || type == null
                || message.isBlank()
                || doesMessageContainObscene(message)) {
            throw new IllegalArgumentException("Incorrect data entered");
        } else {
            this.type = type;
            this.message = message;
        }
    }

    private static boolean doesMessageContainObscene(String message) {
        String messageLowerCase = message.toLowerCase();
        for (ObsceneExpressions word : ObsceneExpressions.values()) {
            if (messageLowerCase.contains(word.name().toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
