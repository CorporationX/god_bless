package school.faang.task2102;

import lombok.Data;

@Data
public class Notification {
    private String type;
    private String message;

    public Notification(String type, String message) {
        this.type = type;
        this.message = message;
    }
}
