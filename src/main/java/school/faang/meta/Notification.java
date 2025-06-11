package school.faang.meta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Notification {

    private NotificationType notificationType;
    private String message;
}
