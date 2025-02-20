package school.faang.metauniverse;

import lombok.Getter;

@Getter
public class Notification {

    enum NotificationType {
        EMAIL, PUSH, SMS
    }

    private final NotificationType type;
    private final String message;

    public Notification(NotificationType type, String message) {
        this.type = type;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Notification{type=" + type + ", message= " + message + "}";
    }
}