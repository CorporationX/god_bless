package school.faang.bjs2_87681;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Getter
public class Notification {
    @NonNull
    private NotificationType type;
    @NonNull
    private final String message;
}