package school.faang.task_45959;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class Email {
    private final String subject;
    private String body;
    private final boolean isImportant;
}
