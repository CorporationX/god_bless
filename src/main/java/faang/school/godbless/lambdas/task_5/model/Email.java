package faang.school.godbless.lambdas.task_5.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Email {
    private final String subject;
    private final String body;
    private final boolean isImportant;
}
