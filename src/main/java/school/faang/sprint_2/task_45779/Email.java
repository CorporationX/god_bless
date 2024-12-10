package school.faang.sprint_2.task_45779;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
public class Email {
    private final String subject;
    private String body;
    private final boolean isImportant;
}
