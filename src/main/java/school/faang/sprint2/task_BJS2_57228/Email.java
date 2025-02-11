package school.faang.sprint2.task_BJS2_57228;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Email {
    private String subject;
    private String body;
    private boolean isImportant;

    public boolean isImportant() {
        return isImportant;
    }
}
