package school.faang.BJS2_34774;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Notification {
    private NotificationType type;
    private String message;
}
