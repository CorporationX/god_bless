package faang.school.godbless.task.lambda.gmail.rich.filters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Email {
    private String subject;
    private String body;
    private boolean isImportant;
}
