package school.faang.meta_universe;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Notification {

    private NotificationType type;
    private String message;

    @Override
    public String toString() {
        return "Notification{" +
                "type=" + type +
                ", message='" + message + '\'' +
                '}';
    }

}
