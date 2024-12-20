package school.faang.sprint2.task_46926;

import lombok.*;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
public class Notification {
    private String type;
    @Setter
    private String message;
}
