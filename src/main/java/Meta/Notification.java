package Meta;

import lombok.Getter;

@Getter
public class Notification {
    private final String type;
    private final String message;

    public Notification(String type, String message) {
        this.type = type;
        this.message = message;
    }
}
