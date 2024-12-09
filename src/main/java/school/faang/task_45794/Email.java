package school.faang.task_45794;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@Getter
@Setter
public class Email {
    private final String subject;
    private String body;
    private final boolean isImportant;
}
