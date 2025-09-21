package school.faang.s2_func_int_meta;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Notification {
    private NotificationType type;
    private String message;
}
