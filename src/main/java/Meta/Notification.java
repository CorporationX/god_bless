package Meta;

import lombok.Getter;
import lombok.Setter;

public class Notification {
    @Getter
    private final NotificationType type;
    @Getter
    private final String message;

    public Notification(NotificationType type, String message) {
        this.type = type;
        this.message = message;
    }
    
    @Override
    public String toString() {
        return "Notification{" +
                "type=" + type +
                ", message='" + message + '\'' +
                '}';
    }
}
