package faang.school.godbless.multithreading_synchronization.task_7;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class Chat {
    private final User currentUser;
    private final User targetUser;
    private final String message;
}
