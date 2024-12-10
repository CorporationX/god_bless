package school.faang.spring2.task_45849;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Email {
    private String subject;
    @Setter
    private String body;
    private boolean isImportant;
}
