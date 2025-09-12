package school.faang.bjs2_87681;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Getter
public class Notification {
    private  NotificatonType type;
    private String message;
}

enum NotificationType {
    EMAIL,
    SMS,
    PUSH
}

