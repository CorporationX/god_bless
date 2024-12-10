package school.faang.task_46701;

import lombok.Getter;

@Getter
public class Notification {
    private final String type;
    private final String message;

    public Notification(String type, String message) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("type не может быть пустым");
        }
        if (message == null || message.isEmpty()) {
            throw new IllegalArgumentException("message не может быть пустым");
        }

        this.type = type;
        this.message = message;
    }
}
