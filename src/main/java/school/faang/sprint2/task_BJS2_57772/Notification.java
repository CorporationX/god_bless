package school.faang.sprint2.task_BJS2_57772;

import lombok.Getter;

@Getter
public class Notification {
    private NotificationType type;
    private String message;

    public Notification(NotificationType type, String message) {
        checkParam(type, message);
        this.type = type;
        this.message = message;
    }

    private void checkParam(NotificationType type, String message) {
        if (type == null) {
            throw new IllegalArgumentException("Тип не может быть null");
        }
        if (message == null || message.isBlank()) {
            throw new IllegalArgumentException("Сообщение не может быть пустым или null");
        }
    }
}
