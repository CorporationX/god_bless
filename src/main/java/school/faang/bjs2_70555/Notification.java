package school.faang.bjs2_70555;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Getter
@AllArgsConstructor
public class Notification {
    private final NotificationType type;
    @Setter
    private String message;
}
