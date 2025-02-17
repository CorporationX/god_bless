package school.faang.task_59633;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Email {
    String subject;
    String body;
    boolean isImportant;
}
