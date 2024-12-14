package school.faang.task_46868;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Notification {
    @Getter private String type;
    @Setter private String message;

    public Notification(String type, String message) {
        this.type = type;
        if (type.trim().isEmpty()) {
            throw new IllegalArgumentException("Type cannot be empty");
        }
        this.message = message;
        if (message.trim().isEmpty()) {
            throw new IllegalArgumentException("Message cannot be empty");
        }
    }
}
