package school.faang.functional_interfaces.bjs2_70663.meta_universe;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Notification {
    private final NotificationType notificationType;
    private String message;
}
