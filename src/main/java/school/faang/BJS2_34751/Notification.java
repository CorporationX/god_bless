package school.faang.BJS2_34751;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class Notification {
    String type;
    String message;

    public Notification(String message, String type) {
        this.message = message;
        this.type = type;
    }
}
