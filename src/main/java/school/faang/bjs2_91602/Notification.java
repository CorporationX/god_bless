package school.faang.bjs2_91602;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Notification {

    private final NotificationType type;
    private final String message;
}
