package school.faang.bsj2_87711;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class Notification {
    public static final int MAX_NOTIFICATION_LENGTH = 20;
    private NotificationType type;
    private String message;
}
