package school.faang.bjs2_87671;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Notification {
    private NotificationType type;
    private String message;
}
