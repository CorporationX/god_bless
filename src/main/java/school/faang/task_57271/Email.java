package school.faang.task_57271;

import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Email {
    private String subject;
    private String body;
    private boolean isImportant;
}
