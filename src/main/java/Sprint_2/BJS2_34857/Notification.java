package Sprint_2.BJS2_34857;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Notification {
    private final String  type;
    private String message;

    public Notification(String type, String message) {
        this.type = type;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "type='" + type + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
