package school.faang.universe.meta;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Notification {
    private final NotificationType type;
    private final String message;

    public Notification(NotificationType type, String message) {
        checkValidArgument(type, "notification type");
        checkValidArgument(message, "message");
        this.type = type;
        this.message = message;
    }

    private <T> void checkValidArgument(T argument, String argumentName) {
        if (argument == null) {
            throw new IllegalArgumentException("The " + argumentName + " type cannot be null.");
        }
        if (argument.getClass() == String.class && ((String) argument).isBlank()) {
            throw new IllegalArgumentException("The " + argumentName + " type cannot be blank.");
        }
    }
}
