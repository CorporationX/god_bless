package school.faang.s2.func_int.meta;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Notification {
    private NotificationType type;
    private String message;
}