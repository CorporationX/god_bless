package faang.school.godbless.meta;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Notification {
    private String type;
    private String message;

    public Notification(String type, String message) {
        this.type = type;
        this.message = message;
    }
}
