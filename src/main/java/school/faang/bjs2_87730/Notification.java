package school.faang.bjs2_87730;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Notification {
    private NotificationType type;
    @Setter private String message;
}
