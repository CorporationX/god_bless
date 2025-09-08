package school.faang.module2.meta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Notification {
    private final NotificationType type;
    @Setter
    private String message;
}
