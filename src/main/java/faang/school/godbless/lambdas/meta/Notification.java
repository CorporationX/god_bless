package faang.school.godbless.lambdas.meta;

import lombok.Data;

@Data
public class Notification {
    private String type;
    private String message;

    public Notification(String type, String message) {
        if (type == null || type.isEmpty() || type.isBlank()) {
            throw new IllegalArgumentException("Type can`t be empty");
        }
        if (message == null || message.isEmpty() || message.isBlank()) {
            throw new IllegalArgumentException("Message can`t be empty");
        }
        this.type = type;
        this.message = message;
    }
}
