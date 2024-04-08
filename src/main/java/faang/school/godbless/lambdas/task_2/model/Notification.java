package faang.school.godbless.lambdas.task_2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Notification {
    private final String type;
    private final String message;
}