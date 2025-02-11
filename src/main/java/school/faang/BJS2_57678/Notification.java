package school.faang.BJS2_57678;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@EqualsAndHashCode
@Getter

public class Notification {
    private final NotificationType type;
    @Setter
    private String message;
}
