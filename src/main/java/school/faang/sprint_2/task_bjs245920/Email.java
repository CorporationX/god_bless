package school.faang.sprint_2.task_bjs245920;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Email {
    private final String subject;
    @Setter
    private String body;
    private final boolean isImportant;
}
