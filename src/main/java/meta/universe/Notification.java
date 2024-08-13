package meta.universe;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Notification {
    String type;
    String message;

    public Notification(String type, String message) {
        this.type = type;
        this.message = message;
    }
}
