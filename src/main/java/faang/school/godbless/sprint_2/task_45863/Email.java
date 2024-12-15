package faang.school.godbless.sprint_2.task_45863;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Email {
    private String subject;
    private String body;
    private boolean isImportant;
}
