package school.faang.metaverse;

import lombok.Data;

import java.util.function.Consumer;
@Data
public class Notification {
    NotificationType type;
    String message;
}
