package school.faang.bjs2_87592;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Notification {

    private NotificationType type;
    private String message;
}
