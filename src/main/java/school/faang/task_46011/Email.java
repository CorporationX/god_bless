package school.faang.task_46011;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Email {

    private String subject;
    private String body;
    private boolean isImportant;
}
