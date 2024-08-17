package faang.school.godbless.meta;

import lombok.Data;

@Data
public class Notification {
    private String type;
    private String message;

    Notification(String type, String message) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("Type cannot be null or empty");
        }
        if (message == null || message.isEmpty()) {
            throw new IllegalArgumentException("Message cannot be null or empty");
        }
        this.type = type;
        this.message = message;
    }
}
