package school.faang.BJS2_57838;

import lombok.*;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class Notification {
    private NotificationType type;
    private String message;
}
