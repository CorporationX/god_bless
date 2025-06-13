package school.faang.meta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Notification {
    private NotificationType notificationType;
    private String message;
}
