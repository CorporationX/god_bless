package school.faang.bjs2_80553;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.function.Predicate;

@Data
@AllArgsConstructor
public class Notification {
    private NotificationType type;
    private String message;

}
