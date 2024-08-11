package faang.school.godbless.meta_universe;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Notification {
    private String type;
    private String message;

    public Notification(String type, String message) {
        if (type == null || message == null) {
            throw new IllegalArgumentException("type and message cannot be null");
        }
        if (type.isEmpty() || message.isEmpty()) {
            throw new IllegalArgumentException("type and message cannot be empty");
        }
        this.type = type;
        this.message = message;
    }
}
