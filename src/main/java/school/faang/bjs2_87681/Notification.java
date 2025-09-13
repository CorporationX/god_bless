package school.faang.bjs2_87681;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Notification {
    private NotificationType type;
    private final String message;


}