package school.faang;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Notification {
    private String type;
    private String message;

    Notification(String type, String message) {
        this.type = type;
        this.message = message;
    }
}
