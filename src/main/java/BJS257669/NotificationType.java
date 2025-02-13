package BJS257669;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum NotificationType {
    EMAIL("email"),
    SMS("sms"),
    PUSH("push");

    private final String notificationName;

    NotificationType(String notificationName) {
        this.notificationName = notificationName;
    }

    public String getNotificationName() {
        return notificationName;
    }
}

