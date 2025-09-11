package school.faang.bjs2_87701;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Notification {
    private NotificationType type;
    private String message;
}
