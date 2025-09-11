package school.faang.bjs2_87662;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Notification {
    private final NotificationType type;
    @Setter
    private String message;
}
