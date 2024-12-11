package school.faang.task_46642;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum NotificationType {
    EMAIL("email"),
    SMS("sms"),
    PUSH("push");

    private final String type;

    public static NotificationType fromString(String type) {
        for (NotificationType notificationType : values()) {
            if (notificationType.type.equalsIgnoreCase(type)) {
                return notificationType;
            }
        }
        throw new IllegalArgumentException("Unknown notification type: " + type);
    }
}