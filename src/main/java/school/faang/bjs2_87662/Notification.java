package school.faang.bjs2_87662;

import lombok.*;

@Getter
@AllArgsConstructor
@ToString(includeFieldNames = true)
@EqualsAndHashCode
public class Notification {
    private final NotificationType type;
    @Setter
    private String message;
}
