package faang.school.godbless.task19;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Email {
    public String subject;
    public String body;
    public boolean isImportant;
}
